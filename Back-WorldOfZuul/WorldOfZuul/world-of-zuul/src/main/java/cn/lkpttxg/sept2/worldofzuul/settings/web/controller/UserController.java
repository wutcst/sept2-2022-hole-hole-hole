package cn.lkpttxg.sept2.worldofzuul.settings.web.controller;

import cn.lkpttxg.sept2.worldofzuul.bean.ResponseData;
import cn.lkpttxg.sept2.worldofzuul.bean.ResultGenerator;
import cn.lkpttxg.sept2.worldofzuul.settings.entity.user.User;
import cn.lkpttxg.sept2.worldofzuul.settings.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 *
 * @author PpxiA
 */
@RestController
@RequestMapping("/users")
@Api("用户模块")
public class UserController{
    @Resource
    private UserService userService;

    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户名",
            required = true,paramType = "body", dataType = "String"),
        @ApiImplicitParam(name = "password", value = "密码",
            required = true,paramType = "body", dataType = "String")})
    @ApiResponses({
        @ApiResponse(code = 200,message = "成功登录"),
        @ApiResponse(code = 400,message = "登录失败"),
        @ApiResponse(code = 404,message = "请求的路径没有或者页面跳转路径不对")
    })
    @PostMapping("/login")
    public ResponseData login(String username, String password){
        User user = userService.login(username, password);
        if(user == null){
            return ResultGenerator.genFailResult("用户名或密码错误！");
        }else{
            return ResultGenerator.genSuccessResult();
        }
    }

    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户名",
            required = true,paramType = "body", dataType = "String"),
        @ApiImplicitParam(name = "playerName", value = "玩家名",
            required = true,paramType = "body", dataType = "String"),
        @ApiImplicitParam(name = "email", value = "邮箱",
            required = true,paramType = "body", dataType = "String"),
        @ApiImplicitParam(name = "password", value = "密码",
            required = true,paramType = "body", dataType = "String")})
    @ApiResponses({
        @ApiResponse(code = 200,message = "注册成功"),
        @ApiResponse(code = 400,message = "注册失败"),
        @ApiResponse(code = 404,message = "请求的路径没有或者页面跳转路径不对")
    })
    @PostMapping("/register")
    public ResponseData register(String username, String playerName, String email, String password){
        if(userService.register(username, playerName, email, password)){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("存在同名用户！");
        }
    }
}