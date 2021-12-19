package Sort;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2021/9/8 7:27
 * @Version 1.0
 */
public class Sort<T> {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mytest";
    static final String USER = "root";
    static final String PASS = "123456";
     List<T>  getValues(Map<T, T> h) {
         List<T> l = new ArrayList<>();
         for (T s : h.values()) {
            l.add(s);
        }
        return l;
    }
    @Test
    public void info() throws SQLException {
         testMysql("Select * from mytest_1 where uid = '19'");
         Map<String, String> m=new HashMap<>();
         m.put("1","2");
         m.put("2","2");
         m.put("3","3");
        System.out.println(new Sort<String>().getValues(m));
    }

    public void testMysql(String sql) throws  SQLException {
        Connection conn=null;
        PreparedStatement stmt=null;
        conn= DriverManager.getConnection(DB_URL,USER,PASS);
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            if(sql=="")
            sql = "SELECT * from mytest_1";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String uid  = rs.getString("uid");
                int role1 = rs.getInt("role1");
                // 输出数据
                System.out.print("uid: " + uid+"\t"+"role1："+role1);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }


}
