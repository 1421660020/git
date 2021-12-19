package com.web.service;

import com.web.bean.User;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/11/21 16:47
 * @Version 1.0
 */
public interface UserSerice {

    /**
     * 注册用户
     *
     * @param user 用户
     */
    void registUser(User user);

    /**
     * 登录
     *
     * @param user 用户
     * @return 返回true登录成功，否则失败
     */
    boolean login(User user);

    /**
     * 检测用户是否可用
     *
     * @param username 用户名
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    boolean existsUsername(String username);

    List<User> showAllUser();

}
