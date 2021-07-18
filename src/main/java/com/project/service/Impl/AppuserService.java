package com.project.service.Impl;

import com.project.domain.po.Appuser;

public interface AppuserService {
    boolean login(String user_name,String user_pwd);
    boolean register(Appuser appuser);
    boolean remover(Appuser appuser);
    boolean modify(Appuser appuser);
    boolean searchInfo(String user_name);
}
