package leetcodeExec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
	
	public int lengthOfLongestSubstring(String s) { 
        if(s==null || s.length()==0)
            return 0;
        Map<Character,Integer> m = new HashMap<Character, Integer>();
        
        int start = 1;
        int ret = 0;      
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i-1);  
            int index=0;
            if(m.containsKey(c)){
            	index = m.get(c);
            }

            if(index >= start){
                start = index + 1;
                m.put(c, i);
            }else{
                m.put(c, i);
                ret = Math.max(ret, i-start+1);
            }
        }
        return ret;
    }

    
    public static void main(String[] args) throws IOException {
    	String s = "abcabcbb";
    	int ret = new Solution().lengthOfLongestSubstring(s);
            System.out.print(ret);

    }

}
