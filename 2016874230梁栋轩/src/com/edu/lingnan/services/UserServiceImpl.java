package com.edu.lingnan.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.edu.lingnan.Exception.DaoException;
import com.edu.lingnan.Exception.ServiceException;
import com.edu.lingnan.business.dao.UserDao;
import com.edu.lingnan.common.constant.EnumType;
import com.edu.lingnan.common.dao.DaoFactory;
import com.edu.lingnan.common.dto.UserDto;
import com.edu.lingnan.util.DBUtils;

/**
 * 功能服务类
 * @author 涟动喧
 *
 */
public class UserServiceImpl implements UserService{
		
		/**
		 * 用户Service类实例
		 */
		private static UserService userService = new UserServiceImpl();
		
		/**
		 * 构造方法
		 */
		private UserServiceImpl(){
			
		}
		
		/**
		 * 取得用户service实例
		 * 
		 * @return 实例对象
		 */
		public static UserService getInstance(){
			return userService;
		}
		
		/**
		 * 登录操作
		 */
		public UserDto login(String name,String password){
			//声明数据库连接对象，用于保存数据库连接对象
			Connection conn = null;
			UserDto user = null;
			try{
				//调用数据库工具类的getConnection方法，取得的数据库连接对象，并赋值给连接对象变量
				conn = DBUtils.getConnection();
				//
				UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
				user = userMgrDao.login(name, password);
			}
			catch(DaoException e){
				//将自定义异常并抛出
				throw e;
			}
			catch(Exception e){
				//将异常封装成自定义异常并抛出
				throw new ServiceException("用户登录错误",e);
			}
			finally{
				DBUtils.closeConnection(conn);
			}
			//返回用户登录结果
			return user;
		}
		
		

		/**
		 * 注册操作
		 */
		public boolean addUser(UserDto user) {
			//声明数据库连接对象，用于保存数据库连接对象
			Connection conn = null;
			//声明变量，用于保存数据库插入结果
			boolean result = false;
			try{
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn = DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				//调用dao中的addUser方法，进行数据库插入操作，结果赋值给插入结果变量
				result = userMgrDao.addUser(user);
				//调用数据库工具类的commit方法，提交事务
				DBUtils.commit(conn);
			}
			catch(DaoException e){
				//将自定义异常并抛出
				throw e;
			}
			catch (Exception e) {
				DBUtils.rollback(conn);
			}
			return result;
		}


		/**
		 * 按userID查询用户
		 */
		public List<UserDto> findUserByUserId(String userid) {
			//声明数据库连接对象，用于保存数据库连接对象
			Connection conn = null;
			List<UserDto> lu = new ArrayList<UserDto>();
			try{
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn = DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				lu = userMgrDao.findUserByUserId(userid);
				//调用数据库工具类的commit方法，提交事务
				DBUtils.commit(conn);
			}
			catch(DaoException e){
				//将自定义异常并抛出
				throw e;
			}
			catch (Exception e) {
				DBUtils.rollback(conn);
			}
			return lu;
		}

		/**
		 * 按用户名查询用户
		 */
		public List<UserDto> findUserByName(String name) {
			//声明数据库连接对象，用于保存数据库连接对象
			Connection conn = null;
			List<UserDto> lu = new ArrayList<UserDto>();
			try{
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn = DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				lu = userMgrDao.findUserByName(name);
				//调用数据库工具类的commit方法，提交事务
				DBUtils.commit(conn);
			}
			catch(DaoException e){
				//将自定义异常并抛出
				throw e;
			}
			catch (Exception e) {
				DBUtils.rollback(conn);
			}
			return lu;
		}

		/**
		 * 查询全部用户
		 */
		public List<UserDto> findAll() {
			//声明数据库连接对象，用于保存数据库连接对象
			Connection conn = null;
			List<UserDto> lu = new ArrayList<UserDto>();
			try{
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn = DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				lu = userMgrDao.findAll();
				//调用数据库工具类的commit方法，提交事务
				DBUtils.commit(conn);
			}
			catch(DaoException e){
				//将自定义异常并抛出
				throw e;
			}
			catch (Exception e) {
				DBUtils.rollback(conn);
			}
			return lu;
		}

		/**
		 * 修改用户信息
		 */
		public boolean updateUser(UserDto user) {
			//声明数据库连接对象，用于保存数据库连接对象
			Connection conn = null;
			//声明变量，用于保存数据库插入结果
			boolean result = false;
			try{
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn = DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				//调用dao中的addUser方法，进行数据库插入操作，结果赋值给插入结果变量
				result = userMgrDao.updateUser(user);
				//调用数据库工具类的commit方法，提交事务
				DBUtils.commit(conn);
			}
			catch(DaoException e){
				//将自定义异常并抛出
				throw e;
			}
			catch (Exception e) {
				DBUtils.rollback(conn);
			}
			return result;
		}

		/**
		 * 查询全部有效用户
		 */
		public List<UserDto> findAllValid() {
			//声明数据库连接对象，用于保存数据库连接对象
			Connection conn = null;
			List<UserDto> lu = new ArrayList<UserDto>();
			try{
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn = DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				lu = userMgrDao.findAllValid();
				//调用数据库工具类的commit方法，提交事务
				DBUtils.commit(conn);
			}
			catch(DaoException e){
				//将自定义异常并抛出
				throw e;
			}
			catch (Exception e) {
				DBUtils.rollback(conn);
			}
			return lu;
		}
		
		/**
		 * 查询全部无效用户
		 */
		public List<UserDto> findAllNotValid() {
			//声明数据库连接对象，用于保存数据库连接对象
			Connection conn = null;
			List<UserDto> lu = new ArrayList<UserDto>();
			try{
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn = DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				lu = userMgrDao.findAllNotValid();
				//调用数据库工具类的commit方法，提交事务
				DBUtils.commit(conn);
			}
			catch(DaoException e){
				//将自定义异常并抛出
				throw e;
			}
			catch (Exception e) {
				DBUtils.rollback(conn);
			}
			return lu;
		}

		/**
		 * 分页查询全部用户
		 */
		public List<UserDto> findUsers(int pageNo, int pageSize) {
			//声明数据库连接对象，用于保存数据库连接对象
			Connection conn = null;
			List<UserDto> lu = new ArrayList<UserDto>();
			try{
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn = DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				lu = userMgrDao.findUsers(pageNo, pageSize);
				//调用数据库工具类的commit方法，提交事务
				DBUtils.commit(conn);
			}
			catch(DaoException e){
				//将自定义异常并抛出
				throw e;
			}
			catch (Exception e) {
				DBUtils.rollback(conn);
			}
			return lu;
		}


		/**
		 * 按userID软删除用户
		 */
		public boolean deleteUserByUserid(String userid) {
			//声明数据库连接对象，用于保存数据库连接对象
			Connection conn = null;
			//声明变量，用于保存数据库插入结果
			boolean flag = false;
			try{
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn = DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				flag = userMgrDao.deleteUserByUserid(userid);
				//调用数据库工具类的commit方法，提交事务
				DBUtils.commit(conn);
			}
			catch(DaoException e){
				//将自定义异常并抛出
				throw e;
			}
			catch (Exception e) {
				DBUtils.rollback(conn);
			}
			return flag;
		}

		/**
		 * 按用户名软删除用户
		 */
		public boolean deleteUserByName(String name) {
			//声明数据库连接对象，用于保存数据库连接对象
			Connection conn = null;
			//声明变量，用于保存数据库插入结果
			boolean flag = false;
			try{
				//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
				conn = DBUtils.getConnection();
				//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
				UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
				//调用数据库工具类的beginTransaction方法，开启事务
				DBUtils.beginTransaction(conn);
				flag = userMgrDao.deleteUserByName(name);
				//调用数据库工具类的commit方法，提交事务
				DBUtils.commit(conn);
			}
			catch(DaoException e){
				//将自定义异常并抛出
				throw e;
			}
			catch (Exception e) {
				DBUtils.rollback(conn);
			}
			return flag;
		}


}
