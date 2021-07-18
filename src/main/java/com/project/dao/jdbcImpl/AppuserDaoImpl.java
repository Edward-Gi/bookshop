package com.project.dao.jdbcImpl;

import com.project.dao.AppuserDao;
import com.project.domain.po.Appuser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppuserDaoImpl extends GenericBaseDao implements AppuserDao {
    @Override
    public Appuser findByName(String user_name) {
        Appuser appuser = null;

        try {
            this.getConnection();
            String sql = "select * from appuser where user_name = ?";
            this.executeQuery(sql,user_name);
            if(rs!=null && rs.next())
            {
                appuser = new Appuser(rs.getInt("userID"),rs.getString("user_name"),rs.getString("user_pwd"));
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return appuser;
    }

    @Override
    public Appuser findById(Integer id) {
        Appuser appuser = null;
        try {
            this.getConnection();
            String sql = "select * from appuser where userID = ?";
            this.executeQuery(sql,id);
            if(rs!=null && rs.next())
            {
                appuser = new Appuser(rs.getInt("userID"),rs.getString("user_name"),rs.getString("user_pwd"));
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return appuser;
    }

    @Override
    public List<Appuser> findAll() {
        List<Appuser> appusers=null;
        try {
            this.getConnection();
            String sql = "select * from appuser";
            this.executeQuery(sql);
            if(rs != null)
            {
                appusers = new ArrayList<>();
                while(rs.next())
                {
                    Appuser appuser = new Appuser(rs.getInt("userID"),rs.getString("user_name"),
                            rs.getString("user_pwd"));
                    appusers.add(appuser);
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return appusers;
    }

    @Override
    public List<Appuser> findBySQL(String sql, Object... params) {
        List<Appuser> appusers = null;

        try {
            this.getConnection();
            this.executeQuery(sql,params);
            if(rs!=null)
            {
                appusers = new ArrayList<>();
                while(rs.next())
                {
                    Appuser appuser = new Appuser(rs.getInt("userID"),rs.getString("user_name"),
                            rs.getString("user_pwd"));
                    appusers.add(appuser);
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return appusers;
    }

    @Override
    public int insert(Appuser appuser) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "insert into appuser values(null,?,?)";
            this.executeUpdate(sql,appuser.getUser_name(),appuser.getUser_pwd());
            res = result;
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int update(Appuser appuser) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "update appuser set user_name =?,user_pwd = ? where userID = ?";
            this.executeUpdate(sql,appuser.getUser_name(),appuser.getUser_pwd(),appuser.getUserID());
            res = result;
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(Appuser appuser) {

        return this.delete(appuser.getUserID());
    }

    @Override
    public int delete(Integer id) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "delete from appuser where id = ?";
            this.executeUpdate(sql, id);
            res = result;
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
