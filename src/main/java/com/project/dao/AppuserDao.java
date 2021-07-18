package com.project.dao;

import com.project.domain.po.Appuser;

public interface AppuserDao extends GenericDao<Appuser,Integer> {
        Appuser findByName(String user_name);
}
