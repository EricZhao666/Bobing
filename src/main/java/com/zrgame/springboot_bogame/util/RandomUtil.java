package com.zrgame.springboot_bogame.util;

import java.util.Arrays;
import java.util.Random;

/**
 * The util can create a random str that include the designated char str
 * @author hlx
 * @version 1.0 2017-?-?
 */
public class RandomUtil {
	
	private static final String  VALIDCHAR = "123456";
	
	public static String[] buildRandomStr(int len){
		StringBuilder str = new StringBuilder();
		StringBuilder unSortStr=new StringBuilder();
		Random random = new Random();
		int arr[]=new int[6];
		String[] get=new String[2];
		for(int i=0;i<len;i++){
			int number=(int)VALIDCHAR.charAt(random.nextInt(VALIDCHAR.length()));
			arr[i]=number;
			//str.append(VALIDCHAR.charAt(random.nextInt(VALIDCHAR.length())));
		}
		for (int i = 0; i < 6; i++) {
			unSortStr.append((char) arr[i]);
		}
		Arrays.sort(arr);
		for (int i = 0; i < len; i++) {
			str.append((char) arr[i]);
		}
		get[0]=unSortStr.toString();
		get[1]=str.toString();
		return get;
	}

}
