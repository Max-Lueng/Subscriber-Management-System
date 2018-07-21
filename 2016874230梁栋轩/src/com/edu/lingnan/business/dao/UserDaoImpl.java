package com.edu.lingnan.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.edu.lingnan.Exception.DaoException;
import com.edu.lingnan.common.dto.UserDto;
import com.edu.lingnan.util.DBUtils;

/**
 * 功能实现类
 * @author 涟动喧
 *
 */
public class UserDaoImpl implements UserDao{

		/**
		 * 数据库连接
		 */
		private Connection conn;
		
		/**
		 * 构造方法
		 * 
		 * @param conn 数据库连接
		 */
		public UserDaoImpl(Connection conn){
			//给属性赋初始化值
			this.conn = conn;
		}
		
		/**
		 * 用户id登录
		 */
		public UserDto login(String name,String password){
			//声明结果集对象变量，用于保存数据库查询结果集
			ResultSet rs = null;
			//声明预编译的声明对象变量，用于进行数据库操作的载体
			PreparedStatement prep = null;
			//声明结果集对象变量，用于保存从结果集中提取出来的数据
			UserDto user = null;
			try{
				//调用连接时对象的prepareStatement方法，得到编译对象，赋值诶编译对象
				prep = conn.prepareStatement
					("select * from t_user where name = ? and password = ? and status = '1'");
				//调用预编译对象的setXXX方法给？赋值
				prep.setString(1, name);
				prep.setString(2, password);
				//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
				rs = prep.executeQuery();
				//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
				if(rs.next()){
					//创建一个新用户对象，赋值给用户对象变量
					user = new UserDto();
					/**
					 * 调用结果集对象的getXXX方法，取出各字段的值
					 * 然后在调用用户对象的setXXX方法，给属性赋值
					 * 最后新创建的对象中包含了查询结果的所有字段
					 */
					user.setId(rs.getInt("id"));
					user.setUserid(rs.getString("userid"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setMail(rs.getString("mail"));
					user.setPower(rs.getString("power"));
					user.setBirth(rs.getDate("birth"));
					user.setStatus(rs.getString("status"));
				}
			}
			catch(SQLException e){
				System.out.println("在插入用户时出现了出错信息："+e.getMessage());
				throw new DaoException("登录时查询数据出错",e);
			}
			finally{
				DBUtils.closeStatement(rs, prep);
			}
			return user;
		}
		
		/**
		 * 注册、添加用户
		 */
		public boolean addUser(UserDto user){
				
				boolean flag = false;
				PreparedStatement prep = null;
				int result = -1;
				try {
					prep = conn.prepareStatement
							("insert into t_user(name,password,mail,birth)values(?,?,?,?)");
					prep.setString(1, user.getName());
					prep.setString(2, user.getPassword());
					prep.setString(3, user.getMail());
					prep.setDate(4, new java.sql.Date(user.getBirth().getTime()));
					result = prep.executeUpdate();
					if(result>0){
						flag = true;
					}
					else{
						flag = false;
					}
				} catch (Exception e) {
					System.out.println("输入用户信息时出错了，错误信息是："+e.getMessage());
				}
				return flag;
		}


		/**
		 * 按userID查询用户
		 */
		public List<UserDto> findUserByUserId(String userid) {
			List<UserDto> lu = new ArrayList<UserDto>();
			PreparedStatement prep = null;
			ResultSet rs = null;
			UserDto user = null;
			try {
				prep = conn.prepareStatement("select * from t_user where userid like ?");
					prep.setString(1, "%"+userid+"%");
					rs = prep.executeQuery();
					while(rs.next()) {
						user = new UserDto();
						user.setId(rs.getInt("id"));
						user.setUserid(rs.getString("userid"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						user.setMail(rs.getString("mail"));
						user.setPower(rs.getString("power"));
						user.setBirth(rs.getDate("birth"));
						user.setStatus(rs.getString("status"));
						lu.add(user);
					}
			}
			catch(Exception e){
				System.out.println("输入用户信息时出错了，错误信息是："+e.getMessage());
			}
			return lu;
		}

		/**
		 * 按用户名查询用户
		 */
		public List<UserDto> findUserByName(String name) {
			List<UserDto> lu = new ArrayList<UserDto>();
			PreparedStatement prep = null;
			ResultSet rs = null;
			UserDto user = null;
			try {
				prep = conn.prepareStatement("select * from t_user where name like ?");
					prep.setString(1, "%"+name+"%");
					rs = prep.executeQuery();
					while(rs.next()) {
						user = new UserDto();
						user.setId(rs.getInt("id"));
						user.setUserid(rs.getString("userid"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						user.setMail(rs.getString("mail"));
						user.setPower(rs.getString("power"));
						user.setBirth(rs.getDate("birth"));
						user.setStatus(rs.getString("status"));
						lu.add(user);
					}
			}
			catch(Exception e){
				System.out.println("输入用户信息时出错了，错误信息是："+e.getMessage());
			}
			return lu;
		}

		/**
		 * 查询全部用户
		 */
		public List<UserDto> findAll() {
			List<UserDto> lu = new ArrayList<UserDto>();
			PreparedStatement prep = null;
			ResultSet rs = null;
			UserDto user = null;
			try {
				prep = conn.prepareStatement("select * from t_user");
				rs = prep.executeQuery();
				while(rs.next()) {
						user = new UserDto();
						user.setId(rs.getInt("id"));
						user.setUserid(rs.getString("userid"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						user.setMail(rs.getString("mail"));
						user.setPower(rs.getString("power"));
						user.setBirth(rs.getDate("birth"));
						user.setStatus(rs.getString("status"));
						lu.add(user);
				}
			}
			catch(Exception e){
				System.out.println("输入用户信息时出错了，错误信息是："+e.getMessage());
			}
			return lu;
		}

		/**
		 * 更新用户信息
		 */
		public boolean updateUser(UserDto user) {
			boolean flag = false;
			PreparedStatement prep = null;
			int result = -1;
			try {
				prep = conn.prepareStatement
						("update t_user set name = ? ,password = ? ,mail = ? ,power = ? , birth = ? , status = ? where userid = ?");
				prep.setString(1, user.getName());
				prep.setString(2, user.getPassword());
				prep.setString(3, user.getMail());
				prep.setString(4, user.getPower());
				prep.setDate(5, new java.sql.Date(user.getBirth().getTime()));
				prep.setString(6, user.getStatus());
				prep.setString(7, user.getUserid());
				result = prep.executeUpdate();
				if(result>0){
					flag = true;
				}
				else{
					flag = false;
				}
			} catch (Exception e) {
				System.out.println("输入用户信息时出错了，错误信息是："+e.getMessage());
			}
			return flag;
		}

		/**
		 * 按userID软删除用户
		 */
		public boolean deleteUserByUserid(String userid) {
			boolean flag = false;
			PreparedStatement prep = null;
			int result = -1;
			try {
				prep = conn.prepareStatement("update t_user set status = '0' where userid = ?");
				prep.setString(1, userid);
				result = prep.executeUpdate();
				if(result>0){
					flag = true;
				}
				else{
					flag = false;
				}
			} catch (Exception e) {
				System.out.println("输入用户信息时出错了，错误信息是："+e.getMessage());
			}
			return flag;
		}
		
		/**
		 * 按用户名软删除用户
		 */
		public boolean deleteUserByName(String name) {
			boolean flag = false;
			PreparedStatement prep = null;
			int result = -1;
			try {
				prep = conn.prepareStatement("update t_user set status = '0' where name = ?");
				prep.setString(1, name);
				result = prep.executeUpdate();
				if(result>0){
					flag = true;
				}
				else{
					flag = false;
				}
			} catch (Exception e) {
				System.out.println("输入用户信息时出错了，错误信息是："+e.getMessage());
			}
			return flag;
		}

		/**
		 * 查询全部有效用户
		 */
		public List<UserDto> findAllValid() {
			List<UserDto> lu = new ArrayList<UserDto>();
			PreparedStatement prep = null;
			ResultSet rs = null;
			UserDto user = null;
			try {
				prep = conn.prepareStatement("select * from t_user where status = '1'");
				rs = prep.executeQuery();
				while(rs.next()) {
					user = new UserDto();
					user.setId(rs.getInt("id"));
					user.setUserid(rs.getString("userid"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setMail(rs.getString("mail"));
					user.setPower(rs.getString("power"));
					user.setBirth(rs.getDate("birth"));
					user.setStatus(rs.getString("status"));
					lu.add(user);
				}
			}
			catch(Exception e){
				System.out.println("输入用户信息时出错了，错误信息是："+e.getMessage());
			}
			return lu;
		}
		
		/**
		 * 查询全部无效用户
		 */
		public List<UserDto> findAllNotValid() {
			List<UserDto> lu = new ArrayList<UserDto>();
			PreparedStatement prep = null;
			ResultSet rs = null;
			UserDto user = null;
			try {
				prep = conn.prepareStatement("select * from t_user where status = '0'");
				rs = prep.executeQuery();
				while(rs.next()) {
					user = new UserDto();
					user.setId(rs.getInt("id"));
					user.setUserid(rs.getString("userid"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setMail(rs.getString("mail"));
					user.setPower(rs.getString("power"));
					user.setBirth(rs.getDate("birth"));
					user.setStatus(rs.getString("status"));
					lu.add(user);
				}
			}
			catch(Exception e){
				System.out.println("输入用户信息时出错了，错误信息是："+e.getMessage());
			}
			return lu;
		}

		/**
		 * 分页查询全部用户
		 */
		public List<UserDto> findUsers(int pageNo, int pageSize) {
			List<UserDto> lu = new ArrayList<UserDto>();
			PreparedStatement prep = null;
			ResultSet rs = null;
			UserDto user = null;
			
			try {
				//prep = conn.prepareStatement("select * from (select t.*,rownum rm from t_user order by id t) where rm>=? and rm<=?");
				prep = conn.prepareStatement("select * from (select t2.*,rownum rn from (select t1.* from t_user t1 order by id) t2) " +
						"where rn>? and rn<=?");
				//调用预编译对象的setXxx方法，给？号赋值
				prep.setInt(1,(pageNo-1)*pageSize);
				prep.setInt(2,pageNo*pageSize);
				rs=prep.executeQuery();
				while(rs.next()) {
					user = new UserDto();
					user.setId(rs.getInt("id"));
					user.setUserid(rs.getString("userid"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setMail(rs.getString("mail"));
					user.setPower(rs.getString("power"));
					user.setBirth(rs.getDate("birth"));
					user.setStatus(rs.getString("status"));
					lu.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lu;
		}


	
}
