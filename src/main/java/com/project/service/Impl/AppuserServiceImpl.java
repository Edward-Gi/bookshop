package com.project.service.Impl;

import com.project.dao.AppuserDao;
import com.project.dao.jdbcImpl.AppuserDaoImpl;
import com.project.domain.po.Appuser;

public class AppuserServiceImpl implements AppuserService {

    AppuserDao appuserDao = new AppuserDaoImpl();

    @Override
    public boolean login(String user_name,String user_pwd) {
        boolean res = false;
        Appuser existappuser = appuserDao.findByName(user_name);
        if(existappuser!=null && user_pwd.equals(existappuser.getUser_pwd()) )
            res =true;
        return res;
    }

    @Override
    public boolean register(Appuser appuser) {
        boolean res = false;
        int result = -1;
        Appuser existappuser = appuserDao.findByName(appuser.getUser_name());
        if(existappuser!=null)
            return false;
        result = appuserDao.insert(appuser);
        if(result == 1)
            res = true;
        return res;
    }

    @Override
    public boolean remover(Appuser appuser) {
        boolean res = false;
        int result = -1;
        Appuser existappuser = appuserDao.findByName(appuser.getUser_name());
        if(existappuser ==null)
            return false;
        result = appuserDao.delete(appuser);
        if(result == 1)
            res = true;
        return res;
    }

    @Override
    public boolean modify(Appuser appuser) {
        boolean res = false;
        int result = -1;
        Appuser existappuser = appuserDao.findByName(appuser.getUser_name());
        if(existappuser ==null)
            return false;
        result = appuserDao.update(appuser);
        if(result == 1)
            res = true;
        return res;
    }


    @Override
    public boolean searchInfo(String user_name) {
        boolean res = false;
        Appuser existappuser = appuserDao.findByName(user_name);
        if(existappuser !=null)
           res = true;
        return res;
    }
}
