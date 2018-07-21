package com.edu.lingnan.Exception;

/**
 * DAO异常类
 * @author 涟动喧
 *
 */
public class DaoException extends RuntimeException{
		
		/**
		 * 默认的构造方法
		 */
		public DaoException(){
			
		}
		
		/**
		 * 构造方法
		 * @param arg0异常的详细信息
		 */
		public DaoException(String arg0){
			super(arg0);
		}
		
		/**
		 * 构造方法
		 * @param arg0异常的详细信息
		 */
		public DaoException(Throwable arg0){
			super(arg0);
		}
		
		/**
		 * 构造方法
		 * @param arg0异常的详细信息
		 * @param arg1产生异常的原因
		 */
		public DaoException(String arg0, Throwable arg1){
			super(arg0, arg1);
		}
}
