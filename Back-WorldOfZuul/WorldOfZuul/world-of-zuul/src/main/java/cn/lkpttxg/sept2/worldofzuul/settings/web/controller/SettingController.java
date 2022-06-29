package cn.lkpttxg.sept2.worldofzuul.settings.web.controller;

import cn.lkpttxg.sept2.worldofzuul.bean.ResponseData;
import cn.lkpttxg.sept2.worldofzuul.bean.ResultGenerator;
import cn.lkpttxg.sept2.worldofzuul.workbench.core.Game;
import cn.lkpttxg.sept2.worldofzuul.workbench.dao.PlayerDao;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.player.Player;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author TXG
 * @date 2022/6/29$
 */
@Api(tags = "系统模块")
@RestController
@RequestMapping("/settings")
public class SettingController {
    @Resource
    private Game game;
    @Resource
    private PlayerDao playerDao;

    @ApiOperation(value = "保存玩家信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "玩家Id",required = true,paramType = "query",dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "保存成功"),
            @ApiResponse(code = 404,message = "id错误，保存失败")
    })
    @GetMapping("/save")
    public ResponseData savePlayer(@RequestParam("id") String id){
        Player player = game.getPlayer(id);
        if(player==null){
            return ResultGenerator.genFailResult("id错误，保存失败");
        }else {
            playerDao.createPlayer(player);
            return ResultGenerator.genSuccessResult("保存成功！！！");
        }
    }
}
