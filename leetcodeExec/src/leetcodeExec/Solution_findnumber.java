package leetcodeExec;

public class Solution_findnumber {
	class Solution {
		
		// 41. 找到缺失的第一个正数。输入: [3,4,-1,1]，输出：2
	    public int firstMissingPositive(int[] nums) {
	        if(nums==null) {
	            throw new NullPointerException("invalid input...");
	        }else if(nums.length == 0)
	            return 1;
	        
	        int match = 0;
	        int maxMatch = nums.length;
	 
	        //1. 当nums[match]正好等于match+1，此数已经在正确的位置，match++
	        //2. 当nums[match]超过了数组长度maxMatch，或者小于等于已经找到的match数列，或者nums[match]和后一个数相等，那么当前的数是无效的，则将下一个数字挪到当前位置，maxMatch--
	        //3. 当nums[match]属于有效区间(match~maxMatch)，则将当前数字调整到应该去的地方，即数字3应该放到nums[2]中。所以交换应该去的位置的坐标和当前坐标的两个数。
	        while(match<maxMatch){
	            if(nums[match]==(match+1))
	                match++;
	            else if(nums[match]<=match || nums[match]>maxMatch || nums[nums[match]-1] == nums[match]){
	                maxMatch--;
	                nums[match] = nums[maxMatch];
	            }else{
	                int temp = nums[match];
	                nums[match] = nums[temp-1];
	                nums[temp-1] = temp;       
	            }
	        }
	        return match+1;	             
	    }
	    
	    //136. 只出现一次的数字
	    public int singleNumber(int[] nums) {
	        //异或：0和任一个数X异或=X，相同的数异或=0。且与运算顺序无关！！！
	        int ret = 0;
	        for(int i=0; i<nums.length; i++){
	            ret ^= nums[i];            
	        }
	        return ret;
	    }
	}
}
