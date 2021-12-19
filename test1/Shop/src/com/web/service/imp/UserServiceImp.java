package com.web.service.imp;

import com.web.bean.User;
import com.web.dao.UserDao;
import com.web.dao.imp.UserDaoImp;
import com.web.service.UserSerice;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/11/21 16:46
 * @Version 1.0
 */
public class UserServiceImp implements UserSerice {
    private UserDao userDao = new UserDaoImp();

    /**
     * 注册用户
     *
     * @param user 用户
     */
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    /**
     * 用户登录方法
     *
     * @param user 用户
     * @return 返回非空登录成功，否则失败
     */
    @Override
    public boolean login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword()) == null;
    }


    /**
     * 检测用户是否可用
     *
     * @param username 用户名
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }

    @Override
    public List<User> showAllUser() {
        return userDao.queryAllUsers();
    }
}
