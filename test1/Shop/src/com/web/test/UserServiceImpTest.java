package com.web.test;

import com.web.bean.User;
import com.web.service.UserSerice;
import com.web.service.imp.UserServiceImp;
import org.junit.Test;

/**
 * @Author Administrator
 * @Date 2021/11/22 19:22
 * @Version 1.0
 */
public class UserServiceImpTest {

    UserSerice userSerice=new UserServiceImp();
    @Test
    public void registUser() {
        userSerice.registUser(new User(null,"bbj1681","bbj","bbj168@163.com"));
    }

    @Test
    public void login() {
        System.out.println(userSerice.login(new User(null, "bbj1681", "bbj", null)));
    }

    @Test
    public void existsUsername() {
        System.out.println(userSerice.existsUsername("bbj1681"));
    }
}