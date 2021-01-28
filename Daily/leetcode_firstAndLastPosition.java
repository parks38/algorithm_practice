package daily;
/*
 *  binary search problem
 *  
 *  5 7 7 8 8 10  target = 8
 *  l   m     r
 *  
 *  5 7 7 8 8 10
 *        l m r 
 */

public class leetcode_firstAndLastPosition {
		public static void main(String args[]) {
			int[] nums = {5,7,7,8,8,10};
			searchRange(nums, 8);
		}
	    public static int[] searchRange(int[] nums, int target) {
	        int left = binarySearch(nums, target, true);
	        int right = binarySearch(nums, target, false);
	        int[] answer = {0,0}; 
	        if(right - left == 0) {
	            answer[0] = -1;
	            answer[1] = -1;
	            return answer;
	        }
	        
	        
	        answer[0] = left;
	        answer[1] = right-1;
	        
	        return answer;
	    }
	    
	    public static int binarySearch(int[] nums, int target, boolean left_check) {
	        int left = 0;
	        int right = nums.length;
	        
	        while(left < right) {
	            int mid = (left + right)/2;
	            if(nums[mid] > target) {
	                right = mid;
	            } else if (left_check && target == nums[mid] ) {
	                 right = mid;
	            } else {
	                left = mid +1;
	            }
	        }
	        return left;
	    }
	
}
