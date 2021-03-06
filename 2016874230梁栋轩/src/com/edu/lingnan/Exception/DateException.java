package com.edu.lingnan.Exception;

/**
 * Date异常类
 * @author 涟动喧
 *
 */
public class DateException extends RuntimeException{
		
		/**
		 * 默认的构造方法
		 */
		public DateException(){
			
		}
		
		/**
		 * 构造方法
		 * @param arg0异常的详细信息
		 */
		public DateException(String arg0){
			super(arg0);
		}
		
		/**
		 * 构造方法
		 * @param arg0异常的详细信息
		 */
		public DateException(Throwable arg0){
			super(arg0);
		}
		
		/**
		 * 构造方法
		 * @param arg0异常的详细信息
		 * @param arg1产生异常的原因
		 */
		public DateException(String arg0, Throwable arg1){
			super(arg0, arg1);
		}
}
