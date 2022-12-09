package jdbc.util;

import com.mysql.cj.jdbc.Driver;

import javax.xml.transform.Result;
import java.sql.*;

public class JDBCUtils {
    public static Connection getConn(){
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdql?useUnicode=true&characterEncoding=utf8&ServerTimezone=Asia/Shanghai","root","root");
            System.out.println("连接成功！");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("连接失败");
        }
        return null;
    }

    public static void close(Connection connection, Statement st, ResultSet rs){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
