package cn.lkpttxg.sept2.worldofzuul.settings.web.controller;

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
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 *
 * @author PpxiA
 */
@Controller
public class UserController{
    @Resource
    private UserService userService;

}