package com.xioaniu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 冒泡排序 :冒泡排序总的平均时间复杂度为：O(n2) 。
 * @author zhaohe
 * 
 * https://www.cnblogs.com/shen-hua/p/5422676.html
 */
public class BubbleSort {
	
	private final static String TAG = BubbleSort.class.getSimpleName();
	
	/**
	 * 冒泡排序-从小到大的显示
	 * @param arr
	 * @return 
	 */
	private static int[] sort(int[] arr) {
		
		//比较a.length - 1趟
		for (int i = 0; i < arr.length - 1; i++) {
			
			for(int j = 0; j < arr.length -1 - i;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
		}
		return arr;
	}
	
//	/**
//	 * 冒泡排序-从大到小的显示
//	 * @param a
//	 * @return a
//	 */
//	private static int[] sort(int[] a) {
//		
//		//比较a.length - 1趟
//		for (int i = 0; i < a.length - 1; i++) {
//			
//			for(int j = 0; j < a.length -1 - i;j++) {
//				if(a[j] < a[j+1]) {
//					int temp = a[j];
//					a[j] = a[j+1];
//					a[j+1] = temp;
//				}
//			}
//			
//		}
//		return a;
//	}
	
	
	
	
	public static void main(String[] args) {
		int[] source = {3,7,1,5,4,6,0};
		System.out.println("排序前：" + Arrays.toString(source));
		
		int[] sorted = sort(source);
		System.out.println(TAG + "排序后：" + Arrays.toString(sorted));
	}
	
}
