package com.softdev.system.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.softdev.system.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User>{
	
}
