package com.xioaniu.algorithm.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * https://leetcode-cn.com/problems/two-sum/solution/
 * @author Administrator
 *
 */
public class T001 {

//	 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//	 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//	 示例:
//	 给定 nums = [2, 7, 11, 15], target = 9
//	 因为 nums[0] + nums[1] = 2 + 7 = 9
//	 所以返回 [0, 1]
	
	/**
	 * 暴力法  时间复杂度为O(N*N)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] solution(int[] nums, int target) {
		
        for (int i = 0; i < nums.length;i++){
            for(int j = i+1; j< nums.length;i++) {
            	if(nums[i] + nums[j] == target) {
            		return new int[] {i,j};
            	}
            }
        }
		return null;
	}
	
	/**
	 * 两遍哈希表(空间换时间) 时间复杂度O(N)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] solution1(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int result = target - nums[i];
			if(map.containsKey(result) && map.get(result) != i) {
				return new int[] {i,map.get(result)};
			}
		}
		return null;
	}
	
	
	/**
	 * 一遍哈希表时间复杂度O(N)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] solution2(int[] nums, int target) {
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			int result = target - nums[i];
			if(map.containsKey(result) && map.get(result) != i) {
				return new int[] {map.get(result),i};
			}
			map.put(nums[i], i);
		}
		
		return null;
	}
	
	
	
	public static void main(String[] args) {
		int []nums = {3,3};
		System.out.println(Arrays.toString(solution(nums,6)));
		
		System.out.println(Arrays.toString(solution1(nums,6)));
		
		System.out.println(Arrays.toString(solution2(nums,6)));
		
		
	}

}
