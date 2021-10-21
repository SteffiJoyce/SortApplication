package com.game.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DateUtilTest {

	@Test
	public void testGetDay() {
	String day = DateUtil.getDay("2021-10-18T16:30:00");
	Assertions.assertEquals("Monday",  day);
	}
	
	@Test
	public void testGetWeekNumber() {
	int week = DateUtil.getWeekNumber("2021-10-18T16:30:00");
	Assertions.assertEquals(42,  week);
	}
	
	@Test
	public void testGetCurrentDate() {
	DateFormat dateFormat_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	String currentDate = DateUtil.getCurrentDate();
	Assertions.assertEquals(dateFormat_yyyy_MM_dd.format(new Date()),  currentDate);
	}
	
	@Test
	public void testFormatDate() {
	String date = DateUtil.formatDate("2021-10-18T16:30:00");
	Assertions.assertEquals("2021-10-18",  date);
	}
	
	@Test
	public void testAddYear() {
	String date = DateUtil.addYear("23/12");
	int year= DateUtil.getCurrentYear();
	Assertions.assertEquals("23/12/"+year,  date);
	}
	
}
