package cn.lkpttxg.sept2.worldofzuul.workbench.web.controller.player;

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
    /*@Resource
    private PlayerService playerService;*/
    @Resource
    private Game game;
    @Resource
    private RoomService roomService;

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
            return ResultGenerator.genSuccessResult(nextRoom);
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
                return ResultGenerator.genSuccessResult(backRoom);
            }
        }
    }

    @ApiOperation(value = "玩家攻击怪物")
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
            if(playerHealth!=0){
                player.setMoney(player.getMoney()+(int)(5*Math.random()+1));
            }
            items[location] = new NullObject();
        }
        player.setHealth(playerHealth);
        if(playerHealth == 0){
            message +="玩家死亡！！！\n";
            return ResultGenerator.genOtherResult(ResultCode.PLAYER_DIED,message);
        }else {
            return ResultGenerator.genSuccessResult(message,player);
        }
    }


}
