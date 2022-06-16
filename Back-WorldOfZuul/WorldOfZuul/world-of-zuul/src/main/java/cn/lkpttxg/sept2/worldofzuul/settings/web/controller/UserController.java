package cn.lkpttxg.sept2.worldofzuul.settings.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author TXG
 * @date 2022/6/16$
 */

@RestController
@RequestMapping("/user")
@Api(tags = "用户信息")
public class UserController {
    @ApiOperation(value = "测试接口", notes = "测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "username", paramType = "String", dataType = "String")})
    @GetMapping("/test")
    public String exportEntBaseInfo(@RequestParam(value = "username", required = false) String username) {
        return username+"111";
    }
}
