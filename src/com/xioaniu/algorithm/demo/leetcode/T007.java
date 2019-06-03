package com.xioaniu.algorithm.demo.leetcode;
/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * @author zhaohe
 * 整数翻转
 */
public class T007 {
	
//	给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
	
//	示例 1:
//	输入: 123
//	输出: 321
	
//	 示例 2:
//	输入: -123
//	输出: -321
	
//	示例 3:
//	输入: 120
//	输出: 21
	
//	注意:
//	假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2(31),  2(31) − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
	
	public static int reverse(int x) {
		
		String symbol = "";
		if(x < 0) {
			symbol = "-";
		}
		
		String s = String.valueOf(Math.abs(x));
		StringBuffer sb = new StringBuffer();
		for(int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		
		int result = 0;
		try {
			result = Integer.parseInt(symbol + sb.toString());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
    }
	
	public static void main(String[] args) {
		System.out.println(reverse(123) + "");
		System.out.println(reverse(-123) + "");
		System.out.println(reverse(120) + "");
		System.out.println(reverse(1999009999) + "");
	}

}
