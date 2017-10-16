package com.lanou.dao.impl;

import com.lanou.dao.UserDao;
import com.lanou.domain.User;
import com.lanou.util.TxQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by dllo on 17/10/11.
 */
public class UserDaoImpl implements UserDao {
    private TxQueryRunner qr = new TxQueryRunner();

    // 登录
    @Override
    public User login(User user) {
//        定义查询语句
        String sql = "select * from table_user where username=? and password = ?";
//        定义参数数组
        Object[] params = {user.getUsername(),user.getPassword()};
//        调用查询语句
        try {
            User u = qr.query(sql, new BeanHandler<User>(User.class), params);
            return u; // 将查询的用户对象作为方法返回值返回
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 注册
    @Override
    public int register(User user) {
        String sql = "insert into table_user(username,password,gender,hobbies) values(?,?,?,?)";
        Object[] params = {user.getUsername(),user.getPassword(),user.getGender(),user.getHobbies()};
        try {
               return qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
