package com.qf.Service.impl;

import com.qf.Service.SysPermissionService;
import com.qf.dao.SysPermissionDao;
import com.qf.domain.TbSysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HP        PC on 2019/11/27.
 */
@Service
public class SysPermissionServiceimpl implements SysPermissionService {
    @Autowired
    private SysPermissionDao sysPermissionDao;
    @Override
    public List<TbSysPermission> findUserPermissionByUserName(String name) {
        return sysPermissionDao.findUserPermissionByUserName(name);
    }
}
