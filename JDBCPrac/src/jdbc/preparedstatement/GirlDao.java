package jdbc.preparedstatement;

import jdbc.entity.Girl;
import jdbc.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GirlDao {

    public Girl selectOne(String name, String phone) {
        Girl girl = null;
        //获取连接对象
        Connection connection = JDBCUtils.getConn();
        PreparedStatement ppst = null;
        ResultSet rs = null;
        String sql = "select * from girl where name = ? and phone = ?";
        try {
            ppst = connection.prepareStatement(sql);
            ppst.setString(1,name);
            ppst.setString(2,phone);
            //执行查询操作
            rs = ppst.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("name");
                String sex = rs.getString("sex");
                Date borndate = rs.getDate("borndate");
                String userphone = rs.getString("phone");
                int boyfriend_id = rs.getInt("boyfriend_id");

                girl = new Girl(id,username,sex,borndate,userphone,boyfriend_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,ppst,rs);
        }
        return girl;
    }

    public List<Girl> selectAll(String query){
        List<Girl> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConn();
        String sql = "select * from girl where name like concat('%',?,'%')";
        PreparedStatement ppst = null;
        ResultSet rs = null;
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1,query);
            rs = ppst.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("name");
                String sex = rs.getString("sex");
                Date borndate = rs.getDate("borndate");
                String userphone = rs.getString("phone");
                int boyfriend_id = rs.getInt("boyfriend_id");
                Girl girl = new Girl(id,username,sex,borndate,userphone,boyfriend_id);
                list.add(girl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ppst,rs);
        }
        return list;
    }

    public int update(Girl girl){
        Connection conn = JDBCUtils.getConn();
        String sql = "update girl set name = ? , phone = ? , photo = null ,borndate = ? where id = ?" ;
        PreparedStatement ppst = null;
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, girl.getName());
            ppst.setString(2,girl.getPhone());
            ppst.setDate(3,girl.getBorndate());
            ppst.setInt(4,girl.getId());
            int i = ppst.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ppst,null);
        }
        return 0;
    }
}
