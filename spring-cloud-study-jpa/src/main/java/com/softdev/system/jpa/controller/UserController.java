package com.softdev.system.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.softdev.system.jpa.entity.Role;
import com.softdev.system.jpa.entity.User;
import com.softdev.system.jpa.entity.UserRole;
import com.softdev.system.jpa.entity.UserRoleList;
import com.softdev.system.jpa.entity.UserRoleListJson;
import com.softdev.system.jpa.repository.RoleRepository;
import com.softdev.system.jpa.repository.UserRepository;
import com.softdev.system.jpa.repository.UserRoleRepository;
import com.softdev.system.jpa.util.ApiReturnObject;
import com.softdev.system.jpa.util.ApiReturnUtil;

import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("用户接口")
@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@ApiOperation(value="user/roles/{userId}", notes="获取用户角色列表")
	@GetMapping("/user/roles/{userId}")
	public ApiReturnObject  getuserRoleList(@PathVariable String userId){
		List<UserRoleList> list=userRepository.getUserRoleList(userId);
		if(list==null||list.size()<1) {
			return ApiReturnUtil.error("无法获取到用户角色列表");
		}
		//返回target类型的代理类
		//return ApiReturnUtil.success(list);
		//回迁到新的主数据list上
        List<UserRoleListJson> dataList = new ArrayList<UserRoleListJson>();
        for (UserRoleList item:list) {
            //先把interface类的内容格式化为string，就是一些属性，然后target里面才是主数据
            String jsonStr=JSON.toJSONString(item);
            //格式化string为JSONObject，方便获取target属性
            JSONObject obj=JSON.parseObject(jsonStr);
            //从将QueueList的target的数据真正格式化到主数据类CheckQueue
            UserRoleListJson data=JSON.toJavaObject(JSON.parseObject(obj.getString("target")), UserRoleListJson.class);
            //添加到list
            dataList.add(data);
            data=null;
        }
        return ApiReturnUtil.success(dataList);
	}
	
	@ApiOperation(value="user/{userId}", notes="新增或修改角色")
	@RequestMapping("/user/{userId}")
	public ApiReturnObject insertOrUpdate(@PathVariable String userId,User user){
		try {
			userRepository.save(user);
			return ApiReturnUtil.success("新增或修改成功");
		} catch (Exception e) {
			return ApiReturnUtil.error("新增或修改失败:"+e.getMessage());
		}
	}
	
	@ApiOperation(value="user/init/{userId}", notes="初始化一个用户")
	@GetMapping("/user/init/{userId}")
	@Transactional(rollbackFor = Exception.class)
	public ApiReturnObject init(@PathVariable int userId,User user,Role role,UserRole userRole){
		try {
			int randomNumber=userId;
			user=new User();
			user.setUserId(""+randomNumber);
			user.setUserName("用户"+randomNumber);
			user.setPassWord("123456");
			userRepository.save(user);
			
			role=new Role();
			role.setId(randomNumber);
			role.setRoleId(""+randomNumber);
			role.setRoleName("角色"+randomNumber);
			roleRepository.save(role);
			
			Role role2=new Role();
			role2.setRoleId("#"+randomNumber);
			role2.setRoleName("#角色"+randomNumber);
			roleRepository.save(role2);
			
			userRole=new UserRole();
			userRole.setUserId(""+randomNumber);
			userRole.setRoleId(""+randomNumber);
			userRoleRepository.save(userRole);
			
			UserRole userRole2=new UserRole();
			userRole2.setUserId(""+randomNumber);
			userRole2.setRoleId("#"+randomNumber);
			userRoleRepository.save(userRole2);
			
			return ApiReturnUtil.success("初始化用户成功",randomNumber);
		} catch (Exception e) {
			return ApiReturnUtil.error("新增或修改失败:"+e.getMessage());
		}
	}
}
