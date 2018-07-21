package com.edu.lingnan.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.edu.lingnan.common.dto.UserDto;
import com.edu.lingnan.controller.UserController;
import com.edu.lingnan.util.TypeUtils;

public class AdminFrame extends NormalFrame{
		
		/**
		 * 带参数的构造器，用于初始化user属性
		 * @param user
		 */
		public AdminFrame(UserDto user){
			super(user);
		}
		
		
		/**
		 * 登录成功页面
		 */
		public void loginSuccShow(){
			
			System.out.println("欢迎登录主窗体");
			System.out.println(user.getName()+"您好,"+"您的权限是："+ user.getPower());
			System.out.println("===============================");
			//管理员管理
			if(user.getPower().equals("管理员")){
				this.show();
			}
			else{
				new NormalFrame(user).show();
			}
		}
		
		/**
		 * 注册/添加成功页面
		 */
		public void addUserSuccShow(){
			System.out.println("恭喜您注册成功，您的账号名为" + user.getName() + ",您现在可以用该账号登录");
		}
		
		/**
		 * 管理员主页面
		 */
		public void show(){
			//声明缓冲处理流对象，用于接收控制台输入的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				System.out.println("-------欢迎来到管理员页面---------");
				System.out.println("===============================");
				System.out.println("查询用户-----------------------1");
				System.out.println("修改用户-----------------------2");
				System.out.println("添加用户-----------------------3");
				System.out.println("删除用户-----------------------4");
				System.out.println("退出登录-----------------------5");
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
						System.out.println("输入错误，只能输入1~5的数字");
						System.out.println("请您重新输入");
					}
				}
				
				/**
				 * 判断用户输入值
				 * 如果值为1，进行用户查询操作
				 * 如果值为2，进行用户修改操作
				 * 如果值为3，用户添加操作
				 * 如果值为4，用户删除操作
				 * 如果值为5，退出登录
				 */
				switch(i){
				case 1:
					this.searchShow();
					break;//中断switch
				case 2:
					this.updateShow();
					break;//中断switch
				case 3:
					this.addShow();
					break;//中断switch	
				case 4:
					this.deleteShow();
					break;//中断switch
				case 5:
					IndexFrame m = new IndexFrame();
					m.show();
					break;//中断switch
				default://输入值是1~3之外的数字
					System.out.println("您输入的操作不正确，请重新输入。");
				}
				
			}
			
		}
		
		/**
		 * 管理员查询页面
		 */
		public void searchShow(){
			//声明缓冲处理流对象，用于接收控制台输入的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			UserDto user = null;
			UserController uc = new UserController();
			List<UserDto> lu = null;
			//循环操作
			while(true){
				//用户登录和注册页面
				System.out.println("-------欢迎来到用户查询页面-------");
				System.out.println("===============================");
				System.out.println("查询全部用户--------------------1");
				System.out.println("分页查询全部用户-----------------2");
				System.out.println("按userid查询用户(支持模糊查询)----3");
				System.out.println("按用户名查询用户(支持模糊查询)-----4");
				System.out.println("查询全部有效用户-----------------5");
				System.out.println("查询全部无效用户-----------------6");
				System.out.println("退出查询操作--------------------7");
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
				 * 如果值为1，查询全部用户
				 * 如果值为2，分页查询全部用户
				 * 如果值为3，按userid查询用户
				 * 如果值为4，按用户名查询用户
				 * 如果值为5，查询全部有效用户
				 * 如果值为6，查询全部无效用户
				 * 如果值为7，退出查询
				 */
				switch(i){
				case 1:
					lu = uc.findAll();
					Iterator it = lu.iterator();
					System.out.print("用户编号"+"\t\t");
					System.out.print("用户姓名"+"\t");
					System.out.print("用户密码"+"\t");
					System.out.print("用户邮箱"+"\t\t");
					System.out.print("用户权限"+"\t");
					System.out.print("用户生日"+"\t\t");
					System.out.println("用户状态"+"\t");
					while(it.hasNext()){
						user = (UserDto) it.next();
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
					System.out.println("请输入要每页显示条数");
					try {
						int pageSize = Integer.parseInt(br.readLine());
						System.out.println("请输入要查询的页码");
						int pageNo = Integer.parseInt(br.readLine());
						lu = uc.findUsers(pageNo, pageSize);
						Iterator page = lu.iterator();
						System.out.print("用户编号"+"\t\t");
						System.out.print("用户姓名"+"\t");
						System.out.print("用户密码"+"\t");
						System.out.print("用户邮箱"+"\t\t");
						System.out.print("用户权限"+"\t");
						System.out.print("用户生日"+"\t\t");
						System.out.println("用户状态"+"\t");
						while(page.hasNext()){
							user = (UserDto) page.next();
							System.out.print(user.getUserid()+"\t");
							System.out.print(user.getName()+"\t");
							System.out.print(user.getPassword()+"\t");
							System.out.print(user.getMail()+"\t");
							System.out.print(user.getPower()+"\t");
							System.out.print(user.getBirth()+"\t");
							System.out.println(user.getStatus()+"\t");
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;//中断switch
				case 3:
					String userid = null;
					try {
						userid = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lu = uc.findUserByUserId(userid);
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
				case 4:
					String name = null;
					try {
						name = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lu = uc.findUserByName(name);
					Iterator uname = lu.iterator();
					System.out.print("用户编号"+"\t\t");
					System.out.print("用户姓名"+"\t");
					System.out.print("用户密码"+"\t");
					System.out.print("用户邮箱"+"\t\t");
					System.out.print("用户权限"+"\t");
					System.out.print("用户生日"+"\t\t");
					System.out.println("用户状态"+"\t");
					while(uname.hasNext()){
						user = (UserDto) uname.next();
						System.out.print(user.getUserid()+"\t");
						System.out.print(user.getName()+"\t");
						System.out.print(user.getPassword()+"\t");
						System.out.print(user.getMail()+"\t");
						System.out.print(user.getPower()+"\t");
						System.out.print(user.getBirth()+"\t");
						System.out.println(user.getStatus()+"\t");
					}
					break;//中断switch
				case 5:
					lu = uc.findAllValid();
					Iterator valid = lu.iterator();
					System.out.print("用户编号"+"\t\t");
					System.out.print("用户姓名"+"\t");
					System.out.print("用户密码"+"\t");
					System.out.print("用户邮箱"+"\t\t");
					System.out.print("用户权限"+"\t");
					System.out.print("用户生日"+"\t\t");
					System.out.println("用户状态"+"\t");
					while(valid.hasNext()){
						user = (UserDto) valid.next();
						System.out.print(user.getUserid()+"\t");
						System.out.print(user.getName()+"\t");
						System.out.print(user.getPassword()+"\t");
						System.out.print(user.getMail()+"\t");
						System.out.print(user.getPower()+"\t");
						System.out.print(user.getBirth()+"\t");
						System.out.println(user.getStatus()+"\t");
					}
					break;//中断switch
				case 6:
					lu = uc.findAllNotValid();
					Iterator unvalid = lu.iterator();
					System.out.print("用户编号"+"\t\t");
					System.out.print("用户姓名"+"\t");
					System.out.print("用户密码"+"\t");
					System.out.print("用户邮箱"+"\t\t");
					System.out.print("用户权限"+"\t");
					System.out.print("用户生日"+"\t\t");
					System.out.println("用户状态"+"\t");
					while(unvalid.hasNext()){
						user = (UserDto) unvalid.next();
						System.out.print(user.getUserid()+"\t");
						System.out.print(user.getName()+"\t");
						System.out.print(user.getPassword()+"\t");
						System.out.print(user.getMail()+"\t");
						System.out.print(user.getPower()+"\t");
						System.out.print(user.getBirth()+"\t");
						System.out.println(user.getStatus()+"\t");
					}
					break;//中断switch
				case 7:
					this.show();
					break;//中断switch
				default://输入值是1~7之外的数字
					System.out.println("您输入的操作不正确，请重新输入。");
				}
			}
		}
		
		/**
		 * 管理员修改页面
		 */
		public void updateShow(){
			//声明缓冲处理流对象，用于接收控制台输入的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			UserDto user = null;
			UserController uc = new UserController();
			List<UserDto> lu = null;
			//用户修改页面
			System.out.println("-------欢迎来到用户修改页面-------");
			System.out.println("===============================");
			lu = uc.findAll();
			Iterator uAll = lu.iterator();
			System.out.print("用户编号"+"\t\t");
			System.out.print("用户姓名"+"\t");
			System.out.print("用户密码"+"\t");
			System.out.print("用户邮箱"+"\t\t");
			System.out.print("用户权限"+"\t");
			System.out.print("用户生日"+"\t\t");
			System.out.println("用户状态"+"\t");
			while(uAll.hasNext()){
				user = (UserDto) uAll.next();
				System.out.print(user.getUserid()+"\t");
				System.out.print(user.getName()+"\t");
				System.out.print(user.getPassword()+"\t");
				System.out.print(user.getMail()+"\t");
				System.out.print(user.getPower()+"\t");
				System.out.print(user.getBirth()+"\t");
				System.out.println(user.getStatus()+"\t");
			}
			System.out.println("请先输入您要修改的用户,再进行其他操作！");
			String userid;
			try {
				userid = br.readLine();
				lu = uc.findUserByUserId(userid);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
			//循环操作
			while(true){
				System.out.println("修改用户姓名--------------------1");
				System.out.println("修改用户密码--------------------2");
				System.out.println("修改用户邮箱--------------------3");
				System.out.println("修改用户权限--------------------4");
				System.out.println("修改用户生日--------------------5");
				System.out.println("修改用户状态--------------------6");
				System.out.println("退出修改操作--------------------7");
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
				 * 如果值为1，修改用户姓名
				 * 如果值为2，修改用户密码
				 * 如果值为3，修改用户邮箱
				 * 如果值为4，修改用户权限
				 * 如果值为5，修改用户生日
				 * 如果值为6，修改用户状态
				 * 如果值为7,退出修改操作
				 */
				switch(i){
				case 1:
					System.out.println("请修改用户姓名：");
					try {
						String name = br.readLine();
						user.setUserid(user.getUserid());
						user.setName(name);
						user.setPassword(user.getPassword());
						user.setMail(user.getMail());
						user.setPower(user.getPower());
						user.setBirth(user.getBirth());
						user.setStatus(user.getStatus());
						boolean flag = uc.updateUser(user);
						if(flag==true){
							System.out.println("修改成功");
						}
						else{
							//添加失败，显示失败信息
							System.out.println("修改失败");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;//中断switch
				case 2:
					System.out.println("请修改用户密码：");
					try {
						String password = br.readLine();
						user.setUserid(user.getUserid());
						user.setName(user.getName());
						user.setPassword(password);
						user.setMail(user.getMail());
						user.setPower(user.getPower());
						user.setBirth(user.getBirth());
						user.setStatus(user.getStatus());
						boolean flag = uc.updateUser(user);
						if(flag==true){
							System.out.println("修改成功");
						}
						else{
							//添加失败，显示失败信息
							System.out.println("修改失败");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;//中断switch
				case 3:
					System.out.println("请修改用户邮箱：");
					try {
						String mail = br.readLine();
						while(TypeUtils.checkEmail(mail)==false){
							System.out.println("您输入的邮箱有问题，请重新输入");
							mail = br.readLine();
						}
						user.setUserid(user.getUserid());
						user.setName(user.getName());
						user.setPassword(user.getPassword());
						user.setMail(mail);
						user.setPower(user.getPower());
						user.setBirth(user.getBirth());
						user.setStatus(user.getStatus());
						boolean flag = uc.updateUser(user);
						if(flag==true){
							System.out.println("修改成功");
						}
						else{
							//添加失败，显示失败信息
							System.out.println("修改失败");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;//中断switch
				case 4:
					System.out.println("请修改用户权限：");
					try {
						String power = br.readLine();
						user.setUserid(user.getUserid());
						user.setName(user.getName());
						user.setPassword(user.getPassword());
						user.setMail(user.getMail());
						user.setPower(power);
						user.setBirth(user.getBirth());
						user.setStatus(user.getStatus());
						boolean flag = uc.updateUser(user);
						if(flag==true){
							System.out.println("修改成功");
						}
						else{
							//添加失败，显示失败信息
							System.out.println("修改失败");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;//中断switch
				case 5:
					System.out.println("请修改用户生日（yyyy-mm-dd）:");
					try {
						Date birth = TypeUtils.strToDate(br.readLine());
						user.setUserid(user.getUserid());
						user.setName(user.getName());
						user.setPassword(user.getPassword());
						user.setMail(user.getMail());
						user.setPower(user.getPower());
						user.setBirth(birth);
						user.setStatus(user.getStatus());
						boolean flag = uc.updateUser(user);
						if(flag==true){
							System.out.println("修改成功");
						}
						else{
							//添加失败，显示失败信息
							System.out.println("修改失败");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;//中断switch
				case 6:
					System.out.println("请修改用户状态：");
					try {
						String status = br.readLine();
						user.setUserid(user.getUserid());
						user.setName(user.getName());
						user.setPassword(user.getPassword());
						user.setMail(user.getMail());
						user.setPower(user.getPower());
						user.setBirth(user.getBirth());
						user.setStatus(status);
						boolean flag = uc.updateUser(user);
						if(flag==true){
							System.out.println("修改成功");
						}
						else{
							//添加失败，显示失败信息
							System.out.println("修改失败");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
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
		
		/**
		 * 管理员添加页面
		 */
		public void addShow(){
			//声明缓冲处理流对象，用于接收控制台输入的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			UserController uc = new UserController();
			//用户登录和注册页面
			System.out.println("-------欢迎来到用户添加页面-------");
			System.out.println("===============================");
			System.out.println("请输入您的用户姓名：");
			try {
				//以行为单位，读取输入的值，赋值给对象的各个属性
				String name = br.readLine();
				System.out.println("请输入您的用户密码");
				String password = br.readLine();
				System.out.println("请输入您的用户邮箱");
				String mail = br.readLine();
				while(TypeUtils.checkEmail(mail)==false){
					System.out.println("您输入的邮箱有问题，请重新输入");
					mail = br.readLine();
				}
				System.out.println("请输入生日（yyyy-mm-dd）:");
				Date birth = TypeUtils.strToDate(br.readLine());
				user.setName(name);
				user.setPassword(password);
				user.setMail(mail);
				user.setBirth(birth);
				boolean binsert = uc.doRegister(user);
				if(binsert==true){
					System.out.println("添加成功");
					System.out.println("恭喜您添加成功，您的账号名为" + user.getName() + "    您现在可以用该账号登录");
					this.show();
				}
				else{
					//添加失败，显示失败信息
					System.out.println("添加失败");
					this.show();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		}
		
		/**
		 * 管理员删除页面
		 */
		public void deleteShow(){
			//声明缓冲处理流对象，用于接收控制台输入的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			boolean flag = false;
			UserController uc = new UserController();
			//循环操作
			while(true){
				//用户登录和注册页面
				System.out.println("-------欢迎来到用户删除页面-------");
				System.out.println("===============================");
				System.out.println("按userid删除用户----------------1");
				System.out.println("按用户名删除用户-----------------2");
				System.out.println("退出删除操作--------------------3");
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
				 * 如果值为1，按userid删除用户
				 * 如果值为2，按用户名删除用户
				 * 如果值为3，退出删除
				 */
				switch(i){
				case 1:
					String userid = null;
					try {
						userid = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					flag = uc.deleteUserByUserid(userid);
					if(flag==true){
						System.out.println("删除成功！！！");
					}
					else{
						System.out.println("删除失败！！！");
					}
					break;//中断switch
				case 2:
					String name = null;
					try {
						name = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					flag = uc.deleteUserByName(name);
					if(flag==true){
						System.out.println("删除成功！！！");
					}
					else{
						System.out.println("删除失败！！！");
					}
					break;//中断switch
				case 3:
					this.show();
					//退出当前页面
					break;//中断switch
				default://输入值是1~3之外的数字
					System.out.println("您输入的操作不正确，请重新输入。");
				}
			}
		}
	
}
