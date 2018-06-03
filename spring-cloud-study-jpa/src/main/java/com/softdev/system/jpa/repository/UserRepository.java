package com.softdev.system.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softdev.system.jpa.entity.User;
import com.softdev.system.jpa.entity.UserRoleList;

public interface UserRepository extends JpaRepository<User, Integer>{
	//nativeQuery=true代表用sql查询，不是hql，更自由
	@Query(value=" SELECT u.user_name,r.role_name from user u "
			+ " left join user_role ur on u.user_id=ur.user_id "
			+ " left join role r on ur.role_id=r.role_id "
			+ " where u.user_id=?1 "
			,nativeQuery=true)
	List<UserRoleList> getUserRoleList(String userId);
}
