package com.xioaniu.algorithm.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣第12题
 * @author zhaohe
 * https://leetcode-cn.com/problems/integer-to-roman/
 * 
 */
public class T012 {
	
//	罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
//
//	字符          数值
//	I             1
//	V             5
//	X             10
//	L             50
//	C             100
//	D             500
//	M             1000
//	例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//
//	通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//	I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//	X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
//	C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//	给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
//
//	示例 1:
//	输入: 3
//	输出: "III"
	
//	示例 2:
//	输入: 4
//	输出: "IV"
	
//	示例 3:
//	输入: 9
//	输出: "IX"
	
//	示例 4:
//	输入: 58
//	输出: "LVIII"
//	解释: L = 50, V = 5, III = 3.
	
//	示例 5:
//	输入: 1994
//	输出: "MCMXCIV"
//	解释: M = 1000, CM = 900, XC = 90, IV = 4.
	
	public static String intToRoman(int num) {
		//把数字跟罗马字母做个映射
		java.util.Map<Integer, String> romans = new java.util.HashMap<Integer, String>();
        romans.put(1, "I");
        romans.put(4, "IV");
        romans.put(5, "V");
        romans.put(9, "IX");
        romans.put(10, "X");
        romans.put(40, "XL");
        romans.put(50, "L");
        romans.put(90, "XC");
        romans.put(100, "C");
        romans.put(400, "CD");
        romans.put(500, "D");
        romans.put(900, "CM");
        romans.put(1000, "M");
        
        //找出所有的被除数
        int[] bases = {1000,900, 500,400, 100,90, 50,40, 10,9,5,4,1};
        //保存罗马字符
        StringBuilder sb = new StringBuilder();
        //每次循环之后的余数
        int remain = num;
        //被除数的索引，方便查找下一个被除数
        int baseIndex = 0;
        
		while(remain > 0) {
			//如果余数正好在映射中，直接取值
			if(romans.containsKey(remain)) {
        		sb.append(romans.get(remain));
        	    break;
        	}
			//剩余的数除以除数得出的商
			int result = 0;
			//取出被除数
			int base = bases[baseIndex];
			//剩余的数值大于被除数才可以进行计算
        	if(remain >= base) {
        		result = remain/base;
        		remain = remain%base;
        	}else {
        		++baseIndex;
        		continue;
        	}
        	
        	//判断商乘以所在位置的除数查看是否在隐射中
        	if(romans.containsKey(result*base)) {
        		sb.append(romans.get(result*base));
        		continue;
        	}
        	//循环取出隐射
        	String roman = romans.get(base);
        	for(int i = 0; i < result; i++) {
        		sb.append(roman);
        	}
        }
        
		return sb.toString();
    }


	public static void main(String[] args) {
		
		System.out.println(intToRoman(27));
		
	}

}
