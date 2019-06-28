package com.xioaniu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 选择排序 :选择排序时间复杂度为：O(n2) 。
 * @author zhaohe
 * 选择排序的思想是：从未排序的数据中拿出最小数插入到排序之后的数据的最后一条
 * https://www.cnblogs.com/shen-hua/p/5424059.html
 */
public class SelctionSort {
	
	private final static String TAG = SelctionSort.class.getSimpleName();
	
	
	/**
	 * 每次在没排序的数据中找到最小值插入到已排序的最后
	 * @param arr
	 * @return
	 */
	private static int[] sort(int[] arr) {
		
		//比较arr.length - 1趟
		for (int i = 0; i < arr.length - 1; i++) {
			//记录最小的数字的索引
			int index = i;
			//从没排序的第一个数值比较到最后
			for(int j = i + 1; j < arr.length;j++) {
				if(arr[index] > arr[j]) {
					index = j;
				}
			}
			//找到最小值开始交换数据
			if(i != index) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
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
