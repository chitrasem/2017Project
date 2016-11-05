package com.chitra.school.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class DateUtils {
	public String getStrDate() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

}
