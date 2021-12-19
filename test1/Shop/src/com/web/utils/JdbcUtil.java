package com.web.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author Administrator
 * @Date 2021/11/22 1:23
 * @Version 1.0
 */
public class JdbcUtil {
    private static DruidDataSource druidDataSource;

    static {
        Properties properties = new Properties();
        InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(inputStream);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
          //  System.out.println(druidDataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *  获取连接方法
     * @return 若返回null则获取连接失败
     */
    public static Connection getConnection()  {
        Connection conn=null;
        try {
            conn=druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接方法
     * @param conn 需要关闭的数据库连接
     */
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

    }
}
