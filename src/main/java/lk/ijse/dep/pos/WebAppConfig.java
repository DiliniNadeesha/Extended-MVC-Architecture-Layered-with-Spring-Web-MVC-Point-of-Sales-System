package lk.ijse.dep.pos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("lk.ijse.dep.pos.api")
public class WebAppConfig {

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public static MethodValidationPostProcessor methodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
