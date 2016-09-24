package com.jianla.util;

import java.util.ArrayList;
import java.util.List;


public class ParseUtil {
	
	private static final String REGEX=",";

	public static List<Long> parse(String idsStr){
		if(idsStr==null) throw new IllegalArgumentException("source must not be null");
		List<Long> ids = new ArrayList<Long>();
		for(String idStr : idsStr.split(REGEX)){
			ids.add(Long.parseLong(idStr));
		}
		return ids;
	}
	
	public static String toString(List<?> ids){
		if(ids==null) throw new IllegalArgumentException("source must not be null");
		StringBuilder sb = new StringBuilder();
		for(Object id : ids){
			sb.append(id).append(REGEX);
		}
		sb.setLength(sb.length()-REGEX.length());
		return sb.toString();
	}
	
	public static String loginRedirect(String code,String redirectUrl){
		StringBuilder sb = new StringBuilder("redirect:/login.html?errorCode=");
		sb.append(code);
		if(redirectUrl!=null && !redirectUrl.equals("")){
			sb.append("&redirect_url=").append(redirectUrl);
		}
		return sb.toString();
	}
}
