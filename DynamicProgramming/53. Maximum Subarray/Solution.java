
public class Solution {
	 public int maxSubArray(int[] nums) {
	        int len=nums.length;
	        if(len ==0) return 0;
	        
	        int max_sum=nums[0], max_sum_ending_here=nums[0];
	        for(int i=1; i<len; i++) {
	            max_sum_ending_here = Math.max(max_sum_ending_here + nums[i], nums[i]);
	            max_sum  = Math.max(max_sum_ending_here, max_sum);
	        }
	        return max_sum;
	        
	    }
}
