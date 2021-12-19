package com.web.test;

import com.web.utils.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;

/**
 * @Author Administrator
 * @Date 2021/11/22 1:54
 * @Version 1.0
 */
public class JdbcUtilTest {

    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection c=JdbcUtil.getConnection();
            System.out.println(c);
            JdbcUtil.close(c);

        }
    }
}
