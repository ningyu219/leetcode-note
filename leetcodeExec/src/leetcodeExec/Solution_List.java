package leetcodeExec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//Definition for an interval.
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	}

public class Solution_List {
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> list = new ArrayList<Interval>();
    	//����ʵ����Comparator�ӿ�
    	Collections.sort(intervals,new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;//��ʼֵ��������
			}
		});

    	if(intervals.size() == 0)
    		return list;
    	
    	Interval i1 = intervals.get(0);
    	//����
    	for(int i = 0; i < intervals.size(); i++){
    		Interval i2;
    		//�����i2��ֵ
    		if(i == intervals.size() - 1)//���i���������һ��������������
    			i2 = new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE);
    		else//����i2���i1�����ֵ
    			i2 = intervals.get(i+1);
    		//�ϲ�����	
    		if(i2.start >= i1.start && i2.start <= i1.end){
    			i1.end = Math.max(i1.end, i2.end);
    		}else{//û�н�����ֱ�����
    			list.add(i1);
    			i1 = i2;//i1����
    		}
    	}
		return list;
    }
    
    //�ֱ��start��end��������
    public List<Interval> merge2(List<Interval> intervals) {
        int n = intervals.size();  
        int[] starts = new int[n];  
        int[] ends = new int[n];  
        for (int i = 0; i < n; i++) {  
            starts[i] = intervals.get(i).start;  
            ends[i] = intervals.get(i).end;  
        }  
        Arrays.sort(starts);  
        Arrays.sort(ends);  
        // loop through  
        List<Interval> res = new ArrayList<Interval>();  
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.  
            if (i == n - 1 || starts[i + 1] > ends[i]) {  
                res.add(new Interval(starts[j], ends[i]));  
                j = i + 1;  
            }  
        }  
        return res;  
        
    }
    public static void main(String[] args){
    	List<Interval> origin = new ArrayList<Interval>();
    	origin.add(new Interval(1,3));
    	origin.add(new Interval(2,6));
    	origin.add(new Interval(8,10));
    	origin.add(new Interval(15,18));
    	System.out.println(origin);
    	//= [[1,3],[2,6],[8,10],[15,18]];
    	
    }
}

