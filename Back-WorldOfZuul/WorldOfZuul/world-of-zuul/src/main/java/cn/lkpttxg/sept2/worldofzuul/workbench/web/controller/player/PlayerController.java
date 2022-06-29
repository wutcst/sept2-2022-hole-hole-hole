package cn.lkpttxg.sept2.worldofzuul.workbench.web.controller.player;

import cn.lkpttxg.sept2.worldofzuul.bean.ResponseData;
import cn.lkpttxg.sept2.worldofzuul.bean.ResultGenerator;
import cn.lkpttxg.sept2.worldofzuul.common.consts.ActionResult;
import cn.lkpttxg.sept2.worldofzuul.common.enums.resultCode.ResultCode;
import cn.lkpttxg.sept2.worldofzuul.workbench.core.Game;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.Item;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Food;
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
import cn.lkpttxg.sept2.worldofzuul.bean.NullObject;
import cn.lkpttxg.sept2.worldofzuul.bean.ResponseData;
import cn.lkpttxg.sept2.worldofzuul.bean.ResultGenerator;
import cn.lkpttxg.sept2.worldofzuul.common.enums.resultCode.ResultCode;
import cn.lkpttxg.sept2.worldofzuul.workbench.core.Game;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Weapon;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.monster.Monster;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.player.Player;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import cn.lkpttxg.sept2.worldofzuul.workbench.service.room.RoomService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author TXG & PpxiA
 * @date 2022/6/28$
 */
@Api(tags = "玩家模块")
@RestController
@RequestMapping("/player")
public class PlayerController {

  @Resource
  private PlayerService playerService;
  @Resource
  private Game game;
  @Resource
  private RoomService roomService;

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
    Item item = player.getCurrentRoom().getItem(location);
    if (result.equals(ActionResult.MISS)) {
      return ResultGenerator.genOtherResult(ResultCode.FAIL, "此位置没有物品！");
    } else if (result.equals(ActionResult.OVERWEIGHT)) {
      return ResultGenerator.genFailResult("你当前能够负重：" + player.getWeight() +
         " 物品重量为：" + item.getWeight() +
          " 拾取失败，超重！");
    } else {
      player.convertJson();
      return ResultGenerator.genSuccessResult("成功拾取" + item.getName(), player);
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
    Item item = player.getItem(id);
    if(item == null){
      return ResultGenerator.genFailResult("背包中不存在此物品！");
    }
    playerService.throwAway(player, id);
    player.convertJson();
    return ResultGenerator.genSuccessResult("成功丢弃" + item.getName()
        + " 你当前负重为：" + player.getWeight(), player);
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
    Item item = player.getItem(id);
    if(item == null){
      return ResultGenerator.genFailResult("背包中不存在此物品！");
    }
    Integer result = playerService.eat(player, id);
    if (result.equals(ActionResult.UNMATCH)) {
      return ResultGenerator.genFailResult("你居然想吃" + item.getName() + "!???");
    } else {
      player.convertJson();
      return ResultGenerator.genSuccessResult("你成功吃了" + item.getName(), player);
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
    Item item = player.getItem(id);
    if(item == null){
      return ResultGenerator.genFailResult("背包中不存在此物品！");
    }
    Integer result = playerService.equipWeapon(player, id);
    if (result.equals(ActionResult.UNMATCH)) {
      return ResultGenerator.genFailResult("此物品无法装备！");
    } else {
      player.convertJson();
      return ResultGenerator.genSuccessResult("成功装备" + item.getName(), player);
    }
  }

    @ApiOperation(value = "根据玩家Id获取玩家信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "玩家Id",required = true,paramType = "path",dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功返回，data包含玩家信息"),
            @ApiResponse(code = 400,message = "playId错误，游戏中无该玩家")
    })
    @GetMapping("/{id}")
    public ResponseData<Player> getPlayerById(@PathVariable(value = "id") String id){
        Player player = game.getPlayer(id);
        if(player == null){
            return ResultGenerator.genFailResult("无该玩家");
        }else {
            player.convertJson();
            return ResultGenerator.genSuccessResult(player);
        }
    }


    @ApiOperation(value = "玩家前往另一个房间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "玩家Id",required = true,paramType = "path",dataType = "String"),
            @ApiImplicitParam(name = "direction",value = "玩家要走的方向",required = true,paramType = "path",dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功返回下一个普通房间的信息,data中存储房间信息"),
            @ApiResponse(code = 300,message = "前往的是传送房间,message中包含的是该传送房间的描述,data中存储玩家被传送到的随机房间信息"),
            @ApiResponse(code = 400,message = "对应的方向没有房间了"),
            @ApiResponse(code = 404,message = "玩家id错误，无该玩家")
    })
    @GetMapping("/next/{id}/{direction}")
    public ResponseData<Room> getNextRoom(@PathVariable(value = "id") String id,@PathVariable(value = "direction")String direction){
        Player player = game.getPlayer(id);
        if(player == null){
            return ResultGenerator.genFailResult("无该玩家");
        }else {
            Room currentRoom = player.getCurrentRoom();
            Room nextRoom = roomService.getNextRoom(currentRoom.getId(),direction);
            if(nextRoom == null){
                return ResultGenerator.genOtherResult(ResultCode.FAIL,direction+"没有房间了");
            }
            if(nextRoom.isTransferRoom()){
                Room randomRoom = roomService.getRandomRoom();
                player.getOldRooms().push(currentRoom);
                player.setCurrentRoom(randomRoom);
                return ResultGenerator.genOtherResult(ResultCode.MIDDLE,nextRoom.getDescription(),randomRoom);
            }
            player.getOldRooms().push(currentRoom);
            player.setCurrentRoom(nextRoom);
            return ResultGenerator.genSuccessResult("你来到了一个新的房间！",nextRoom);
        }
    }

    @ApiOperation(value = "玩家回到上一个房间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "玩家Id",required = true,paramType = "path",dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功回到上一个房间，data是房间信息"),
            @ApiResponse(code = 300,message = "已是初始房间"),
            @ApiResponse(code = 404,message = "玩家id错误，无该玩家")
    })
    @GetMapping("/back/{id}")
    public ResponseData<Room> getBackRoom(@PathVariable(value = "id") String id) {
        Player player = game.getPlayer(id);
        if (player == null) {
            return ResultGenerator.genFailResult("玩家id错误，无该玩家");
        } else {
            int size = player.getOldRooms().size();
            if (size == 0) {
                return ResultGenerator.genOtherResult(ResultCode.MIDDLE, "当前已经是最初始的房间了");
            } else {
                Room backRoom = player.getOldRooms().pop();
                player.setCurrentRoom(backRoom);
                return ResultGenerator.genSuccessResult("你回到了上一个房间",backRoom);
            }
        }
    }

    @ApiOperation(value = "玩家攻击怪物",notes = "message均返回的是输出到控制台的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "玩家Id",required = true,paramType = "path",dataType = "String"),
            @ApiImplicitParam(name = "location",value = "怪物位置",required = true,paramType = "query",dataType = "Integer")

    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "攻击成功,data返回玩家的信息"),
            @ApiResponse(code = 400,message = "攻击失败，怪物不存在"),
            @ApiResponse(code = 404,message = "玩家id错误，无该玩家"),
            @ApiResponse(code = 500,message = "玩家死亡，游戏结束"),
    })
    @GetMapping("/attack/{id}")
    public ResponseData<Player> getBackRoom(@PathVariable(value = "id") String id,@RequestParam(value = "location") int location) {
        Player player = game.getPlayer(id);
        String message = "";
        if (player == null) {
            return ResultGenerator.genFailResult("玩家id错误，无该玩家");
        }
        //获取当前房间的事物
        Object[] items = player.getCurrentRoom().getObjects();
        if(!(items[location] instanceof Monster)){
            return ResultGenerator.genOtherResult(ResultCode.FAIL,"攻击失败，怪物不存在");
        }
        message +="玩家攻击成功\n";
        //获取怪物
        Monster monster = (Monster) items[location];
        //人物血量
        int playerHealth = player.getHealth();
        //人物攻击
        int playerAttack = player.getAttack();
        //怪物攻击
        int monsterAttack = monster.getAttack();
        //怪物血量
        int monsterHealth = monster.getHealth();
        //攻击后人物血量
        playerHealth = Math.max(0,playerHealth-monsterAttack);
        message +="玩家还有"+playerHealth+"滴血\n";
        //攻击后怪物血量
        monsterHealth =  Math.max(0,monsterHealth-playerAttack);
        message +="怪物还有"+monsterHealth+"滴血\n";
        //如果有武器，则还掉耐久
        if(player.getWeapon()!=null){
            Weapon weapon = player.getWeapon();
            player.getWeapon().setDurable(player.getWeapon().getDurable()-1);
            message +="武器耐久还有"+weapon.getDurable()+"\n";
            if(player.getWeapon().getDurable()==0){
                player.setWeapon(null);
                player.setWeight(player.getWeight()+weapon.getWeight());
                message +="武器损坏！！！"+"\n";
            }
        }
        monster.setHealth(monsterHealth);
        if(monsterHealth==0){
            message +="怪物死亡！！！\n";
            int mon  =(int)(5*Math.random()+1);
            message +="怪物掉落了"+mon+"个金币\n";
            if(playerHealth!=0){
                player.setMoney(player.getMoney()+mon);
            }
            items[location] = new NullObject();
        }
        player.setHealth(playerHealth);
        if(playerHealth == 0){
            message +="玩家死亡！！！\n";
            return ResultGenerator.genOtherResult(ResultCode.PLAYER_DIED,message);
        }else {
            player.convertJson();
            return ResultGenerator.genSuccessResult(message,player);
        }
    }
}
