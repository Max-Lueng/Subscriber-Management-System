package com.edu.lingnan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 类型转换类、控制类
 * @author 涟动喧
 *
 */
public class TypeUtils {
		
		/**
		 * 字符串转换为日期
		 * @param str 指定的字符串
		 * @return 转换后的日期
		 */
		public static Date strToDate(String str){
			Date date = null;
			//设置要格式化的日期格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				//调用parse方法，将字符串解析成指定格式的日期类型
				date = sdf.parse(str);
			} catch (ParseException e) {
				//将异常封装成自定义异常
				e.printStackTrace();
			}
			//返回转换后的值
			return date;
		}
		
		/**
		 * 日期转换为字符串
		 * @param date 指定的日期格式
		 * @return 转换后的字符串
		 */
		public static String dateToString(Date date){
			String str = null;
			//设置要格式化的日期格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				str = sdf.format(date);
			} catch (Exception e) {
				//将异常封装成自定义异常
				e.printStackTrace();
			}
			//返回转换后的值
			return str;
		}
		
		/**
		 * 验证邮箱
		 * @param email
		 * @return
		 */
		public static boolean checkEmail(String email){
			boolean flag = false;
			try {
				//邮箱验证正则表达式
				String check ="^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
				Pattern regex = Pattern.compile(check);
				Matcher matcher = regex.matcher(email);
				flag = matcher.matches();
			} catch (Exception e) {
				flag = false;
			}
			return flag;
		}
		
		/**
		 * 手机号码验证
		 * @param mobileNumber
		 * @return
		 */
		public static boolean checkMoblieNumber(String mobileNumber){
			boolean flag = false;
			try {
				//手机号码验证正则表达式
				String check = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
				Pattern regex = Pattern.compile(check);
				Matcher matcher = regex.matcher(mobileNumber);
				flag = matcher.matches();
			} catch (Exception e) {
				flag = false;
			}
			return flag;
		}
		
}
