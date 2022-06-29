package cn.lkpttxg.sept2.worldofzuul.workbench.web.controller.room;

import cn.lkpttxg.sept2.worldofzuul.bean.ResponseData;
import cn.lkpttxg.sept2.worldofzuul.bean.ResultGenerator;
import cn.lkpttxg.sept2.worldofzuul.common.enums.resultCode.ResultCode;
import cn.lkpttxg.sept2.worldofzuul.workbench.core.Game;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.player.Player;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import cn.lkpttxg.sept2.worldofzuul.workbench.service.room.RoomService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author TXG
 * @date 2022/6/28$
 */
@Api(tags = "房间模块")
@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Resource
    private RoomService roomService;
    @Resource
    private Game game;

    @ApiOperation(value = "根据房间ID获取房间信息",notes = "房间ID是游戏内房间的唯一ID，其中普通房间以3XXX开头，传送房间以4XXX开头")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "房间ID",paramType = "path",allowableValues = "3001,3002,3003,3004,3005,4001",required = true,dataType = "String",example = "3001")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功返回房间信息"),
            @ApiResponse(code = 404,message = "无该房间信息")
    })
    @GetMapping("/{id}")
    public ResponseData<Room> getRoomByRoomId(@PathVariable(value = "id") String id){
        Room room = roomService.getRoomByRoomId(id);
        if(room == null){
            return ResultGenerator.genFailResult("游戏内无该房间");
        }
        return ResultGenerator.genSuccessResult(room);
    }

    @ApiOperation(value = "获取下一个方向的房间的信息",notes = "获取的方向是东南西北(east,south,west,north)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "玩家所处的房间ID",paramType = "path",allowableValues = "3001,3002,3003,3004,3005,4001",required = true,dataType = "String",example = "3001"),
            @ApiImplicitParam(name = "direction",value = "该房间的某一方向",paramType = "path",allowableValues = "north,south,west,east",required = true,dataType = "String",example = "north")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功返回下一个普通房间的信息,data中存储房间信息"),
            @ApiResponse(code = 300,message = "前往的是传送房间,message中包含的是该传送房间的描述,data中存储玩家被传送到的随机房间信息"),
            @ApiResponse(code = 400,message = "对应的方向没有房间了"),
            @ApiResponse(code = 404,message = "id错误，游戏中无该id的房间")
    })
    @GetMapping("/{id}/{direction}")
    public ResponseData<Room> getNewRoom(@PathVariable(value = "id") String id,@PathVariable(value = "direction")String direction){
        //获取该id房间的某个方向的下一个房间
        if(roomService.getRoomByRoomId(id)==null){
            return ResultGenerator.genFailResult("id错误，没有该房间信息");
        }
        Room room = roomService.getNextRoom(id,direction);
        if(room == null){
            return ResultGenerator.genOtherResult(ResultCode.FAIL,direction+"没有房间了");
        }
        if(room.isTransferRoom()){
            Room randomRoom = roomService.getRandomRoom();
            return ResultGenerator.genOtherResult(ResultCode.MIDDLE,room.getDescription(),randomRoom);
        }
        return ResultGenerator.genSuccessResult(room);
    }


    @ApiOperation(value = "根据id获取房间的短描述",notes = "房间ID是游戏内房间的唯一ID，其中普通房间以3XXX开头，传送房间以4XXX开头")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "玩家所处的房间ID",paramType = "path",allowableValues = "3001,3002,3003,3004,3005,4001",required = true,dataType = "String",example = "3001")
                })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功返回,data中包含描述信息"),
            @ApiResponse(code = 404,message = "id错误，游戏中无该id的房间")
    })
    @GetMapping("/description/{id}")
    public ResponseData<String> getRoomDescription(@PathVariable(value = "id") String id){
       Room room = roomService.getRoomByRoomId(id);
       if(room==null){
           return ResultGenerator.genFailResult("游戏内无该房间");
       }
       return ResultGenerator.genSuccessResult(room.getDescription());
    }

    @ApiOperation(value = "根据id获取房间的长描述",notes = "房间ID是游戏内房间的唯一ID，其中普通房间以3XXX开头，传送房间以4XXX开头")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "玩家所处的房间ID",paramType = "path",allowableValues = "3001,3002,3003,3004,3005,4001",required = true,dataType = "String",example = "3001")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功返回，data中包含描述信息"),
            @ApiResponse(code = 404,message = "id错误，游戏中无该id的房间")
    })
    @GetMapping("/longDescription/{id}")
    public ResponseData<String> getRoomLongDescription(@PathVariable(value = "id") String id){
        Room room = roomService.getRoomByRoomId(id);
        if(room==null){
            return ResultGenerator.genFailResult("游戏内无该房间");
        }
        return ResultGenerator.genSuccessResult(room.getLongDescription());
    }

    @ApiOperation(value = "根据id获取房间的所有物品列表",notes = "房间ID是游戏内房间的唯一ID，其中普通房间以3XXX开头，传送房间以4XXX开头")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "玩家所处的房间ID",paramType = "path",allowableValues = "3001,3002,3003,3004,3005,4001",required = true,dataType = "String",example = "3001")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功返回，data包含物品列表25个"),
            @ApiResponse(code = 404,message = "id错误，游戏中无该id的房间")
    })
    @GetMapping("/things/{id}")
    public ResponseData<Object[]> getRoomThings(@PathVariable(value = "id") String id){
        Room room = roomService.getRoomByRoomId(id);
        if(room==null){
            return ResultGenerator.genFailResult("游戏内无该房间");
        }
        return ResultGenerator.genSuccessResult(room.getObjects());
    }

    @ApiOperation(value = "根据id获取房间的所有出口",notes = "房间ID是游戏内房间的唯一ID，其中普通房间以3XXX开头，传送房间以4XXX开头")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "玩家所处的房间ID",paramType = "path",allowableValues = "3001,3002,3003,3004,3005,4001",required = true,dataType = "String",example = "3001")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功返回，返回出口信息"),
            @ApiResponse(code = 404,message = "id错误，游戏中无该id的房间")
    })
    @GetMapping("/exists/{id}")
    public ResponseData<HashMap> getRoomExists(@PathVariable(value = "id") String id){
        Room room = roomService.getRoomByRoomId(id);
        if(room==null){
            return ResultGenerator.genFailResult("游戏内无该房间");
        }
        return ResultGenerator.genSuccessResult(room.getExits());
    }

    @ApiOperation(value = "获取人物目前所在游戏的房间",notes = "如果是新玩家，则从初始房间ouside进入;如果是老玩家，则返回最后一次退出时所在的房间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "playId",value = "玩家id",paramType = "path",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功返回，返回房间信息"),
            @ApiResponse(code = 404,message = "playId错误，游戏中无该玩家")
    })
    @GetMapping("/room/{playId}")
    public ResponseData<Room> getPlayerInitRoom(@PathVariable(value = "playId") String playId){
        //判断用户是否在游戏中了
        Room room;
        Player player = game.getPlayer(playId);
        if(player!=null){
            room = player.getCurrentRoom();
            return ResultGenerator.genSuccessResult(room);
        }else {
            return ResultGenerator.genFailResult("该玩家不存在");

            //return ResultGenerator.genSuccessResult(game.getGameMap().getInitRoom());
        }
    }



}
