package com.edu.lingnan.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.edu.lingnan.common.dto.UserDto;
import com.edu.lingnan.controller.UserController;
import com.edu.lingnan.util.TypeUtils;

public class NormalFrame extends IndexFrame{
	
	//用户对象
	UserDto user = null;
	
	/**
	 * 带参数的构造器，用于初始化user属性
	 * @param user
	 */
	public NormalFrame(UserDto user) {
		this.user = user;
	}
	
	/**
	 * 普通用户主页面
	 */
	public void show(){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		UserController uc = new UserController();
		List<UserDto> lu = null;
		while(true){
			System.out.println("---------"+user.getName()+",欢迎您---------");
			System.out.println("===============================");
			System.out.println("查看个人信息--------------------1");
			System.out.println("修改个人信息--------------------2");
			System.out.println("退出登录-----------------------3");
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
			 * 判断用户输入值
			 * 如果值为1，查看个人信息
			 * 如果值为2，修改个人信息
			 * 如果值为3，退出登录
			 */
			switch(i){
			case 1:
				lu = uc.findUserByUserId(user.getUserid());
				Iterator uid = lu.iterator();
				System.out.print("用户编号"+"\t\t");
				System.out.print("用户姓名"+"\t");
				System.out.print("用户密码"+"\t");
				System.out.print("用户邮箱"+"\t\t");
				System.out.print("用户权限"+"\t");
				System.out.print("用户生日"+"\t\t");
				System.out.println("用户状态"+"\t");
				while(uid.hasNext()){
					user = (UserDto) uid.next();
					System.out.print(user.getUserid()+"\t");
					System.out.print(user.getName()+"\t");
					System.out.print(user.getPassword()+"\t");
					System.out.print(user.getMail()+"\t");
					System.out.print(user.getPower()+"\t");
					System.out.print(user.getBirth()+"\t");
					System.out.println(user.getStatus()+"\t");
				}
				break;//中断switch
			case 2:
				this.updateShow();
				break;//中断switch
			case 3:
				IndexFrame m = new IndexFrame();
				m.show();
				break;//中断switch
			default://输入值是1~3之外的数字
				System.out.println("您输入的操作不正确，请重新输入。");
			}
		}
	}
	
	/**
	 * 个人信息更新页面
	 */
	public void updateShow(){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		UserController uc = new UserController();

		System.out.println(this.user.getUserid());
		
		while(true){
			//用户修改页面
			System.out.println("-------欢迎来到用户修改页面-------");
			System.out.println("===============================");
			System.out.println("修改姓名------------------------1");
			System.out.println("修改密码------------------------2");
			System.out.println("修改邮箱------------------------3");
			System.out.println("修改权限------------------------4");
			System.out.println("修改生日------------------------5");
			System.out.println("修改状态------------------------6");
			System.out.println("退出修改------------------------7");
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
					System.out.println("输入错误，只能输入1~7的数字");
					System.out.println("请您重新输入");
				}
			}
			
			/**
			 * 判断用户输入值
			 * 如果值为1，查询个人信息
			 * 如果值为2，修改个人信息
			 */
			switch(i){
			/**
			 * 个人信息查询
			 */
			case 1:
				System.out.println("请修改姓名：");
				try {
					String name = br.readLine();
					this.user.setUserid(this.user.getUserid());
					this.user.setName(name);
					this.user.setPassword(this.user.getPassword());
					this.user.setMail(this.user.getMail());
					this.user.setPower(this.user.getPower());
					this.user.setBirth(this.user.getBirth());
					this.user.setStatus(this.user.getStatus());
					boolean flag = uc.updateUser(this.user);
					if(flag==true){
						System.out.println("修改成功");
					}
					else{
						//添加失败，显示失败信息
						System.out.println("修改失败");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;//中断switch
				
				
			/**
			 * 判断用户输入值
			 * 如果值为1，修改用户姓名
			 * 如果值为2，修改用户密码
			 * 如果值为3，修改用户邮箱
			 * 如果值为4，修改用户权限
			 * 如果值为5，修改用户生日
			 * 如果值为6，修改用户状态
			 * 如果值为7,退出修改操作
			 */
			case 2:
				System.out.println("请修改密码：");
				try {
					String password = br.readLine();
					this.user.setUserid(this.user.getUserid());
					this.user.setName(this.user.getName());
					this.user.setPassword(password);
					this.user.setMail(this.user.getMail());
					this.user.setPower(this.user.getPower());
					this.user.setBirth(this.user.getBirth());
					this.user.setStatus(this.user.getStatus());
					boolean flag = uc.updateUser(this.user);
					if(flag==true){
						System.out.println("修改成功");
					}
					else{
						//添加失败，显示失败信息
						System.out.println("修改失败");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;//中断switch
			case 3:
				System.out.println("请修改邮箱：");
				try {
					String mail = br.readLine();
					while(TypeUtils.checkEmail(mail)==false){
						System.out.println("您输入的邮箱有问题，请重新输入");
						mail = br.readLine();
					}
					this.user.setUserid(this.user.getUserid());
					this.user.setName(this.user.getName());
					this.user.setPassword(this.user.getPassword());
					this.user.setMail(mail);
					this.user.setPower(this.user.getPower());
					this.user.setBirth(this.user.getBirth());
					this.user.setStatus(this.user.getStatus());
					boolean flag = uc.updateUser(this.user);
					if(flag==true){
						System.out.println("修改成功");
					}
					else{
						//添加失败，显示失败信息
						System.out.println("修改失败");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;//中断switch
			case 4:
				System.out.println("请修改权限：");
				try {
					String power = br.readLine();
					this.user.setUserid(this.user.getUserid());
					this.user.setName(this.user.getName());
					this.user.setPassword(this.user.getPassword());
					this.user.setMail(this.user.getMail());
					this.user.setPower(power);
					this.user.setBirth(this.user.getBirth());
					this.user.setStatus(this.user.getStatus());
					boolean flag = uc.updateUser(this.user);
					if(flag==true){
						System.out.println("修改成功");
					}
					else{
						//添加失败，显示失败信息
						System.out.println("修改失败");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;//中断switch
			case 5:
				System.out.println("请修改生日（yyyy-mm-dd）:");
				try {
					Date birth = TypeUtils.strToDate(br.readLine());
					this.user.setUserid(this.user.getUserid());
					this.user.setName(this.user.getName());
					this.user.setPassword(this.user.getPassword());
					this.user.setMail(this.user.getMail());
					this.user.setPower(this.user.getPower());
					this.user.setBirth(birth);
					this.user.setStatus(this.user.getStatus());
					boolean flag = uc.updateUser(this.user);
					if(flag==true){
						System.out.println("修改成功");
					}
					else{
						//添加失败，显示失败信息
						System.out.println("修改失败");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;//中断switch
			case 6:
				System.out.println("请修改状态：");
				try {
					String status = br.readLine();
					this.user.setUserid(this.user.getUserid());
					this.user.setName(this.user.getName());
					this.user.setPassword(this.user.getPassword());
					this.user.setMail(this.user.getMail());
					this.user.setPower(this.user.getPower());
					this.user.setBirth(this.user.getBirth());
					this.user.setStatus(status);
					boolean flag = uc.updateUser(this.user);
					if(flag==true){
						System.out.println("修改成功");
					}
					else{
						//添加失败，显示失败信息
						System.out.println("修改失败");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;//中断switch
			case 7:
				this.show();
				break;
			default://输入值是1~7之外的数字
				System.out.println("您输入的操作不正确，请重新输入。");
			}
		}
	}

}
