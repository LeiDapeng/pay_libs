package com.pay.basic.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String getTradeDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date()).replaceAll(" ","T");
	}

	public static void main(String[] args) {
		System.out.println(DateUtils.getTradeDate());
	}
}
