package com.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
		/**
		 * 获取数据库连接
		 */
		private static String driver = "oracle.jdbc.driver.OracleDriver";
		private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		private static String username = "system";
		private static String password = "123456";
		private static Connection conn = null;
		
		public static Connection getConnection() {
		try {
			//加载驱动
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			//获取数据库连接对象
		}
		catch (ClassNotFoundException e) {
			//将异常封装成自定义异常
			e.printStackTrace();
			System.out.println("获取connection时找不到类文件");
		}
		catch (SQLException e) {
			//将异常封装成自定义异常
			e.printStackTrace();
			System.out.println("获取connection时SQL异常");
		}
		//返回得到的连接对象
		return conn;
}
		
		/**
		 * 开启事务
		 * @param conn
		 */
		public static void beginTransaction(Connection conn){
			try{
				//将事务的自动提交模式设为假
				conn.setAutoCommit(false);
			}
			catch(SQLException e){
				//将异常封装成自定义异常
				e.printStackTrace();
			}
		}
		
		
		/**
		 * 提交事务
		 * @param conn
		 */
		public static void commit(Connection conn){
			try{
				//回滚事务
				conn.commit();
				//将事务的自动提交模式设为真
				conn.setAutoCommit(true);
			}
			catch(SQLException e){
				//将异常封装成自定义异常
				e.printStackTrace();
			}
		}
		
		/**
		 * 回滚事务
		 * @param conn
		 */
		public static void rollback(Connection conn){
			try {
				conn.rollback();
			} catch (SQLException e) {
				//将异常封装成自定义异常
				e.printStackTrace();
			}
		}
		
		/**
		 * 关闭连接
		 * @param conn
		 */
		public static void closeConnection(Connection conn){
				try {
					//如果数据库连接对象不为空，关闭该对象
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					//将异常封装成自定义异常
					e.printStackTrace();
				}
		}
		
		/**
		 * 关闭ResultSet
		 * 关闭Statement
		 * @param rs
		 * @param stmt
		 */
		public static void closeStatement(ResultSet rs,Statement stmt){
			try {
				//如果查询结果集对象不为空，关闭该对象
				if(rs!=null){
					rs.close();
				}
				//如果声明对象不为空，关闭该对象
				if(stmt!=null){
					stmt.close();
				}
			} catch (Exception e) {
				//将异常封装成自定义异常
				e.printStackTrace();
			}
		}
	
}
