package cn.lkpttxg.sept2.worldofzuul.web.controller.filter.config;

import com.thetransactioncompany.cors.CORSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author TXG
 * @date 2022/6/28$
 */
@Configuration
public class SystemConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean reg = new FilterRegistrationBean();
        //使用哪个过滤器
        reg.setFilter(new CORSFilter());
        //获取过滤器地址
        reg.addUrlPatterns("/*");
        return reg;
    }
}
