package com.xioaniu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 插入排序 :插入排序的时间复杂度为：O(n2) 。
 * 插入排序的思想： 从没有排序的数据中拿出第一个与前面排好序的数据比较
 * @author zhaohe
 */
public class InsertSort {
	
	private final static String TAG = InsertSort.class.getSimpleName();
	
	private static int[] sort(int[] arr) {
		
		//比较a.length - 1趟
		for (int i = 0; i < arr.length - 1; i++) {
			
			//从没有排序的数据的第一个拿出数据往前插入
			for(int j = i + 1; j > 0;j--) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
			
		}
		return arr;
	}

		
	
	public static void main(String[] args) {
		int[] source = {3,7,1,5,4,6,0};
		System.out.println("排序前：" + Arrays.toString(source));
		
		int[] sorted = sort(source);
		System.out.println(TAG + "排序后：" + Arrays.toString(sorted));
	}
	
}
