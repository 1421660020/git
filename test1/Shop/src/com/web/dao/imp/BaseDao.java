package com.web.dao.imp;

import com.web.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/11/22 2:07
 * @Version 1.0
 */
public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update()方法用来执行Insert\Update\Delete语句
     *
     * @param sql  sql语句
     * @param args 对应的参数
     * @return 若返回-1则执行失败返回其他表示受影响的行数
     */
    public int update(String sql, Object... args) {
        Connection c = JdbcUtil.getConnection();
        try {
            return queryRunner.update(c, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(c);
        }
        return -1;
    }

    /**
     * 查询返回一个JavaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  sql语句
     * @param args sql对应的参数
     * @param <T>  返回的类型的泛型
     * @return 若返回为null则查询失败
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection c = JdbcUtil.getConnection();
        try {
            return queryRunner.query(c, sql, new BeanHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(c);
        }
        return null;
    }

    /**
     * 查询返回多个JavaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  sql语句
     * @param args sql对应的参数
     * @param <T>  返回的类型的泛型
     * @return 若返回为null则查询失败
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection c = JdbcUtil.getConnection();
        try {
            return queryRunner.query(c, sql, new BeanListHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(c);
        }
        return null;
    }

    /**
     *  执行返回一行一列的sql语句
     * @param sql  sql语句
     * @param args sql语句对应的参数
     * @return 若为null则查询失败
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection c = JdbcUtil.getConnection();
        try {
            return queryRunner.query(c, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(c);
        }
        return null;
    }



}
