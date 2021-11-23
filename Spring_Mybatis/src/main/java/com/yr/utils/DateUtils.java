package com.yr.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Title: ���ڲ�����
 * </p>
 * <p>
 * Description: ���һЩ�����ڵļ��㹤��
 * </p>
 * 
 * @version 1.0
 */
public class DateUtils {
	public static final String YM_FORMAT = "yyyy-MM";
	// Ĭ����ʾ���ڵĸ�ʽ
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIMEF_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// Ĭ����ʾ����ʱ������ʽ
	public static final String MSEL_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	// Ĭ����ʾ�����������ڵĸ�ʽ
	public static final String ZHCN_DATE_FORMAT = "yyyy��MM��dd��";
	// Ĭ����ʾ������������ʱ��ĸ�ʽ
	public static final String ZHCN_TIME_FORMAT = "yyyy��MM��dd��HHʱmm��ss��";
	// Ĭ����ʾ������������ʱ������ʽ
	public static final String ZHCN_MSEL_FORMAT = "yyyy��MM��dd��HHʱmm��ss��SSS����";
	// ��ȡ���ڴ���ʽ
	public static final String DATE_STR_FORMAT = "yyyyMMdd";
	// ��ȡ����ʱ�䴮��ʽ
	public static final String TIME_STR_FORMAT = "yyyyMMddHHmmss";
	// ��ȡ����ʱ����봮��ʽ
	public static final String MSEL_STR_FORMAT = "yyyyMMddHHmmssSSS";
	private static DateFormat dateFormat = null;
	private static DateFormat dateTimeFormat = null;
	private static DateFormat zhcnDateFormat = null;
	private static DateFormat zhcnDateTimeFormat = null;

	static {
		dateFormat = new SimpleDateFormat(DATE_FORMAT);
		dateTimeFormat = new SimpleDateFormat(TIMEF_FORMAT);
		zhcnDateFormat = new SimpleDateFormat(ZHCN_DATE_FORMAT);
		zhcnDateTimeFormat = new SimpleDateFormat(ZHCN_TIME_FORMAT);
	}

	/**
	 * ��ȡ��������ڣ���ʽ�磺2006-11-09
	 * 
	 * @return String - ���ؽ�������� 
	 */
	public static String getToday() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * ��ȡ��������ڣ���ʽ�Զ�
	 * 
	 * @param pattern
	 *            - �趨��ʾ��ʽ
	 * @return String - ���ؽ��������
	 */
	public static String getToday(String pattern) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}
	
	/**
	 * �õ���ǰʱ���ǰ/���������ʱ�� ���統ǰʱ��2006-05-16 �������30�죬�򷵻�2006-04-16
	 * 
	 * @param days
	 *            - �������
	 * @return String - ���ص�ʱ��ʱ��
	 */
	public static String getInternalTimeByDay(int days) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.DATE, days);
		return (sdf.format(now.getTime()));
	}

	/**
	 * �õ���ǰʱ���ǰ/���������ʱ�� ���統ǰʱ��2006-05-16 �������30�죬�򷵻�2006-04-16
	 * 
	 * @param days
	 *            - �������
	 * @param pattern
	 *            - �趨��ʾ��ʽ
	 * @return String - ������ʾ��ʽ���ص�ʱ��ʱ��
	 */
	public static String getInternalTimeByDay(int days, String pattern) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.DATE, days);
		return (sdf.format(now.getTime()));
	}

	/**
	 * �õ���ǰʱ���ǰ/�������µ�ʱ�� ���統ǰʱ��2006-05-16 �������3�£��򷵻�2006-02-16
	 * 
	 * @param months
	 * @return - ���ص�ʱ��ʱ��
	 */
	public static String getInternalTimeByMonth(int months) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.MONTH, months);
		return (sdf.format(now.getTime()));
	}

	/**
	 * �õ���ǰʱ���ǰ/�������µ�ʱ�� ���統ǰʱ��2006-05-16 �������3�£��򷵻�2006-02-16
	 * 
	 * @param months
	 *            - �������
	 * @param pattern
	 *            - �趨��ʾ��ʽ
	 * @return - ������ʾ��ʽ���ص�ʱ��ʱ��
	 */
	public static String getInternalTimeByMonth(int months, String pattern) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.MONTH, months);
		return (sdf.format(now.getTime()));
	}

	/**
	 * �õ���������
	 * 
	 * @param dateStr
	 *            - ���ڴ�����ʽΪ��yyyy-MM-dd��
	 * @return String - �����������ڣ���ʽΪ��yyyy��MM��dd�ա�
	 */
	public static String chinaDate(String dateStr) {
		if (dateStr == null || dateStr.equals("null") || dateStr.equals("")) {
			return "";
		}
		Date d = getDate(dateStr, DATE_FORMAT);
		SimpleDateFormat sdf = new SimpleDateFormat(ZHCN_DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(d));
	}

	/**
	 * �õ���������,�Զ����ø�ʽ
	 * 
	 * @param dateStr
	 *            - ��Ҫ�ı��ʽ��ʱ�䴮
	 * @param inPattern
	 *            - ʱ�䴮�ĸ�ʽ
	 * @param outPattern
	 *            - ��Ϊʱ�䴮�ĸ�ʽ
	 * @return String - ����outPattern��ʽ����ʱ��
	 */
	public static String alterDateByDynamic(String dateStr, String inPattern, String outPattern) {
		if (dateStr == null || dateStr.equals("null") || dateStr.equals("")) {
			return "";
		}
		Date d = getDate(dateStr, inPattern);
		SimpleDateFormat sdf = new SimpleDateFormat(outPattern);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(d));
	}

	/**
	 * �Ƚϵ�ǰ���ں�ָ������ return boolean �����ǰ������ָ������֮�󷵻�true���򷵻�flase
	 * 
	 * @param dateStr
	 *            ָ������
	 * @param pattern
	 *            ָ�����ڵĸ�ʽ
	 * @return boolean
	 */
	public static boolean dateCompare(String dateStr, String pattern) {
		boolean bea = false;
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		String isDate = dateFormat.format(new java.util.Date());
		Date date1;
		Date date0;
		try {
			date1 = dateFormat.parse(dateStr);
			date0 = dateFormat.parse(isDate);
			if (date0.after(date1)) {
				bea = true;
			}
		} catch (ParseException e) {
			bea = false;
		}
		return bea;
	}

	/**
	 * �Ƚ�ָ��������,���dateStr����dateStr2��return true;
	 * 
	 * @param dateStr1
	 *            ָ������
	 * @param dateStr2
	 *            ָ������
	 * @param pattern
	 *            ָ�����ڵĸ�ʽ
	 * @return boolean
	 */
	public static boolean dateCompare(String dateStr1, String dateStr2, String pattern) {
		boolean bea = false;
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date date1;
		Date date0;
		try {
			date1 = df.parse(dateStr1);
			date0 = df.parse(dateStr2);
			if (date0.after(date1)) {
				bea = true;
			}
		} catch (ParseException e) {
			bea = false;
		}
		return bea;
	}
	
	/**
	 * �Ƚ�ָ��������,���date1����date2��return true;
	 * 
	 * @param dateStr1
	 *            ָ������
	 * @param dateStr2
	 *            ָ������
	 * @param pattern
	 *            ָ�����ڵĸ�ʽ
	 * @return boolean
	 */   
	public static boolean dateCompare(Date date1, Date date2) {
		boolean bea = false;
		try {
			if (date1.after(date2)) {
				bea = true;
			}
		} catch (Exception e) {
			bea = false;
		}
		return bea;
	}


	/**
	 * ���ü�����󷵻�ʱ��
	 * 
	 * @param type
	 *            ������� ������� �������Ϊs,�������Ϊd
	 * @param �������
	 *            ����1�����һ��
	 * @return String ����ʱ���ʽΪ��yyyy-MM-dd HH:mm:ss��
	 */
	public static String dateAdd(String type, int i) {
		SimpleDateFormat df = new SimpleDateFormat(TIMEF_FORMAT);
		String str = getToday(TIMEF_FORMAT);
		Calendar c = Calendar.getInstance(); // ��ʱ�����ں�ʱ��
		if (type.equals("s")) {
			int s = c.get(Calendar.SECOND);
			s = s + i;
			c.set(Calendar.SECOND, s);
			str = df.format(c.getTime());
		} else if (type.equals("d")) {
			int d = c.get(Calendar.DAY_OF_MONTH); // ȡ�����ա���
			d = d + i;
			c.set(Calendar.DAY_OF_MONTH, d); // �����ա������û�ȥ
			str = df.format(c.getTime());
		}
		return str;
	}

	/**
	 * �õ���ǰ���ڣ���"2001-03-16".
	 *
	 * @version 1.0
	 * @author wanghaibo.
	 */
	public static String curDate() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		String format = "yyyy-MM-dd";
		// String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		// String DATE_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * �õ���ǰ��ϸ���ڡ�ʱ�䣬��"2001-03-16 20:34:20".
	 *
	 */
	public static String curTime() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		// String DATE_FORMAT = "yyyy-MM-dd";
		String format = "yyyy-MM-dd HH:mm:ss";
		// String DATE_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * �õ���ǰ��ϸ���ڡ�ʱ�䣬��"2001-03-16 20:34:20".
	 *
	 * @version 1.0
	 */
	public static String getTimeAfter(int n) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.add(Calendar.MINUTE, n);
		// String DATE_FORMAT = "yyyy-MM-dd";
		// String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		// String DATE_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(TIMEF_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * �õ���ǰʱ���ǰ/���������ʱ��
	 * 
	 * @param day
	 *            - ���ʱ��
	 * @return - ���ص�ʱ��ʱ�� ���統ǰʱ��2003-05-16 �������30�죬�򷵻�2003-04-16
	 */
	public static String getInternalTime(int days) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		// String DATE_FORMAT = "yyyy-MM-dd";
		// String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		// String DATE_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(TIMEF_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.DATE, days);
		return (sdf.format(now.getTime()));
	}

	/**
	 * �õ���ǰʱ���ǰ/���������ʱ��
	 * 
	 * @param currentTime
	 *            - ��ǰʱ��
	 * @param iHour
	 *            - ���ʱ��
	 * @return - ���ص�ʱ��ʱ�� ���統ǰʱ��2003-05-16 08:10:10 ���ʱ��3Сʱ���򷵻�2003-05-16
	 *         05:10:10
	 */
	public static String getTimeOut(String currentTime, int iHour) {
		String time = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(TIMEF_FORMAT);
			java.util.Date result = sdf.parse(currentTime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(result);
			cal.add(Calendar.HOUR, iHour);
			time = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return time;
	}

	/**
	 * �õ���ǰ�µ׵�ǰ/���������ʱ��
	 * 
	 * @param day
	 *            - ���ʱ��
	 * @return - ���ص�ʱ��ʱ��
	 */
	public static String getInternalTimeByLastDay(int days) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		// String DATE_FORMAT = "yyyy-MM-dd";
		// String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		// String DATE_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		int maxDay = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		now.set(Calendar.DATE, maxDay);
		now.add(Calendar.DATE, days);
		return (sdf.format(now.getTime()));
	}

	/**
	 * �õ�ʱ�䴮
	 * 
	 * @param dateStr
	 *            String ʱ���ַ���
	 * @param fmt
	 *            String ʱ���ʽ
	 * @return String ����ֵ
	 */
	public static String getDateStr(String dateStr, String fmt) {
		try {
			if (dateStr == null || dateStr.equals("")) {
				return "";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(fmt);
			// java.text.DateFormat df =
			// java.text.DateFormat.getDateTimeInstance();
			Date d = sdf.parse(dateStr);
			String newDate = sdf.format(d);
			return newDate;
		} catch (Exception e) {
			e.printStackTrace();
			// log.debug("\n" + e.getMessage());
		}
		return "";
	}

	/**
	 * �õ�ʱ�䴮
	 * 
	 * @param dateStr
	 *            String ʱ���ַ���
	 * @param fmt
	 *            String ʱ���ʽ
	 * @return String ����ֵ
	 */
	public static Date getDate(String dateStr) {
		try {
			if (dateStr == null || dateStr.equals("")) {
				return null;
			}
			// Calendar now = Calendar.getInstance(TimeZone.getDefault());
			// String DATE_FORMAT = "yyyyMMddHHmmss";
			// java.text.SimpleDateFormat sdf = new
			// java.text.SimpleDateFormat(DATE_FORMAT);
			SimpleDateFormat sdf = new SimpleDateFormat(TIME_STR_FORMAT);
			// sdf.setTimeZone(TimeZone.getDefault());
			Date d = sdf.parse(dateStr);
			// java.text.DateFormat df =
			// java.text.DateFormat.getDateTimeInstance();
			// java.util.Date d= df.parse(dateStr);
			return d;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * @return �õ���ǰʱ��Ŀ¼���� 030524
	 */
	public static String getCurrTimeDir() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		String format = "yyMMdd";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 *
	 * @return �õ��ϸ����·� ��200505
	 */
	public static String getYesterM() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.add(Calendar.MONTH, -2);
		String format = "yyyyMM";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 *
	 * @return �õ��������� ��2005
	 */
	public static String getYear() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		// now.add(Calendar.MONTH,-1);
		String format = "yyyy";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 *
	 * @return �õ������·� ��09
	 */
	public static String getMonth() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.add(Calendar.MONTH, -1);
		String format = "MM";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}
	
	/**
	 *
	 * @return �õ������·� ��09
	 */
	public static String getDay() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.add(Calendar.MONTH, -1);
		String format = "DD";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}
	
	/**
	 * �õ���һ���·֣������꣬���磺 2003��1 �·ݵ���һ���·���2002��12
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String[] getBeforeMonth(String year, String month) {
		String[] time = new String[2];
		if (month.equals("12")) {
			time[1] = "1";
			time[0] = String.valueOf(Integer.parseInt(year) + 1);
		} else {
			time[1] = String.valueOf(Integer.parseInt(month) + 1);
			time[0] = year;
		}
		return time;
	}

	/**
	 * �õ���һ����
	 * 
	 * @param year
	 *            ��
	 * @param month
	 *            ��
	 * @return String[] 0Ϊ��,1Ϊ�� TODO
	 */
	public static String[] beforeMonth(String year, String month) {
		String[] time = new String[2];
		if (month.equals("1")) {
			time[1] = "12";
			time[0] = String.valueOf(Integer.parseInt(year) - 1);
		} else {
			time[1] = String.valueOf(Integer.parseInt(month) - 1);
			time[0] = year;
		}
		return time;
	}

	/**
	 * �õ���ǰ���ڣ�����ҳ�����ڿؼ���ʽ����"2001-3-16".
	 * 
	 * @return String TODO
	 */
	public static String curSingleNumDate() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		String format = "yyyy-M-d";
		// String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		// String DATE_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * ȡ�Ե�ǰ���ں�ĵ�n�������
	 * 
	 * @param day
	 *            int ֮��n��
	 * @return String
	 */
	public static String getDateAfter(int n) {
		String time = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			Calendar cal = Calendar.getInstance(TimeZone.getDefault());
			cal.add(Calendar.DAY_OF_MONTH, n);
			time = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return time;
	}

	/**
	 * �õ�����ǰ������
	 * 
	 * @return String
	 */
	public static String getHalfYearBeforeStr() {
		GregorianCalendar cal = new GregorianCalendar();
		/** @todo ȡ��ǰ���� */
		String month = "";
		int tMonth = cal.get(GregorianCalendar.MONTH) + 1;
		if (tMonth < 10) {
			month = "0" + tMonth;
		} else {
			month = "" + tMonth;
		}
		int tDay = cal.get(GregorianCalendar.DATE);
		String day = "";
		if (tDay < 10) {
			day = "0" + tDay;
		} else {
			day = "" + tDay;
		}
		// String endDate = "" + cal.get(GregorianCalendar.YEAR) + month + day;
		/** @todo ȡ����ǰ���� */
		cal.add(GregorianCalendar.MONTH, -6);
		tMonth = cal.get(GregorianCalendar.MONTH) + 1;
		if (tMonth < 10) {
			month = "0" + tMonth;
		} else {
			month = "" + tMonth;
		}
		tDay = cal.get(GregorianCalendar.DATE);
		day = "";
		if (tDay < 10) {
			day = "0" + tDay;
		} else {
			day = "" + tDay;
		}
		String beginDate = "" + cal.get(GregorianCalendar.YEAR) + month + day;
		return beginDate;
	}

	/**
	 * ���رȵ�ǰ���������ӵ�һ��yyyy-MM-dd HH:mm:ss�����ڴ���ķ����������������minute����
	 * 
	 * @param minute
	 * @return �����ӳ�N���Ӻ��ʱ�䴮
	 */
	public static String getCurrentNextMinute(int minute) {
		String chargeStartTime = "";
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new java.util.Date());
			cal.add(Calendar.MINUTE, minute);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			chargeStartTime = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chargeStartTime;
	}

	/**
	 * �õ���ǰ����
	 * 
	 * @return int
	 */
	public static int getCurMin() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");
		int currentTime = Integer.parseInt(simpleDateFormat.format(date));
		return currentTime;
	}

	/**
	 *
	 * @param formatStr
	 * @return
	 */
	private static DateFormat getDateFormat(String formatStr) {
		if (formatStr.equalsIgnoreCase(DATE_FORMAT)) {
			return dateFormat;
		} else if (formatStr.equalsIgnoreCase(TIMEF_FORMAT)) {
			return dateTimeFormat;
		} else if (formatStr.equalsIgnoreCase(ZHCN_DATE_FORMAT)) {
			return zhcnDateFormat;
		} else if (formatStr.equalsIgnoreCase(ZHCN_TIME_FORMAT)) {
			return zhcnDateTimeFormat;
		} else {
			return new SimpleDateFormat(formatStr);
		}
	}

	// public static Date getDate(String dateTimeStr)
	// {
	// return getDate(dateTimeStr,DATATIMEF_STR);
	// }
	/**
	 * ����Ĭ��formatStr�ĸ�ʽ��ת��dateTimeStrΪDate���� dateTimeStr������formatStr����ʽ
	 * 
	 * @param dateTimeStr
	 * @param formatStr
	 * @return
	 */
	public static Date getDate(String dateTimeStr, String formatStr) {
		try {
			if (dateTimeStr == null || dateTimeStr.equals("")) {
				return null;
			}
			DateFormat sdf = getDateFormat(formatStr);
			Date d = sdf.parse(dateTimeStr);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
			// throw new LangException(e);
		}
		return null;
	}

	/**
	 * ��Dateת�����ַ�����yyyy-mm-dd hh:mm:ss�����ַ���
	 * 
	 * @param date
	 *            ����
	 * @return String �ַ��� TODO
	 */
	public static String dateToDateString(Date date) {
		return dateToDateString(date, TIMEF_FORMAT);
	}

	/**
	 * ��Dateת����formatStr��ʽ���ַ���
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String dateToDateString(Date date, String formatStr) {
		DateFormat df = getDateFormat(formatStr);
		return df.format(date);
	}

	/**
	 * ����һ��yyyy-MM-dd HH:mm:ss ��ʽ������ʱ���ַ����е�HH:mm:ss
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String getTimeString(String dateTime) {
		return getTimeString(dateTime, TIMEF_FORMAT);
	}

	/**
	 * ����һ��formatStr��ʽ������ʱ���ַ����е�HH:mm:ss
	 * 
	 * @param dateTime
	 * @param formatStr
	 * @return
	 */
	public static String getTimeString(String dateTime, String formatStr) {
		Date d = getDate(dateTime, formatStr);
		String s = dateToDateString(d);
		return s.substring(TIMEF_FORMAT.indexOf('H'));
	}

	/**
	 * ��ȡ��ǰ����yyyy-MM-dd����ʽ
	 * 
	 * @return
	 */
	public static String getCurDate() {
		return dateToDateString(new Date(), DATE_FORMAT);
	}

	/**
	 * ��ȡ��ǰ����yyyy��MM��dd�յ���ʽ
	 * 
	 * @return
	 */
	public static String getCurZhCNDate() {
		return dateToDateString(new Date(), ZHCN_DATE_FORMAT);
	}

	/**
	 * ��ȡ��ǰ����ʱ��yyyy-MM-dd HH:mm:ss����ʽ
	 * 
	 * @return
	 */
	public static String getCurDateTime() {
		return dateToDateString(new Date(), TIMEF_FORMAT);
	}

	/**
	 * ��ȡ��ǰ����ʱ��yyyy��MM��dd��HHʱmm��ss�����ʽ
	 * 
	 * @return
	 */
	public static String getCurZhCNDateTime() {
		return dateToDateString(new Date(), ZHCN_TIME_FORMAT);
	}

	/**
	 * ��ȡ����d��days����һ��Date
	 * 
	 * @param d
	 * @param days
	 * @return Date
	 */
	public static Date getInternalDateByDay(Date d, int days) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.DATE, days);
		return now.getTime();
	}

	/**
	 * ��ȡ����d��months�º��һ��Date
	 * 
	 * @param d
	 * @param months
	 * @return Date
	 */
	public static Date getInternalDateByMon(Date d, int months) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.MONTH, months);
		return now.getTime();
	}

	/**
	 * ��ȡ����d��years����һ��Date
	 * 
	 * @param d
	 * @param years
	 * @return Date
	 */
	public static Date getInternalDateByYear(Date d, int years) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.YEAR, years);
		return now.getTime();
	}

	/**
	 * ��ȡ����d��sec����һ��Date
	 * 
	 * @param d
	 * @param sec
	 * @return Date
	 */
	public static Date getInternalDateBySec(Date d, int sec) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.SECOND, sec);
		return now.getTime();
	}

	/**
	 * ��ȡ����d��min�ֺ��һ��Date
	 * 
	 * @param d
	 * @param min
	 * @return Date
	 */
	public static Date getInternalDateByMin(Date d, int min) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.MINUTE, min);
		return now.getTime();
	}

	/**
	 * ��ȡ����d��hoursСʱ���һ��Date
	 * 
	 * @param d
	 * @param hours
	 * @return Date
	 */
	public static Date getInternalDateByHour(Date d, int hours) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		now.add(Calendar.HOUR_OF_DAY, hours);
		return now.getTime();
	}

	/**
	 * ����һ�������ַ������������ڸ�ʽ��Ŀǰ֧��4�� ��������ǣ��򷵻�null
	 * 
	 * @param DateString
	 * @return �������ڸ�ʽ��Ŀǰ֧��4��
	 */
	public static String getFormateStr(String dateString) {
		String patternStr1 = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}"; // "yyyy-MM-dd"
		String patternStr2 = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}\\s[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"; // "yyyy-MM-dd
																									// HH:mm:ss";
		String patternStr3 = "[0-9]{4}��[0-9]{1,2}��[0-9]{1,2}��"; // "yyyy��MM��dd��"
		String patternStr4 = "[0-9]{4}��[0-9]{1,2}��[0-9]{1,2}��[0-9]{1,2}ʱ[0-9]{1,2}��[0-9]{1,2}��"; // "yyyy��MM��dd��HHʱmm��ss��"
		Pattern p = Pattern.compile(patternStr1);
		Matcher m = p.matcher(dateString);
		boolean b = m.matches();
		if (b) {
			return DATE_FORMAT;
		}
		p = Pattern.compile(patternStr2);
		m = p.matcher(dateString);
		b = m.matches();
		if (b) {
			return TIMEF_FORMAT;
		}
		p = Pattern.compile(patternStr3);
		m = p.matcher(dateString);
		b = m.matches();
		if (b) {
			return ZHCN_DATE_FORMAT;
		}
		p = Pattern.compile(patternStr4);
		m = p.matcher(dateString);
		b = m.matches();
		if (b) {
			return ZHCN_TIME_FORMAT;
		}
		return null;
	}

	/**
	 * ��һ��"yyyy-MM-dd HH:mm:ss"�ַ�����ת����"yyyy��MM��dd��HHʱmm��ss��"���ַ���
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getZhCNDateTime(String dateStr) {
		Date d = getDate(dateStr);
		return dateToDateString(d, ZHCN_TIME_FORMAT);
	}

	/**
	 * ��һ��"yyyy-MM-dd"�ַ�����ת����"yyyy��MM��dd��"���ַ���
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getZhCNDate(String dateStr) {
		Date d = getDate(dateStr, DATE_FORMAT);
		return dateToDateString(d, ZHCN_DATE_FORMAT);
	}

	/**
	 * ��dateStr��fmtFromת����fmtTo�ĸ�ʽ
	 * 
	 * @param dateStr
	 * @param fmtFrom
	 * @param fmtTo
	 * @return
	 */
	public static String getDateStr(String dateStr, String fmtFrom, String fmtTo) {
		Date d = getDate(dateStr, fmtFrom);
		return dateToDateString(d, fmtTo);
	}

	/**
	 * ��Сʱ������ɷ����Ժ���Ϊ��λ��ʱ��
	 * 
	 * @param hours
	 * @return
	 */
	public static long getMicroSec(BigDecimal hours) {
		BigDecimal bd;
		bd = hours.multiply(new BigDecimal(3600 * 1000));
		return bd.longValue();
	}

	/**
	 * ��ȡDate�еķ���
	 * 
	 * @param d
	 * @return
	 */
	public static int getMin(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.MINUTE);
	}

	/**
	 * ��ȡxxxx-xx-xx����
	 * 
	 * @param d
	 * @return
	 */
	public static int getDay(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ��ȡ�·ݣ�1-12��
	 * 
	 * @param d
	 * @return
	 */
	public static int getMonth(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.MONTH) + 1;
	}

	/**
	 * ��ȡ19xx,20xx��ʽ����
	 * 
	 * @param d
	 * @return
	 */
	public static int getYear(Date d) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		now.setTime(d);
		return now.get(Calendar.YEAR);
	}

	/**
	 * �õ�d���ϸ��µ����+�·�,��200505
	 * 
	 * @return
	 */
	public static String getYearMonthOfLastMon(Date d) {
		Date newdate = getInternalDateByMon(d, -1);
		String year = String.valueOf(getYear(newdate));
		String month = String.valueOf(getMonth(newdate));
		return year + month;
	}

	/**
	 * �õ���ǰ���ڵ��������200509
	 * 
	 * @return String
	 */
	public static String getCurYearMonth() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		String pattern = "yyyyMM";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getNextMonth(String year, String month) {
		String datestr = year + "-" + month + "-01";
		Date date = getDate(datestr, DATE_FORMAT);
		return getInternalDateByMon(date, 1);
	}

	/**
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastMonth(String year, String month) {
		String datestr = year + "-" + month + "-01";
		Date date = getDate(datestr, DATE_FORMAT);
		return getInternalDateByMon(date, -1);
	}

	/**
	 * �õ�����d������ҳ�����ڿؼ���ʽ����"2001-3-16"
	 * 
	 * @param d
	 * @return
	 */
	public static String getSingleNumDate(Date d) {
		return dateToDateString(d, DATE_FORMAT);
	}

	/**
	 * �õ�d����ǰ������,"yyyy-MM-dd"
	 * 
	 * @param d
	 * @return
	 */
	public static String getHalfYearBeforeStr(Date d) {
		return dateToDateString(getInternalDateByMon(d, -6), DATE_FORMAT);
	}

	/**
	 * �õ���ǰ����D���µ׵�ǰ/���������ʱ��,<0��ʾ֮ǰ��>0��ʾ֮��
	 * 
	 * @param d
	 * @param days
	 * @return
	 */
	public static String getInternalDateByLastDay(Date d, int days) {
		return dateToDateString(getInternalDateByDay(d, days), DATE_FORMAT);
	}

	public static java.sql.Date getSqlDate(String dateTimeStr) {
		// DateUtils.getTIME_STR_FORMAT
		java.sql.Date d = new java.sql.Date(DateUtils.getDate(dateTimeStr, DateUtils.TIME_STR_FORMAT).getTime());
		// d.setHours(Integer.parseInt(dateTimeStr.substring(8,10)));
		// d.setMinutes(Integer.parseInt(dateTimeStr.substring(10,12)));
		// d.setSeconds(Integer.parseInt(dateTimeStr.substring(12,14)));
		return d;
	}

	/**
	 * �������ڵ�ʱ�� (00:00:00)
	 * 
	 * @param dateStr
	 *            ���ڸ�ʽ�ַ��� ��ʽ: yyyy-MM-dd
	 * @return ʱ���ʽ�ַ��� ��ʽ yyyy-MM-dd hh:mm:ss
	 * @throws Exception
	 */
	public static String getFullTime(String dateStr) throws Exception {
		if (dateStr.indexOf("-") == -1) {
			throw new Exception("���ڸ�ʽ�쳣.Ҫ��yyyy-MM-dd");
		}
		String str = dateStr + " 00:00:00";
		return str;
	}

	/**
	 * ����String����ʱ��õ�Timestamp
	 * 
	 * @param dateTime
	 *            String����ʱ�� ��ʽ:yyyy-MM-dd
	 * @return Timestamp
	 * @throws Exception
	 */
	public static Timestamp getTimestampByDate(String dateTime) throws Exception {
		Timestamp s = Timestamp.valueOf(getFullTime(dateTime));
		return s;
	}

	/**
	 * ����String����ʱ��õ�Timestamp
	 * 
	 * @param dateTime
	 *            String����ʱ�� ��ʽ:yyyy-MM-dd hh:mm:ss
	 * @return Timestamp
	 * @throws Exception
	 */
	public static Timestamp getTimestamp(String dateTime) throws Exception {
		Timestamp s = Timestamp.valueOf(dateTime);
		return s;
	}

	/**
	 * TimestampתString
	 * @param ts Timestamp��ʽ����
	 * @return yyyy-MM-dd HH:mm:ss ��ʽ��ʱ���ַ���
	 */
	public static String getStringDatetime(Timestamp ts) {
		DateFormat sdf = new SimpleDateFormat(TIMEF_FORMAT);
		String tsStr = sdf.format(ts);
		return tsStr;
	}
	
	/**
	 * TimestampתString,ָ����ʽ
	 * @param ts Timestamp��ʽ����
	 * @param pattern ʱ���ʽ
	 * @return yyyy-MM-dd HH:mm:ss ��ʽ��ʱ���ַ���
	 */
	public static String getStringDatetime(Timestamp ts,String pattern) {
		DateFormat sdf = new SimpleDateFormat(pattern);
		String tsStr = sdf.format(ts);
		return tsStr;
	}
	
	/**
	 * ���ĳ���ĳ��������
	 * format ʱ���ʽ
	 * @param source xx��xx��
	 * @return
	 */
	 public static Integer getManyDaysAMonth(String source){
		  SimpleDateFormat format = new SimpleDateFormat("yyyy:MM");
		  try {
		      Date date = format.parse(source);
		      Calendar calendar = new GregorianCalendar();
		      calendar.setTime(date);
		      calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		      return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		    } catch (ParseException e) {
		      e.printStackTrace();
		    }
		  return 0;
	  }
}
