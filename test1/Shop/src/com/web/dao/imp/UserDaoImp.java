package com.web.dao.imp;

import com.web.bean.User;
import com.web.dao.UserDao;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/11/19 21:55
 * @Version 1.0
 */
public class UserDaoImp extends BaseDao implements UserDao {
//    public static void main(String[] args) {
//        List<User> users = new UserDaoImp().queryAllUsers();
//        for (int i = 0; i < users.size(); i++) {
//            System.out.println(users.get(i));
//        }
//    }

    @Override
    public User queryUserByUsername(String username) {
        String sql = " Select `id`,`username`,`password`,'email' from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = " Select `id`,`username`,`password`,'email' from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public List<User> queryAllUsers() {
        String sql = "select `id`,`username`,`password`,`email` from t_user";
        return queryForList(User.class, sql);
    }
}
