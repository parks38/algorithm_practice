package daily;

import java.util.*;


/*
 * You are given two linked-lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

	Example:Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
	
	** 풀이방법 
	
			Linked List 
			ls1: 2 -> 4 ->  3
			ls2: 5 -> 6 ->  4
			----------------
answer	->		 7    0  (1)8
	     
	
 */

public class jan1721 {

	  static class ListNode {
	      int val;
	      ListNode next;
	      ListNode head = null;
	      ListNode tail = null;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	      public void addNode(int data) {    
	          //Create a new node    
	    	  ListNode newNode = new ListNode(data);    
	    	  
	              
	          //Checks if the list is empty    
	          if(head == null) {    
	              //If list is empty, both head and tail will point to new node    
	              head = newNode;    
	              tail = newNode;    
	          }    
	          else {    
	              //newNode will be added after tail such that tail's next will point to newNode    
	              tail.next = newNode;    
	              //newNode will become new tail of the list    
	              tail = newNode;    
	          }    
	      }
	      
	 }
	 
	
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode();
		ListNode l2 = new ListNode();
		// l1 = [2,4,3], l2 = [5,6,4]
		
		l1.addNode(2);
		l1.addNode(4);
		l1.addNode(3);
		
		l1.addNode(5);
		l1.addNode(6);
		l1.addNode(4);
		
		ListNode ans = addTwoNumbers(l1, l2);
		
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 정답을 넣을 listNode 
        ListNode answer = new ListNode(0);
        int carry = 0;
        ListNode curr = answer;
        ListNode list1 = l1;
        ListNode list2 = l2;
        
        
        while(list1 != null || list2 != null) {
        	// 현재 l1 의 value
            int x = list1.val;
            // 현재 l2 의 value
            int y = list2.val;
            // 두값의 합. 만약 십의 자리가 있다면 다음 숫자에 더해준다. 
            int sum = carry + x + y;
            carry = sum / 10;
            // 1의 자리만 넣어준다
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            // 다음 숫자로 넘어가기 
            if(list1 != null) list1 = list1.next;
            if(list2 != null) list2 = list2.next;
        }
	        if(carry > 0) curr.next = new ListNode(carry);
	        return answer.next;
	}

	

}
