package lk.ijse.dep.pos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@EnableJpaRepositories("lk.ijse.dep.pos.repository")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@Configuration
public class JPAConfig {

    @Autowired
    private Environment env;

    @Bean
    public static PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource());
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
        lcemfb.setJpaProperties(jpaProperties());
        lcemfb.setPackagesToScan("lk.ijse.dep"); //fix to the Meta-INF/persistence unit missing error
        return lcemfb;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getRequiredProperty("javax.persistence.jdbc.driver"));
        ds.setPassword(env.getRequiredProperty("javax.persistence.jdbc.password"));
        ds.setUrl(env.getRequiredProperty("javax.persistence.jdbc.url"));
        ds.setUsername(env.getRequiredProperty("javax.persistence.jdbc.user"));
        return ds;
    }


    // Another way to set jpa properties
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));
        hibernateJpaVendorAdapter.setShowSql(env.getRequiredProperty("hibernate.show_sql",Boolean.class));
//        hibernateJpaVendorAdapter.setGenerateDdl(true); //1 way to set hibernate to ddl auto
//        hibernateJpaVendorAdapter.setGenerateDdl(env.getRequiredProperty("hibernate.hbm2ddl.auto").equals("update")?true:false); //2nd method

        return hibernateJpaVendorAdapter;
    }

    private Properties jpaProperties(){
        Properties properties = new Properties();
//        properties.put("hibernate.dialect",env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto",env.getRequiredProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.show_sql",env.getRequiredProperty("hibernate.show_sql"));
//        properties.put("hibernate.dialect",env.getRequiredProperty("hibernate.dialect"));
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }

}
