package leetcodeExec;

import java.util.List;

public class Solution_DP {
	public boolean wordBreak(String s, List<String> wordDict) {
        //动态规划，result[i] = result[j]&&s.subString(j,i+1)
        int len = s.length();
        if(s==null ||len==0 || wordDict==null)
            return true;
        boolean[] res = new boolean[len+1];
        res[0] = true;
        
        for(int i=1; i<=len; i++){
            
            for(int j=0; j<i; j++){ 
                String tmp = s.substring(j,i);// 每次匹配为false后，删除tmp的第一个元素
                if(res[j] && wordDict.contains(tmp)) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }
}
