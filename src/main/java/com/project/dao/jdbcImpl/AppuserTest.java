package com.project.dao.jdbcImpl;

import com.project.dao.AppuserDao;
import com.project.domain.po.Appuser;

import java.util.List;

public class AppuserTest {
    public static void main(String[] args) {
        AppuserDao appuserDao = new AppuserDaoImpl();
        Appuser appuser = appuserDao.findById(1);
        System.out.println(appuser);

        Appuser appuser2 = new Appuser(1,"x","y");
        int res1 = appuserDao.update(appuser2);

        List<Appuser> Appusers = appuserDao.findAll();
        for (Appuser c:Appusers)
            System.out.println(c);
        Appuser appuser1 = new Appuser("xyy","xyy_p");
        int res = appuserDao.insert(appuser1);
        System.out.println(res);
    }
}
