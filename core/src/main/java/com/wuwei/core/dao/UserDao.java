package com.wuwei.core.dao;

import com.wuwei.core.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

/**
 * 用户
 * @auther XuXin
 * @date 2019/3/14 11:05
 */
public interface UserDao {

    List<User> login(Map<String,String> queryMap);
}
