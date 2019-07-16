package com.softdev.system.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * 匹配 "/" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
     * 默认启用 CSRF
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login","/index","/logout").permitAll()
                .antMatchers("/user/**").hasAuthority("USER")
                .and()
                .formLogin().successForwardUrl("/user/list")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");

        http.addFilterAt(customFromLoginFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * 自定义认证过滤器
     */
    private CustomFromLoginFilter customFromLoginFilter() {
        return new CustomFromLoginFilter("/login");
    }

}