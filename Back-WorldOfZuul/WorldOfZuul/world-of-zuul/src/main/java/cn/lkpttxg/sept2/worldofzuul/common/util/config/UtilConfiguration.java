package cn.lkpttxg.sept2.worldofzuul.common.util.config;

import cn.lkpttxg.sept2.worldofzuul.common.util.SerializeUtil;
import cn.lkpttxg.sept2.worldofzuul.common.util.UUIDUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 工具类配置类
 *
 * @author PpxiA
 */
@Configuration
public class UtilConfiguration {

  @Bean
  public SerializeUtil createSerUtil(){
    return new SerializeUtil();
  }
}
