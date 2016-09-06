package cn.lingban.dubbo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by heshichao on 16-8-31.
 */
@Controller
@RequestMapping(value = "/")
@SessionAttributes("currentUser")
@Api(value = "dubboController")
public class DubboController {

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "登录")
    public String login(String username, String password, ModelMap modelMap) {
        modelMap.put("currentUser", new User("heshichao", "password"));
        return "index";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map test(@ModelAttribute("currentUser") User user) {
        Map model = new HashMap();
        model.put("username", "heshichao");
        model.put("currentUser", user);
        return model;
    }

}
