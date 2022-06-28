package cn.lkpttxg.sept2.worldofzuul;


import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.WeaponTypes;
import cn.lkpttxg.sept2.worldofzuul.workbench.core.Game;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Weapon;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.player.Player;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;

import java.util.Stack;

@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
@SpringBootApplication
@MapperScan("cn.lkpttxg.sept2.worldofzuul.settings.dao")
public class WorldOfZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldOfZuulApplication.class, args);
	}

}
