package com.qf.config;

import com.qf.Service.SysPermissionService;
import com.qf.Service.UsertwoService;
import com.qf.domain.TbSysPermission;
import com.qf.domain.Usertwo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by HP        PC on 2019/11/27.
 */
public class MyRealm  extends AuthorizingRealm {
    @Autowired
    private UsertwoService usertwoService;
    @Autowired
    private SysPermissionService sysPermissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        //登录名称查询该用户的权限
        List<TbSysPermission> userPermissionByUserName = sysPermissionService.findUserPermissionByUserName(primaryPrincipal);
        if (userPermissionByUserName != null && userPermissionByUserName.size() > 0) {
            //去重
            Collection list = new HashSet<>();
            for (TbSysPermission per : userPermissionByUserName
                    ) {
                list.add(per.getPerName());
            }


            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addStringPermissions(list);
            return simpleAuthorizationInfo;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取到当前登录的用户名
        String name = (String) token.getPrincipal();
        //通过用户名去数据库查询正确的密码
        Usertwo user = usertwoService.findByName(name);
        if (user != null) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getName(), user.getPass(), getName());
            return simpleAuthenticationInfo;
        }




        return null;
    }
}
