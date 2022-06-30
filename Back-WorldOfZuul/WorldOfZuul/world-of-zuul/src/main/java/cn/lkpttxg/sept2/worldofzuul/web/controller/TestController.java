package cn.lkpttxg.sept2.worldofzuul.web.controller;

import cn.lkpttxg.sept2.worldofzuul.bean.ResponseData;
import cn.lkpttxg.sept2.worldofzuul.bean.ResultGenerator;
import cn.lkpttxg.sept2.worldofzuul.common.enums.room.RoomTypes;
import cn.lkpttxg.sept2.worldofzuul.workbench.core.Game;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Food;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.monster.Monster;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author TXG
 * @date 2022/6/16$
 */

@RestController
@RequestMapping("/test")
@Api(tags = "测试模块")
public class TestController {
    @ApiOperation(value = "测试接口1", notes = "用于测试的第一个例子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名",
                    required = true,paramType = "query", dataType = "String")})
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功测试"),
            @ApiResponse(code = 400,message = "请求的参数没有填好"),
            @ApiResponse(code = 404,message = "请求的路径没有或者页面跳转路径不对")
    })
    @GetMapping("/test")
    public ResponseData<Monster> exportEntBaseInfo(@RequestParam(value = "username", required = false) String username) {
        Room room = new Room(RoomTypes.FOREST);
        return ResultGenerator.genSuccessResult(room);
    }
}
