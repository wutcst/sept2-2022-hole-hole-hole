package cn.lkpttxg.sept2.worldofzuul.settings.web.controller;

import cn.lkpttxg.sept2.worldofzuul.settings.entity.user.User;
import cn.lkpttxg.sept2.worldofzuul.settings.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 *
 * @author PpxiA
 */
@Controller
@RequestMapping("/user")
public class UserController{
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(String username, String password){
        User user = userService.login(username, password);
        if(user == null){
            return "null";
        }else{
            return "success";
        }
    }

    @ResponseBody
    @RequestMapping("/register")
    public String register(String username, String playerName, String email, String password){
        if(userService.register(username, playerName, email, password)){
            return "success";
        }else{
            return "false";
        }
    }
}