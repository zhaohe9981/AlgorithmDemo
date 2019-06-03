package com.xioaniu.algorithm.demo.leetcode;

public class T005 {

//	给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//	示例 1：
//	输入: "babad"
//	输出: "bab"
//	注意: "aba" 也是一个有效答案。
//
//	示例 2：
//	输入: "cbbd"
//	输出: "bb"

	
//	1、先对字符串进行预处理，两个字符之间加上特殊符号#
//	2、然后遍历整个字符串，用一个数组来记录以该字符为中心的回文长度，为了方便计算右边界，我在数组中记录长度的一半（向下取整）
//	3、每一次遍历的时候，如果该字符在已知回文串最右边界的覆盖下，那么就计算其相对最右边界回文串中心对称的位置，得出已知回文串的长度
//	4、判断该长度和右边界，如果达到了右边界，那么需要进行中心扩展探索。当然，如果第3步该字符没有在最右边界的“羽翼”下，则直接进行中心扩展探索。进行中心扩展探索的时候，同时又更新右边界
//	5、最后得到最长回文之后，去掉其中的特殊符号即可
	public static String longestPalindrome(String s) {
		//预处理字符串
		StringBuilder sb = new StringBuilder();
		sb.append("#");
		for(int i = 0; i< s.length(); i++) {
			sb.append(s.charAt(i)).append("#");
		}
		s = sb.toString();
		
		
		int len = s.length();//处理后的字符串长度
		int rightSide = 0;//右边界
		int rightSideCenter = 0;//右边界对应的回文串中心
		int[] halfLenArr = new int[len];//每个字符为中心对应的回文长度的一半
		int center = 0;//回文中心
		int longestHalf = 0;//记录最长回文半径
		for(int i= 0; i <len; i++) {
			boolean needCal = true;//是否需要中心扩展
			if(rightSide > i) {//如果i在右边界之内
				int leftCenter = 2*rightSideCenter - i;//计算相对rightSideCenter的对称位置
				halfLenArr[i] = halfLenArr[leftCenter];
				if(i + halfLenArr[i] > rightSide) {//如果超过了右边界，进行调整
					halfLenArr[i] = rightSide - i;
					
				}
				if(i + halfLenArr[leftCenter] < rightSide) {
					needCal = false;
				}
				
			}
			
			//中心扩展
			if(needCal) {
				while(i - 1 -halfLenArr[i] >= 0 && i + 1+ halfLenArr[i] <= len) {
					if(s.charAt(i - 1 - halfLenArr[i]) == s.charAt(i + 1 + halfLenArr[i])) {
						halfLenArr[i] ++;
					}else {
						break;
					}
				}
			}
			
			rightSide = i + halfLenArr[i];
			rightSideCenter = i;
			if(halfLenArr[i] > longestHalf) {
				center = i;
				longestHalf = halfLenArr[i];
			}
		}
		
		StringBuilder result = new StringBuilder();
		for(int i = center - longestHalf + 1; i <= center + longestHalf; i+=2) {
			result.append(s.charAt(i));
		}
		
		return result.toString();
    }

	public static void main(String[] args) {
		String s1 = "babad";
		String s2 = "cbbd";
		System.out.println(longestPalindrome(s1));
		System.out.println(longestPalindrome(s2));
	}

}
