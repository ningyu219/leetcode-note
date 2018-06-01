package leetcodeExec;

class ListNode {  
    int val;  
    ListNode next;  
  
    ListNode(int x) {  
        this.val = x;  
    }  
}  
public class Solution_Link {
	//21. 合并两个有序链表 - 递归（注意为null的情况）
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode result;
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        if(l1.val > l2.val){
            result = l2;
            l2 = l2.next;
        }else{
            result = l1;
            l1 = l1.next;
        }
        result.next = mergeTwoLists1(l1,l2);
        return result;
    }
	//21. 合并两个有序链表 - 非递归（先确定head，再进行比较）
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 ==null)	return l2;
		if (l2 == null) return l1;
		
        ListNode now1 = l1;
        ListNode now2 = l2;
        ListNode head = null;        
        if (now1.val >= now2.val) {
        	head = now2;
			now2 = now2.next;
		}else {
			head = now1;
			now1 = now1.next;
		}      
        ListNode now3 = head;
        while (now1 != null || now2 != null) {
        	if (now1 == null) {
        		now3.next = now2;
        		now3 = now3.next;
    			now2 = now2.next;
    			continue;
			}
        	if (now2 == null) {
        		now3.next = now1;
				now3 = now3.next;
				now1 = now1.next;
				continue;
			}
        	if (now1.val >= now2.val) {
        		now3.next = now2;
        		now3 = now3.next;
    			now2 = now2.next;
			}else {
				now3.next = now1;
				now3 = now3.next;
				now1 = now1.next;
			}
		}
        return head;
    }
}
