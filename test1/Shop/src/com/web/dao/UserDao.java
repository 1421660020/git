package com.web.dao;

import com.web.bean.User;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/11/21 16:45
 * @Version 1.0
 */
public interface UserDao {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 若返回null, 说明用户不存在
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 若返回null，则用户名和密码不匹配
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     *
     * @param user 用户
     * @return 若返回0则保存失败
     */
    int saveUser(User user);

    /**
     *
     */
    List<User> queryAllUsers();
}
