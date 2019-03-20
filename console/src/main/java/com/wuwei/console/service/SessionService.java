package com.wuwei.console.service;

import com.wuwei.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**session服务
 * @auther XuXin
 * @date 2019/3/14 10:54
 */
@Transactional
@Service
public class SessionService {
    @Autowired
    private HttpSession session;


    /**
     * 菜单业保存至session
     */
     public  void setUser(User user){
        session.setAttribute("user",user);
    }


    /**
     * 获取用户信息
     * @return
     */
    public User getUser(){
         return (User)session.getAttribute("user");
    }

    public void logout() {
        session.removeAttribute("user");
    }
}
