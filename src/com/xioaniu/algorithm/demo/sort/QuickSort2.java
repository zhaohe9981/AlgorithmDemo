package com.xioaniu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 快速排序 :快速排序时间复杂度最坏为：O(n2)，最好O(nlogn) 。
 * @author zhaohe
 * 
 * https://blog.csdn.net/sdoog_owt/article/details/80058870
 */
public class QuickSort2 {
	
	private final static String TAG = QuickSort2.class.getSimpleName();
		
	
	private static void sort(int arr[], int left, int right) {
		
		if(arr == null || left > right) {
			return;
		}
		
		//i,j相当于哨兵 ，base是基准值，temp是临时变量
		int i = left, j= right;
		int base = arr[left];
		int temp;
		
		//只要哨兵i,j不相遇就一直循环
		while(i < j) {
			
			//首先哨兵j向前走找到比base小的值，找到后停下
			while(arr[j] >= base && i < j) {
				j--;
			}
			
			//然后哨兵i往前走找到比base大的值，找到后停下
			while(arr[i] <= base && i < j) {
				i++;
			}
			
			//交换哨兵 i,j的值
			if (i<j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		
		}
		
		//此时哨兵相遇
		//哨兵i对应的值对应的值小于base（aar[left]）,交换i和left,此时base(aar[left])交换到了数组中间
		temp = arr[left];
		arr[left] = arr[i];
		arr[i] = temp;
		
		//分别对base两边的数组排序
		sort(arr,left,j-1);
		sort(arr,j+1,right);
	}
	
	
	public static void main(String[] args) {
		int[] source = {3,7,1,5,4,6,0};
//		int[] source = {1,2,3,4,5,6,7};
//		int[] source = {7,6,5,4,3,2,1};
//		int[] source = {6,6,6,6,6,6,6};
//		int[] source = {0,0,1,1,2,2,3};
//		int[] source = {3,3,2,2,1,1,0};
//		int[] source = {6,6,4,2,5,5,7,7};
		System.out.println("排序前：" + Arrays.toString(source));
		
		sort(source,0,source.length - 1);
		System.out.println(TAG + "排序后：" + Arrays.toString(source));
	}
	
}
