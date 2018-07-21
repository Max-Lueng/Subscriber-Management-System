package com.edu.lingnan.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import com.edu.lingnan.common.dto.UserDto;
import com.edu.lingnan.controller.UserController;
import com.edu.lingnan.util.TypeUtils;

public class IndexFrame implements BaseFrame{

		/**
		 * 系统主页面
		 */
		public void show(){
			//声明缓冲处理流对象，用于接收控制台输入的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			//循环操作
			while(true){
				//用户登录和注册页面
				System.out.println("欢迎使用LEUNG的用户管理系统");
				System.out.println("========================");
				System.out.println("用户登录----------------1");
				System.out.println("用户注册----------------2");
				System.out.println("退出程序----------------3");
				int i = -1;
				//读取用户控制器输入，如果输入值正确，中断循环，否则提示错误信息，再重新输入
				while(true){
					try {
						//读取用户输入操作选项的数字，同时转换为int型
						i = Integer.parseInt(br.readLine());
						//中断该循环，进入下一步操作：i值判断
						break;
					} catch (Exception e) {
						//出现异常时，提示错误信息，再重新输入
						System.out.println("输入错误，只能输入1~3的数字");
						System.out.println("请您重新输入");
					}
				}
				
				/**
				 * 判断用户输入值，如果值为1，进行用户登录操作，
				 * 如果值为2，进行用户注册操作，如果值为3，退出系统
				 */
				switch(i){
				case 1:
					this.loginShow();
					break;//中断switch
				case 2:
					this.addShow();
					break;//中断switch
				case 3:
					System.out.println("感谢您的使用。再会！");
					//退出当前页面
					System.exit(0);
				default://输入值是1~3之外的数字
					System.out.println("您输入的操作不正确，请重新输入。");
				}
			}
		}
		
		/**
		 * 登录操作
		 */
		public void loginShow(){
			//声明缓冲处理流对象，用于接收控制台输入的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("用户登录页面");
			System.out.println("===============================");
			System.out.println("请输入您的用户编号：");
			try {
				//以行为单位，读取输入的值，赋值给对象的各个属性
				String name = br.readLine();
				System.out.println("请输入您的用户密码");
				String password = br.readLine();
				//调用控制器中的doLogin方法，进行用户登录操作
				UserController uc = new UserController();
				UserDto user = uc.doLogin(name, password);
				if(user!=null){
					System.out.println("登录成功");
					System.out.println("===============================");
					//调用主页面
					AdminFrame m = new AdminFrame(user);
					m.loginSuccShow();
				}
				else{
					//登录失败，显示失败信息
					System.out.println("登录失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * 注册操作
		 */
		public void addShow() {
			//声明缓冲处理流对象，用于接收控制台输入的数据
			UserDto user = new UserDto();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("用户注册页面");
			System.out.println("===============================");
			System.out.println("请输入您的用户姓名：");
			try {
				//以行为单位，读取输入的值，赋值给对象的各个属性
				String name = br.readLine();
				System.out.println("请输入您的用户密码");
				String password = br.readLine();
				System.out.println("请输入您的用户邮箱");
				String mail = br.readLine();
				if(TypeUtils.checkEmail(mail)==false){
					System.out.println("您输入的邮箱有问题，请重新输入");
					mail = br.readLine();
				}
				System.out.println("请输入生日（yyyy-mm-dd）:");
				Date birth = TypeUtils.strToDate(br.readLine());
				user.setName(name);
				user.setPassword(password);
				user.setMail(mail);
				user.setBirth(birth);
				UserController uc = new UserController();
				boolean binsert = uc.doRegister(user);
				if(binsert==true){
					System.out.println("注册成功");
					System.out.println("===============================");
					//调用主页面
					AdminFrame m = new AdminFrame(user);
					m.addUserSuccShow();
				}
				else{
					//注册失败，显示失败信息
					System.out.println("注册失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}



	
}
