package com.zz624.test;

import static org.junit.Assert.*;

import java.util.Scanner;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zz624.biz.UserBiz;
import com.zz624.entry.User;

public class UserTest {
	@Autowired
	private UserBiz ub;
	Scanner sc = new Scanner(System.in);
	@Test
	public void test() {
		ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		
		
		User user = new User();
		System.out.println("请输入用户名：");
		user.setUserid(sc.nextInt());
		System.out.println("请输入密码：");
		user.setUserpwd(sc.next());
		user.setRole("5");
		user.setPower(5);
		User u = ub.selectOwn(user);
		System.out.println(u);
		System.out.println(u.getRole());
	}

}
