package com.project.dao.jdbcImpl;

import com.project.utils.DBUtil;

import java.sql.*;

public class GenericBaseDao {
    private static String driver = DBUtil.driver;
    private static String url = DBUtil.url;
    private static String  user = DBUtil.user;
    private static String password = DBUtil.password;

    // 借助static code 的特性实现只注册一次驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection conn ;
    protected PreparedStatement pstmt;
    protected ResultSet rs;
    protected int result = -1;


    public void getConnection() throws SQLException {
        conn = DriverManager.getConnection(url,user,password);
    }

    public void closeAll() throws SQLException {
        if(rs!=null && !rs.isClosed())
            rs.close();
        if(pstmt != null && !pstmt.isClosed())
            pstmt.close();
        if(conn!=null && !conn.isClosed())
            conn.close();
        if(result!=-1)
            result=-1;
    }

    public void executeUpdate(final String sql,final Object...parames) throws SQLException {
        pstmt = conn.prepareStatement(sql);
        if(parames!=null)
        {
            for(int i=0;i<parames.length;i++)
                pstmt.setObject(i+1,parames[i]);
        }
        result = pstmt.executeUpdate();
    }

    public void executeQuery(final String sql,final Object...parames) throws SQLException {
        pstmt = conn.prepareStatement(sql);
        if(parames!=null)
        {
            for(int i=0;i<parames.length;i++)
                pstmt.setObject(i+1,parames[i]);
        }
       rs = pstmt.executeQuery();
    }



}
