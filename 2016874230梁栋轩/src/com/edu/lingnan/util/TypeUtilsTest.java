package com.edu.lingnan.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TypeUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStrToDate() {
		Date date = TypeUtils.strToDate("2008-08-08");
		System.out.println(date);
	}

	@Test
	public void testDateToString() {
		Date date = new Date();
		String str = TypeUtils.dateToString(date);
		System.out.println(str);
	}

	@Test
	public void testCheckEmail() {
		boolean flag = TypeUtils.checkEmail("103@qq.com");
		System.out.println(flag);
	}

	@Test
	public void testCheckMoblieNumber() {
		boolean flag = TypeUtils.checkMoblieNumber("13659677882");
		System.out.println(flag);
	}

}
