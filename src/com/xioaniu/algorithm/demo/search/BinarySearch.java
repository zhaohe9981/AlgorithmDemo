package com.xioaniu.algorithm.demo.search;

/**
 * 二分查找：有序数组
 * @author zhaohe
 *
 */
public class BinarySearch {
	
	private static int search(int[] arr, int keyNum) {
		int index = -1;
		if(arr == null) {
			return index;
		}
		
		int min,max,middle;
		min = 0;
		max = arr.length - 1;
		
		while(min <= max) {
			middle = (min + max)/2;
			
			if(arr[middle] > keyNum) {
				max = middle-1;
			}else if(arr[middle] < keyNum) {
				min = middle + 1;
			}else {
				index = middle;
				break;
			}
		}
		
		return index;
	}
	
	
	public static void main(String[] args) {
		
		int[] source = {1,2,3,4,5,6,7,8};
		int index = search(source,5);
		System.out.println("index = " + index);
	}

}
