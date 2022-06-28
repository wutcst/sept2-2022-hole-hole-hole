package cn.lkpttxg.sept2.worldofzuul.workbench.web.controller.player;


import cn.lkpttxg.sept2.worldofzuul.workbench.core.Game;
import cn.lkpttxg.sept2.worldofzuul.workbench.service.player.PlayerService;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 玩家controller
 *
 * @author TXG & PpxiA
 */
@Api(tags = "玩家模块")
@RestController
@RequestMapping("/player")
public class PlayerController {
  @Resource
  private PlayerService playerService;
  @Resource
  private Game game;
}
