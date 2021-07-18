package com.project.view;

import com.project.domain.po.Appuser;
import com.project.web.controller.AppuserController;

public class AppuserView {
    public static void main(String[] args) {
        AppuserController appuserController = new AppuserController();

        String user_name = "xyy";
        String user_pwd = "xyy_p";

        Appuser appuser = new Appuser(user_name,user_pwd);
        appuserController.setAppuser(appuser);
        String res = appuserController.register();
        System.out.println(res);


    }



}
