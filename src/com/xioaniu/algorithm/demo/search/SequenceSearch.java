package com.xioaniu.algorithm.demo.search;

/**
 * 顺序查找
 * @author zhaohe
 *
 */
public class SequenceSearch {

	
	private static int search(int[] arr, int keyNum) {
		int index = -1;
		if(arr == null) {
			return index;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == keyNum) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	
	public static void main(String[] args) {
		
		int[] source = {3,7,1,5,4,6,0};
		int index = search(source, 0);
		System.out.println("index = " + index);
	}
	
}
