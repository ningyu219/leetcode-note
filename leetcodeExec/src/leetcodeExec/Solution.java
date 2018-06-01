package leetcodeExec;

public class Solution {
	
	// 53. ��������飨��̬�滮��
	public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE,tempSum=0;
        for(int i=0; i<nums.length; i++){
            tempSum = Math.max(nums[i], tempSum+nums[i]);
            if(maxSum<tempSum)
                maxSum = tempSum;
            else if(tempSum<0)
                tempSum = 0;
        }
        return maxSum;
    }
}
