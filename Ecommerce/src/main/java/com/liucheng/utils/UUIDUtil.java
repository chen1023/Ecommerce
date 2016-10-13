package com.liucheng.utils;

import java.util.UUID;

public class UUIDUtil {
	public static String returnStr(UUID u){
		String str=u.toString();
		String temp = str.substring(19, 23) + str.substring(24);
		return temp;
	}
}
