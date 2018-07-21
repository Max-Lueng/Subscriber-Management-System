package com.edu.lingnan.business.dao;

import java.util.List;

import com.edu.lingnan.common.dao.BaseDao;
import com.edu.lingnan.common.dto.UserDto;

/**
 * 功能实现类接口
 * @author 涟动喧
 *
 */
public interface UserDao extends BaseDao{
	
		//用户登录
		public UserDto login(String name,String password);
		
		//添加用户、注册用户
		public boolean addUser(UserDto user);
		
		//根据ID查找用户
		public List<UserDto> findUserByUserId(String userid);
		
		//根据用户名查找用户
		public List<UserDto> findUserByName(String name);
		
		//查询所有用户
		public List<UserDto> findAll();
		
		//更新用户
		public boolean updateUser(UserDto user);
		
		//按userID删除用户
		public boolean deleteUserByUserid(String userid);
		
		//删除用户名用户
		public boolean deleteUserByName(String name);
		
		//查询所有有效用户
		public List<UserDto> findAllValid();
		
		//查询所有无效用户
		public List<UserDto> findAllNotValid();
		
		//获取指定页的用户信息
		public List<UserDto> findUsers(int pageNo,int pageSize);


}
