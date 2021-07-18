package com.project.web.controller;

import com.project.domain.po.Appuser;
import com.project.service.Impl.AppuserService;
import com.project.service.Impl.AppuserServiceImpl;

public class AppuserController {
    private AppuserService appuserService = new AppuserServiceImpl();

    private Appuser appuser ;

    public String login()
    {
        boolean res = appuserService.login(appuser.getUser_name(),appuser.getUser_name());
        if(res)
            return "success";
        else
            return "fail";
    }

    public String register()
    {
        boolean res = appuserService.register(appuser);
        if(res)
            return "success";
        else
            return "fail";
    }

    public String remove()
    {
        boolean res = appuserService.remover(appuser);
        if(res)
            return "success";
        else
            return "fail";
    }

    public String modify()
    {
        boolean res = appuserService.modify(appuser);
        if(res)
            return "success";
        else
            return "fail";
    }

    public String searchInfo()
    {
        boolean res = appuserService.searchInfo(appuser.getUser_name());
        if(res)
            return "success";
        else
            return "fail";
    }


    public Appuser getAppuser() {
        return appuser;
    }

    public void setAppuser(Appuser appuser) {
        this.appuser = appuser;
    }
}
