package Section8;
/*
 * 풀이 시간: 초과 
 * 시간 복잡도 : O(N)
 * 공간 복잡도 : O(1) 
 * 풀이 방법 : 
 *   Two Pointer 
 *   [ 0 1 0 2 1 0 1 3 2 1 2 1 ]
 *     l                     r
 *     l l l l l l l r r r r r
 *     
 *    * 진행하는 쪽이 최대 장벽을 차지하게 된다면 다 한쪽 진행 
 *    * 최대 지점에서 좌우 포인터가 만남.
 *    
 *    - (r_max > l_max) left 이동
 *    - (l_max > r_max) right 이동 
 *    
 */

public class leetcode_Trapping_Rain_Water_ps {
	public static void main(String[] args) {
	      int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
	      System.out.println(trap(height));
	      // output : 6
	   }
	    public static int trap(int[] height) {
	        int ans = 0;
	        int left = 0;
	        int left_max = 0;
	        int right_max = 0;
	        int right = height.length -1;                
	        while (left < right) {
	            if (height[left] > left_max) left_max = height[left]; 
	            if (height[right] > right_max) right_max = height[right];
	            if (left_max < right_max) {
	                ans += left_max-height[left]; 
	                left++; 
	            } else {
	                ans += right_max-height[right]; 
	                right--; 
	            }
	        }
	        return ans;
	        
	    }

}
