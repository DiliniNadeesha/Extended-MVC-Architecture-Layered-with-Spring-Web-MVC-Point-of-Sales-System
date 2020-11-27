package lk.ijse.dep.pos;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class)
@ComponentScan("lk.ijse.dep.pos")
public class WebRootConfig {
}
