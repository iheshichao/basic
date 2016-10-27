package cn.lingban.dubbo.controller;

import cn.lingban.dubbo.po.User;
import cn.lingban.dubbo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by heshichao on 16-8-31.
 */
@Controller
@RequestMapping(value = "/")
@SessionAttributes("currentUser")
@Api(value = "基础controller")
public class BasicController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "登录", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String login(@ApiParam(required = true, value = "用户名") @RequestParam(value = "username") String username, @ApiParam(required = true, value = "密码") @RequestParam(value = "password") String password, ModelMap modelMap) {
        User user = userService.queryUserByName(username);
        modelMap.put("currentUser", user);
        return "index";
    }


}
