package com.wuwei.console.service;

import com.wuwei.core.dao.UserDao;
import com.wuwei.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户登录服务层
 * @auther XuXin
 * @date 2019/3/14 11:04
 */
@Transactional
@Service
public class UserService {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserDao userDao;

    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    public boolean isUser(String email,String password){
            boolean error=false;
            Map<String,String> queryMap=new HashMap<>();
            queryMap.put("email",email);
            queryMap.put("password",password);
            List<User> resultUser =userDao.login(queryMap);
            if (resultUser!=null){
                error=true;
                sessionService.setUser(resultUser.get(0));
            }
            return error;
        }
}
