package com.venchi.dark.config;

import com.venchi.dark.pojo.UserAuth;
import com.venchi.dark.pojo.UserRole;
import com.venchi.dark.service.UserAuthService;
import com.venchi.dark.service.UserRoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author liwc
 * @date 2021/08/02
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        UserAuth userAuth = userAuthService.findByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<UserRole> userRoleList = userRoleService.findRolesByUserId(userAuth.getUserId());
        for(UserRole userRole:userRoleList){
            simpleAuthorizationInfo.addRole(userRole.getRoleId().toString());
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if(authenticationToken.getPrincipal()==null){
            return null;
        }
        String username = authenticationToken.getPrincipal().toString();
        UserAuth userAuth = userAuthService.findByUsername(username);
        if(userAuth==null){
            return null;
        }else{
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,userAuth.getPassword(),username);
            return simpleAuthenticationInfo;
        }
    }

}
