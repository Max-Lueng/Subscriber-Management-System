package com.edu.lingnan.Exception;

/**
 * Email异常类
 * @author 涟动喧
 *
 */
public class EmailException extends RuntimeException{
		
		/**
		 * 默认的构造方法
		 */
		public EmailException(){
			
		}
		
		/**
		 * 构造方法
		 * @param arg0异常的详细信息
		 */
		public EmailException(String arg0){
			super(arg0);
		}
		
		/**
		 * 构造方法
		 * @param arg0异常的详细信息
		 */
		public EmailException(Throwable arg0){
			super(arg0);
		}
		
		/**
		 * 构造方法
		 * @param arg0异常的详细信息
		 * @param arg1产生异常的原因
		 */
		public EmailException(String arg0, Throwable arg1){
			super(arg0, arg1);
		}
}
