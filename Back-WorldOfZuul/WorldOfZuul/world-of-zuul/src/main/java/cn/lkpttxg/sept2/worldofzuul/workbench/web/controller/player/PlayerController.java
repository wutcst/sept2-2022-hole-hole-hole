package cn.lkpttxg.sept2.worldofzuul.workbench.web.controller.player;


import cn.lkpttxg.sept2.worldofzuul.bean.ResponseData;
import cn.lkpttxg.sept2.worldofzuul.bean.ResultGenerator;
import cn.lkpttxg.sept2.worldofzuul.common.consts.ActionResult;
import cn.lkpttxg.sept2.worldofzuul.common.enums.resultCode.ResultCode;
import cn.lkpttxg.sept2.worldofzuul.workbench.core.Game;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.player.Player;
import cn.lkpttxg.sept2.worldofzuul.workbench.service.player.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 玩家controller.
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

  /**
   * 玩家拾取物品controller.
   *
   * @param playerId 玩家id
   * @param location 物品位置
   * @return 请求状态码和玩家对象
   */
  @ApiOperation(value = "拾取物品", notes = "拾取指定位置的物品")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "playerId", value = "玩家编号",
          required = true, paramType = "path", dataType = "String"),
      @ApiImplicitParam(name = "location", value = "物品坐标",
          required = true, paramType = "query", dataType = "String")})
  @ApiResponses({
      @ApiResponse(code = 200, message = "成功拾取"),
      @ApiResponse(code = 400, message = "此位置没有物品"),
      @ApiResponse(code = 404, message = "拾取失败，超重")
  })
  @GetMapping("pick/{playerId}")
  public ResponseData<Player> pick(@PathVariable(value = "playerId") String playerId,
      Integer location) {
    Player player = game.getPlayer(playerId);
    Integer result = playerService.pick(player, location);
    if (result.equals(ActionResult.MISS)) {
      return ResultGenerator.genOtherResult(ResultCode.FAIL, "此位置没有物品！");
    } else if (result.equals(ActionResult.OVERWEIGHT)) {
      return ResultGenerator.genFailResult("拾取失败，超重！");
    } else {
      return ResultGenerator.genSuccessResult(player);
    }
  }

  /**
   * 玩家丢弃物品controller.
   *
   * @param playerId 玩家id
   * @param id 物品编号
   * @return 请求状态码和玩家对象
   */
  @ApiOperation(value = "丢弃物品", notes = "丢弃指定的物品")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "playerId", value = "玩家编号",
          required = true, paramType = "path", dataType = "String"),
      @ApiImplicitParam(name = "id", value = "物品编号",
          required = true, paramType = "query", dataType = "String")})
  @ApiResponses({
      @ApiResponse(code = 200, message = "成功丢弃"),
  })
  @GetMapping("throw/{playerId}")
  public ResponseData<Player> throwAway(@PathVariable(value = "playerId") String playerId,
      String id) {
    Player player = game.getPlayer(playerId);
    playerService.throwAway(player, id);
    return ResultGenerator.genSuccessResult(player);
  }

  /**
   * 玩家吃物品controller.
   *
   * @param playerId 玩家id
   * @param id 物品编号
   * @return 请求状态码和玩家对象
   */
  @ApiOperation(value = "吃食物", notes = "吃指定的物品")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "playerId", value = "玩家编号",
          required = true, paramType = "path", dataType = "String"),
      @ApiImplicitParam(name = "id", value = "物品编号",
          required = true, paramType = "query", dataType = "String")})
  @ApiResponses({
      @ApiResponse(code = 200, message = "成功吃"),
      @ApiResponse(code = 404, message = "物品不能吃"),
  })
  @GetMapping("eat/{playerId}")
  public ResponseData<Player> eat(@PathVariable(value = "playerId") String playerId,
      String id) {
    Player player = game.getPlayer(playerId);
    Integer result = playerService.eat(player, id);
    if (result.equals(ActionResult.UNMATCH)) {
      return ResultGenerator.genFailResult("物品不能吃！");
    } else {
      return ResultGenerator.genSuccessResult(player);
    }
  }

  /**
   * 玩家装备物品controller.
   *
   * @param playerId 玩家id
   * @param id 物品编号
   * @return 请求状态码和玩家对象
   */
  @ApiOperation(value = "装备武器", notes = "装备指定的物品")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "playerId", value = "玩家编号",
          required = true, paramType = "path", dataType = "String"),
      @ApiImplicitParam(name = "id", value = "物品编号",
          required = true, paramType = "query", dataType = "String")})
  @ApiResponses({
      @ApiResponse(code = 200, message = "成功装备"),
      @ApiResponse(code = 404, message = "物品不能装备"),
  })
  @GetMapping("equip/{playerId}")
  public ResponseData<Player> equip(@PathVariable(value = "playerId") String playerId,
      String id) {
    Player player = game.getPlayer(playerId);
    Integer result = playerService.equipWeapon(player, id);
    if (result.equals(ActionResult.UNMATCH)) {
      return ResultGenerator.genFailResult("此物品无法装备！");
    } else {
      return ResultGenerator.genSuccessResult(player);
    }
  }
}
