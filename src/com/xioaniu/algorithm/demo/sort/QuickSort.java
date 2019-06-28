package com.xioaniu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 快速排序 :快速排序时间复杂度最坏为：O(n2)，最好O(nlogn) 。
 * @author zhaohe
 * 
 * https://blog.csdn.net/sdoog_owt/article/details/80058870
 */
public class QuickSort {
	
	private final static String TAG = QuickSort.class.getSimpleName();
	

	private static void sort(int[] arr,int left,int right) {
		
		int i,j,temp,t;
        if(left>right){
            return;
        }
        i=left;
        j=right;
        //temp就是基准位
        temp = arr[left];
 
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
         arr[left] = arr[i];
         arr[i] = temp;
         
         System.out.println("排序中：" + Arrays.toString(arr));
         
        //递归调用左半数组
         sort(arr, left, j-1);
        //递归调用右半数组
         sort(arr, j+1, right);
	}
	
	public static void main(String[] args) {
		int[] source = {3,7,1,5,4,6,0};
		System.out.println("排序前：" + Arrays.toString(source));
		
		sort2(source,0,source.length - 1);
		System.out.println(TAG + "排序后：" + Arrays.toString(source));
	}
	
	
	
	public static void sort2(int[] arr, int left, int right) {
		
		 if(left>right){
	            return;
	        }
		
		int l = left, r = right, flag, temp;
		flag = arr[left];
		
		while(l < r) {
			//右边的小兵先走
			while(arr[r] >= flag && l < r) {
				r--;
			}
			
			while(arr[l] <= flag && l < r) {
				l++;
			}
			
			if(l < r) {
				temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
		}
		
		arr[left] = arr[l];
		arr[l] = flag;
		
		sort2(arr, left, r -1);
		sort2(arr, r+1, right);
	
	}
	
}
