package com.qf.dao;

import com.qf.domain.TbSysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by HP        PC on 2019/11/27.
 */
@Mapper
public interface SysPermissionDao {
    public List<TbSysPermission> findUserPermissionByUserName(String name);
}
