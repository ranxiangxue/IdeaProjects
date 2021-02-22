package com.course.sever;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("/v1")
public class MyPostMethod {
    private static Cookie cookie;//装cookies信息的变量

    //登录成功获取cookies，然后在访问其他接口获取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod ="POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username",required = true) String nsername,
                        @RequestParam(value = "password",required = true) String password){
        if (nsername.equals("zhangsan")&&password.equals("123456")){
            cookie =new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登录成功了！";
        }
        return "用户名或者密码错误！";
    }
}
