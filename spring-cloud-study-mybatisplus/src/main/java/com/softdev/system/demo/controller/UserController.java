package com.softdev.system.demo.controller;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.softdev.system.demo.entity.User;
import com.softdev.system.demo.mapper.UserMapper;
import com.softdev.system.demo.util.ApiReturnObject;
import com.softdev.system.demo.util.ApiReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserMapper userMapper;

	@GetMapping("/init")
	public ApiReturnObject  init(){
		List<User> userList=new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			int n=RandomUtil.randomInt(10000,99999)+i;
			User user=new User();
			user.setId(n);
			user.setName(n+"");
			user.setPassWord(n+"");
			user.setStatus(1);
			user.setUserId(n+"");
			user.setUserName(n+"");
			userMapper.insert(user);
			userList.add(user);
			user=null;
		}
		return ApiReturnUtil.success(userList);
	}
	
	@GetMapping("/find")
	public ApiReturnObject  find(){
		IPage<User> userList=userMapper.selectPage(
				new Page<User>(1, 10), 
				new QueryWrapper<User>().like("name","1")
			);
		return ApiReturnUtil.success(userList.getRecords());
	}
}
