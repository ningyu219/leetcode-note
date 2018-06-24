package leetcodeExec;

import java.io.IOException;

public class Solution_search {
	public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] ret = {-1,-1};
        int mid = 0;
        int low = 0, high = nums.length-1;
        
        if(nums==null) return ret;
        //if(nums.length==1)
        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid]>=target)
                high = mid-1;
            else
                low = mid+1;
        }
        
        if(nums[low]!=target || low>=len)
        	return ret;
        
        ret[0] = low;
        
        for(low=0,high=len-1;low<=high; ){
        	mid = (low+high)/2;
        	if(nums[mid]<=target)
        		low = mid+1;
        	else
        		high = mid-1;
        }
        ret[1] = high;
        
        return ret;
    }
	
	public static void main(String[] args) throws IOException {
    	int[] nums = {5,7,7,8,8,10};
    	int[] ret = new Solution_search().searchRange(nums, 8);
            System.out.print("low"+ret[0]+"high:"+ret[1]);
	}
}
