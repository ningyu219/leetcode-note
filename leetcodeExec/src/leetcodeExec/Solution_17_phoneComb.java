package leetcodeExec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_17_phoneComb {
		//递归，将输入数字转成string数组，递归调用。
	    public static List<String> letterCombinations(String digits) {
	        if(digits==null) return null;
	        
	        List<String> result = new ArrayList<String>();
	        String str="";
	        getLetter(result, digits, str, 0);
	        return result;
	    }
	    
	    public static void getLetter(List<String> result, String digits, String str, int index){
	            if(index==digits.length()){
	                result.add(str);
	                return;
	            }
	            String[] a = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	            
	            String temp = a[digits.charAt(index)-'0'];
	            for(int i=0; i< temp.length(); i++){
	                str += temp.charAt(i);
	                getLetter(result, digits, str, index+1);
	                str = str.substring(0,str.length()-1);
	                
	            }
	            
	        }
	

	//public class MainClass {
/*	    public static String stringToString(String input) {
	        if (input == null) {
	            return "null";
	        }
	        return Json.value(input).toString();
	    }*/
	    
	    public static String stringListToString(List<String> stringList) {
	        StringBuilder sb = new StringBuilder("[");
	        for (String item : stringList) {
	            sb.append(item);
	            sb.append(",");
	        }
	    
	        sb.setCharAt(sb.length() - 1, ']');
	        return sb.toString();
	    }
	    
	    public static void main(String[] args) throws IOException {
	    	List<String> result = new ArrayList<String>();
	    	result=letterCombinations("");
	    	String out = stringListToString(result);
            
            System.out.print(out);
	    	/*BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String line;
	        while ((line = in.readLine()) != null) {
	            String digits = stringToString(line);
	            
	            List<String> ret = new Solution().letterCombinations(digits);
	            
	            String out = stringListToString(ret);
	            
	            System.out.print(out);
	        }*/
	    }
	
}
