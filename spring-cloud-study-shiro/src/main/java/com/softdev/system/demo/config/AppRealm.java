package com.softdev.system.demo.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.authc.SimpleAccount;

public class AppRealm  extends AuthorizingRealm {

    /**
     * 判断授权的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 判断认证的
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName=token.getPrincipal().toString();
        String passWord=new String((char[])token.getCredentials());

        if(!userName.equals("user")) throw new AuthenticationException("用户名错误");
        if(!passWord.equals("123456")) throw new AuthenticationException("密码错误");

        return new SimpleAccount("zhang@163.com", passWord, getName());
    }
}
