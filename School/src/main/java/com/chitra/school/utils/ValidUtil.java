package com.chitra.school.utils;

/**
 *----------------------------------------------------------------------
 * PROJECT NAME : Java Library
 * FILE    NAME : ValidUtil.java
 * CREATED DATE : 2014. 7. 11.
 * PROGRAMMER   : PAUL LEE
 *----------------------------------------------------------------------
 * No Copyright, Just Copyleft.
 *----------------------------------------------------------------------
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열 형식을 검증하는 함수들을 모아놓은 클래스
 * ValidUtil
 * @author PAUL LEE
 */
public class ValidUtil
{
	/**
	 * 날짜 Regular Expression 패턴
	 * ^([12][0-9]{3}) : 맨 앞자리에 1 OR 2이고 0에서 9까지 3자리
	 * ([0][1-9]|[1][0-2]) : 0이면 1에서 9, 1이면 0에서 2
	 * ([0][1-9]|[12][0-9]|[3][0-1])$ : 0이면 1에서 9, 1이나 2이면 0에서 9, 3이면 0이나 1
	 */
	public static final String DATE_PATTERN     = "^([012][0-9]{3})([0][1-9]|[1][0-2])([0][1-9]|[12][0-9]|[3][0-1])$";
	/**
	 * 시간 Regular Expression 패턴
	 */
	public static final String TIME_PATTERN     = "^([01][0-9]|[2][0-3])([0-5][0-9])([0-5][0-9])$";
	/**
	 * 일시 Regular Expression 패턴
	 */
	public static final String DATETIME_PATTERN = "^([12][0-9]{3})([0][1-9]|[1][0-2])([0][1-9]|[12][0-9]|[3][0-1])([01][0-9]|[2][0-3])([0-5][0-9])([0-5][0-9])$";
	/**
	 * 통화 Regular Expression 패턴
	 */
	public static final String CURRENCY_PATTERN = "^(-?[0-9]+|-?[0-9]{1,3}(,[0-9]{3})*)(.[0-9]{1,3})?$";
	/**
	 * 숫자 Regular Expression 패턴
	 */
	public static final String NUMERIC_PATTERN  = "^([-+]?[0-9]+)(.[0-9]*)?$";
	/**
	 * 정수 Regular Expression 패턴
	 */
	public static final String NUMBER_PATTERN   = "^[0-9]+$";
	/**
	 * 이율 Regular Expression 패턴
	 */
	public static final String RATE_PATTERN     = "^([-+]?[0-9]+)(.[0-9]{1,5})$";
	/**
	 * 이메일 Regular Expression 패턴
	 */
	public static final String EMAIL_PATTERN    = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*$";
	/**
	 * IP주소 Regular Expression 패턴
	 */
	public static final String IP_PATTERN       = "([0-9]{1,3}).([0-9]{1,3}).([0-9]{1,3}).([0-9]{1,3})";
	/**
	 * 생성자, 외부에서 객체를 인스턴스화 할 수 없도록 설정
	 */
	private ValidUtil() {}

	/**
	 * 문자열이 날짜 포맷인지 체크한다.
	 * ^([12][0-9]{3}) : 맨 앞에 '0','1','2'이고, 0-9까지 3번 발생함.
	 * ([0][1-9]|[1][0-2]) : '0'||[1-9]이거나 '1'||[0-2]
	 * ([0][1-9]|[12][0-9]|[3][0-1])$ : 마지막에 '0'||1-9이거나, '1','2'||[0-9]이거나, '3'||[0-1]
	 * @param str 정수형이나 실수형 문자열
	 * @return boolean true : 문자열이 일자를 나타냄, false : 문자열이 일자를 나타내지 않음.
	 */
	public static boolean isDate( String str )
	{
		if( null == str || str.length() != 8 ) return false;

		return str.matches( DATE_PATTERN );
	}
	/**
	 * 문자열이 시간 포맷인지 체크한다.
	 * ^([01][0-9]|[2][0-3]) : 맨 앞에 '-', '+' 기호가 없거나 있고, 숫자가 1개이상 발생함.
	 * ([0-5][0-9]) : 0에서 5||0에서 9
	 * ([0-5][0-9])$ : 마지막에 0에서 5||0에서 9
	 * @param str 시간 포맷의 문자열
	 * @return boolean true : 문자열이 시간을 나타냄, false : 문자열이 시간을 나타내지 않음.
	 */
	public static boolean isTime( String str )
	{
		if( null == str || str.length() != 6 ) return false;

		return str.matches( TIME_PATTERN );
	}

	/**
	 * 문자열이 일시 포맷인지 체크한다.
	 * @param str
	 * @return boolean true : 문자열이 일시를 나타냄, false : 문자열이 일시를 나타내지 않음.
	 */
	public static boolean isDateTime( String str )
	{
		if( null == str || str.length() != 14 ) return false;

		return str.matches( DATETIME_PATTERN );
	}
	/**
	 * 문자열이 정수형이나 실수형인지 체크한다.
	 * ^([-+]?[0-9]+) : 맨 앞에 '-', '+' 기호가 없거나 있고, 숫자가 1개이상 발생함.
	 * (.[0-9]*)?$ : 마지막에 '.' + 숫자가 0개 이상인 패턴이 없거나 발생함.
	 * @param str 정수형이나 실수형 문자열
	 * @return boolean true : 문자열이 숫자형, false : 문자열이 숫자형이 아님.
	 */
	public static boolean isNumeric( String str )
	{
		return str.matches( NUMERIC_PATTERN );
	}
	/**
	 * 문자열이 정수형인지 체크한다.
	 * ^([0-9]+) : 숫자가 1개이상 발생함.
	 * @param str 정수형 문자열
	 * @return boolean true : 문자열이 정수형, false : 문자열이 정수형이 아님.
	 */
	public static boolean isNumber( String str )
	{
		return str.matches( NUMBER_PATTERN );
	}
	/**
	 * 문자열이 금액 표현 형식인지 체크한다.
	 * ^[0-9]+ : 맨 앞에 0에서 9라는 숫자가 하나 이상
	 * | : 이거나
	 * ^[0-9]{1,3}(,[0-9]{3})* : 맨 앞에 0에서 9라는 숫자가 1에서 3개까지 이고 ,와 숫자 3개로 이루어진 패턴이 0이상 발생
	 * (.[0-9]{1,3})?$ : 마지막에 '.' + 숫자가 1자리에서 3자리로 이루어진 패턴이 0이거나 1번 발생
	 * @param str 금액을 표현하는 문자열
	 * @return boolean true : 문자열이 금액을 표현함, false : 문자열이 금액을 표현하지 않음.
	 */
	public static boolean isCurrency( String str )
	{
		return str.matches( CURRENCY_PATTERN );
	}

	/**
	 * 문자열이 이율 형식인지 체크한다.
	 * ^[0-9]+ : 맨 앞에 숫자가 0에서 9가 1번이상 발생함.
	 * (.[0-9]{1,5})$ : 마지막에 '.' + 숫자가 1개에서 5개까지 패턴이 1번 발생해야함.
	 * @param str 이율을 표현하는 문자열
	 * @return boolean true : 문자열이 이율을 표현함, false : 문자열이 이율을 표현하지 않음.
	 */
	public static boolean isRate( String str )
	{
		return str.matches( RATE_PATTERN );
	}

	/**
	 * 문자열이 이메일 형식인지 체크한다.
	 * ^[_a-z0-9-]+(.[_a-z0-9-]+)* : 맨 앞에 숫자가 0에서 9가 1번이상 발생함.
	 * *@[a-z0-9-]+(.[a-z0-9-]+)*$ : 마지막에 '@' + 숫자가 1개에서 5개까지 패턴이 1번 발생해야함.
	 * @param str 이율을 표현하는 문자열
	 * @return boolean true : 문자열이 이율을 표현함, false : 문자열이 이율을 표현하지 않음.
	 */
	public static boolean isEmail( String str )
	{
		return str.matches( EMAIL_PATTERN );
	}

	/**
	 * 정규식을 포함하는지 검증한다.
	 * @param regExp 정규식 OR 문자열
	 * @param str 정규식을 포함하는지 검사할 문자열
	 * @return true regExp를 포함함, false 포함하지 않음.
	 */
	public static boolean containsStr( String regExp, String str )
	{
		Pattern ptn = Pattern.compile( regExp );
		Matcher mtc = ptn.matcher( str );
		return mtc.find();
	}

	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		System.out.println( isNumber("-12345.0000") );
		System.out.println( isNumber("12345.0000") );
		System.out.println( isNumber("12345") );
		System.out.println( isNumeric("-12345.0000") );
		System.out.println( isNumeric("12345.00") );
		System.out.println( isCurrency("12,345.00") );
		System.out.println( isCurrency("-12,345.00") );
		System.out.println( isRate("0.123456") );
		System.out.println( isRate("0.12345") );
		System.out.println( isRate("1.0") );
		System.out.println( isRate("-0.5") );
		System.out.println( isEmail("prayerpaul@gmail.com") );
		System.out.println( isDate("20141718") );
		System.out.println( isDate("8482016") );
		System.out.println( isDate("20140718") );
		System.out.println( isTime("245959") );
		System.out.println( isTime("235959") );
	}

}
