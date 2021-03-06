package com.xioaniu.algorithm.demo.leetcode;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * @author zhaohe
 *
 */
public class T009 {
	
//	判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//	示例 1:
//	输入: 121
//	输出: true
	
//	示例 2:
//	输入: -121
//	输出: false
//	解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
	
//	示例 3:
//	输入: 10
//	输出: false
//	解释: 从右向左读, 为 01 。因此它不是一个回文数。
	
	public static boolean isPalindrome(int x) {
		
		 boolean result = false;
		 
        if(x < 0) {
        	return false;
        }
        
        String strNum = String.valueOf(x);
        String reverseNum = "";
        for(int i = strNum.length() - 1; i >= 0 ; i--) {
        	reverseNum = reverseNum + strNum.charAt(i);
        }
        try {
        	int a = Integer.parseInt(reverseNum);
            if(a == x) {
            	result = true;
            }
        }catch(Exception e) {
        	e.printStackTrace();
        	result = false;
        }
        
        return result;
    }
	
	/**
	 * 官方题解
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome2(int x) {
		// 特殊情况：
	    // 如上所述，当 x < 0 时，x 不是回文数。
	    // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
	    // 则其第一位数字也应该是 0
	    // 只有 0 满足这一属性
	    if(x < 0 || (x % 10 == 0 && x != 0)) {
	        return false;
	    }

	    int revertedNumber = 0;
	    while(x > revertedNumber) {
	        revertedNumber = revertedNumber * 10 + x % 10;
	        x /= 10;
	    }

	    // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
	    // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
	    // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
	    return x == revertedNumber || x == revertedNumber/10;
	}
	

	public static void main(String[] args) {
		System.out.println("1 " + isPalindrome(1));
		System.out.println("-1 " + isPalindrome(-1));
		System.out.println("100 " + isPalindrome(100));
		System.out.println("101 " + isPalindrome(101));
		System.out.println("102 " + isPalindrome(102));
		System.out.println("1111 " + isPalindrome(1111));
		System.out.println("11 " + isPalindrome(11));
		System.out.println("111 " + isPalindrome(111));
		System.out.println("123 " + isPalindrome(123));
		System.out.println("45666 " + isPalindrome(45666));
		System.out.println("2147483647 " + isPalindrome(2147483647));
	}

}
