package com.venchi.dark.config;

import com.venchi.dark.pojo.UserAuth;
import com.venchi.dark.service.UserAuthService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liwc
 * @date 2021/08/02
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserAuthService userAuthService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        UserAuth userAuth = userAuthService.findByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        return null;
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
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,userAuth,username);
            return simpleAuthenticationInfo;
        }
    }

}
