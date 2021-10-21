package com.game.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	
	public static final DateFormat dateFormat_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat dateFormat_dd_MM_yyyy = new SimpleDateFormat("dd/MM/yyyy");
	public static final DateFormat zoneDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	public static Locale locale = new Locale("en");
	public static LocalDate currentdate = LocalDate.now();

	/**
	 * Method to retrieve day for a specific date.
	 * @param date
	 * @return
	 */
	public static String getDay(String date) {
	    DayOfWeek day = parseDate(date).getDayOfWeek();
	    return day.getDisplayName(TextStyle.FULL, locale);
	}
	
	/**
	 * Method to retrieve Week number for a specific date.
	 * @param date
	 * @return
	 */
	public static int getWeekNumber(String date) {
		int year = parseDate(date).getYear();
		int month = parseDate(date).getMonthValue();
		int dateValue = parseDate(date).getDayOfMonth();
		LocalDate localDate = LocalDate.of(year, month, dateValue);
		int weekOfYear = localDate.get(WeekFields.of(Locale.FRANCE).weekOfYear());
		return weekOfYear;
	}
	
	/**
	 * Method to convert String to LocalDateTime
	 * @param date
	 * @return
	 */
	public static LocalDateTime parseDate(String date) {
		return LocalDateTime.parse(date);
	}
	
	/**
	 * Method to get current system date.
	 * @param date
	 * @return
	 */
	public static String getCurrentDate() {
		String currDate =dateFormat_yyyy_MM_dd.format(new Date());
		return currDate !=null?currDate:"";
	}
	
	/**
	 * Method to format date as yyyy-MM-dd.
	 * @param date
	 * @return
	 */
	public static String formatDate(String inputDate) {
		try {
			Date date = zoneDateFormat.parse(inputDate);
			return dateFormat_yyyy_MM_dd.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * Method to retrieve current year.
	 * @return
	 */
	public static int getCurrentYear() {
		return currentdate.getYear();
	}
	
	/**
	 * Method to get Date in dd/MM/yyyy format.
	 * @param date
	 * @return
	 */
	public static String addYear(String inputDate) {
		return inputDate+"/"+Integer.toString(getCurrentYear());

	}
	
}
