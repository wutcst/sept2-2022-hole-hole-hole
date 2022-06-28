package cn.lkpttxg.sept2.worldofzuul.workbench.dao.config;

import cn.lkpttxg.sept2.worldofzuul.workbench.dao.PlayerDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * playerDao配置类
 *
 * @author PpxiA
 */
@Configuration
public class PlayerDaoConfiguration {

  @Bean
  public PlayerDao createPlayerDao(){
    return new PlayerDao();
  }
}
