package com.xioaniu.algorithm.demo.leetcode;

/**
 * https://leetcode-cn.com/problems/container-with-most-water
 * @author zhaohe
 *
 */
public class T011 {

//	给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
//  找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//	说明：你不能倾斜容器，且 n 的值至少为 2。
	
	public static int maxArea(int[] height) {
        int max = 0;
        
        int count = height.length;
        for(int i = 1; i < count;i++) {
        	for(int j = i+1; j <= count; j++) {
        		max = Math.max(max, (j - i)*Math.min(height[i-1], height[j-1]));
        	}
        }
        
        return max;
    }
	
	
	/**
	 * 官方题解
	 * 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 
	 * 此外，我们会使用变量 maxarea 来持续存储到目前为止所获得的最大面积。
	 * 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxarea，并将指向较短线段的指针向较长线段那端移动一步。
	 * @param height
	 * @return
	 */
	private static int maxArea1(int[] height) {
		
		int maxArea = 0, l = 0,r = height.length - 1;
		while(l < r) {
			maxArea = Math.max(maxArea, Math.min(height[l], height[r])*(r-l));
			if(height[l] < height[r]) {
				l++;
			}else {
				r--;
			}
		}
		return maxArea;
	}
	
	

	public static void main(String[] args) {
		int[] arr = {1,8,6,2,5,4,8,3,7};
		 System.out.println(maxArea(arr) + "");
		 System.out.println(maxArea1(arr) + "");
	}

}
