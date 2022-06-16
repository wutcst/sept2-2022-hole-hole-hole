package cn.lkpttxg.sept2.worldofzuul;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;

@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
@SpringBootApplication
public class WorldOfZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldOfZuulApplication.class, args);
	}

}
