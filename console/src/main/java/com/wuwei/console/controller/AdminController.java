package com.wuwei.console.controller;

import com.wuwei.console.service.SessionService;
import com.wuwei.console.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @auther XuXin
 * @date 2019/3/12 16:18
 */
@Controller
public class AdminController {


    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public ModelAndView getIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("common");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(String email,String password) {
        boolean error ;
        ModelAndView mv = new ModelAndView();
        if (email != null & !"".equals(email) &password!=null &!"".equals(password)) {
            error = userService.isUser(email,password);
            if (error) {
                //登录成功
                mv.setViewName("common");
            }else {
                mv.addObject("error", "账号或密码错误");
            }
            return mv;

        }
        mv.setViewName("login");
        return mv;
    }


    @GetMapping("/logout")
    public String logout(){
        sessionService.logout();
        return  "login";
    }
}

