package com.edu.lingnan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.edu.lingnan.common.dto.UserDto;
import com.edu.lingnan.services.UserService;
import com.edu.lingnan.services.UserServiceImpl;

/**
 * 功能控制类
 * @author 涟动喧
 *
 */
public class UserController {
		//声明用户service接口对象，用于业务处理
		UserService userMgrService = UserServiceImpl.getInstance();
		
		/**
		 * 用户登录
		 * @param userid 用户编号
		 * @param password 用户密码
		 * @return 用户信息
		 */
		public UserDto doLogin(String name,String password){
			UserDto user = null;
			try {
				//调用用户service接口中的login方法，进行用户登录操作
				user = userMgrService.login(name, password);
			} catch (Exception e) {
				// 显示异常信息
				System.out.println("用户登录时出错了"+e.getMessage());
			}
			return user;
		}

		/**
		 * 用户注册
		 * @param user
		 * @return flag
		 */
		public boolean doRegister(UserDto user) {
			boolean flag = false;
			try {
				flag = userMgrService.addUser(user);
			} catch (Exception e) {
				// 显示异常信息
				System.out.println("用户注册时出错了"+e.getMessage());
			}
			return flag;
		}
		
		/**
		 * 按userID查询用户
		 * @param userid
		 * @return List<UserDto>
		 */
		public List<UserDto> findUserByUserId(String userid){
			List<UserDto> lu = new ArrayList<UserDto>();
			try {
				lu = userMgrService.findUserByUserId(userid);
			} catch (Exception e) {
				// 显示异常信息
				System.out.println("查询用户时出错了"+e.getMessage());
			}
			return lu;
		}
		
		/**
		 * 按用户名name查询用户
		 * @param name
		 * @return
		 */
		public List<UserDto> findUserByName(String name){
			List<UserDto> lu = new ArrayList<UserDto>();
			try {
				lu = userMgrService.findUserByName(name);
			} catch (Exception e) {
				// 显示异常信息
				System.out.println("查询用户时出错了"+e.getMessage());
			}
			return lu;
		}
		
		/**
		 * 查询全部用户
		 * @return
		 */
		public List<UserDto> findAll(){
			
			List<UserDto> lu = new ArrayList<UserDto>();
			try {
				lu = userMgrService.findAll();
			} catch (Exception e) {
				// 显示异常信息
				System.out.println("查询用户时出错了"+e.getMessage());
			}
			return lu;
		}
		
		/**
		 * 查询有效用户
		 * @return
		 */
		public List<UserDto> findAllValid(){
			List<UserDto> lu = new ArrayList<UserDto>();
			try {
				lu = userMgrService.findAllValid();
			} catch (Exception e) {
				// 显示异常信息
				System.out.println("查询用户时出错了"+e.getMessage());
			}
			return lu;
		}
		
		/**
		 * 查询无效用户
		 * @return
		 */
		public List<UserDto> findAllNotValid(){
			List<UserDto> lu = new ArrayList<UserDto>();
			try {
				lu = userMgrService.findAllNotValid();
			} catch (Exception e) {
				// 显示异常信息
				System.out.println("查询用户时出错了"+e.getMessage());
			}
			return lu;
		}
		
		
		/**
		 * 分页查询全部用户
		 * @return
		 */
		public List<UserDto> findUsers(int pageNo, int pageSize){
			List<UserDto> lu = new ArrayList<UserDto>();
			try {
				lu = userMgrService.findUsers(pageNo, pageSize);
			} catch (Exception e) {
				// 显示异常信息
				System.out.println("查询用户时出错了"+e.getMessage());
			}
			return lu;
		}
		
		
		/**
		 * 按userID删除用户
		 * @param userid
		 * @return
		 */
		public boolean deleteUserByUserid(String userid){
			boolean flag = false;
			try {
				flag = userMgrService.deleteUserByUserid(userid);
			} catch (Exception e) {
				// 显示异常信息
				System.out.println("删除用户时出错了"+e.getMessage());
			}
			return flag;
		}
		
		
		/**
		 * 按用户名删除用户
		 * @param name
		 * @return
		 */
		public boolean deleteUserByName(String name){
			boolean flag = false;
			try {
				flag = userMgrService.deleteUserByName(name);
			} catch (Exception e) {
				// 显示异常信息
				System.out.println("删除用户时出错了"+e.getMessage());
			}
			return flag;
		}
		
		
		/**
		 * 按用户名删除用户
		 * @param name
		 * @return
		 */
		public boolean updateUser(UserDto user){
			boolean flag = false;
			try {
				flag = userMgrService.updateUser(user);
			} catch (Exception e) {
				// 显示异常信息
				System.out.println("删除用户时出错了"+e.getMessage());
			}
			return flag;
		}
	
}
