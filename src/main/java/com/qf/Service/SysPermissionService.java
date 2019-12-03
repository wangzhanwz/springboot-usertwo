package com.qf.Service;

import com.qf.domain.TbSysPermission;

import java.util.List;

/**
 * Created by HP        PC on 2019/11/27.
 */
public interface SysPermissionService {
    public List<TbSysPermission> findUserPermissionByUserName(String name);
}
