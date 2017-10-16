package com.lanou.service.impl;

import com.lanou.dao.UserDao;
import com.lanou.dao.impl.UserDaoImpl;
import com.lanou.domain.User;
import com.lanou.service.UserService;

/**
 * Created by dllo on 17/10/11.
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
//     登录
    @Override
    public User login(User user) {
//        调用dao层的登录方法
        return dao.login(user);
    }
//    注册
    @Override
    public int register(User user) {
//        调用dao层的注册方法
        return dao.register(user);
    }
}
