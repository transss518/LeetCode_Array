package leetcode;

public class LinkedList {
	
//	  Definition for singly-linked list.
	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }

//	 * Definition for a binary tree node.
	 public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 ListNode tostore;
	 public TreeNode sortedListToBST(ListNode head) {
	        ListNode tmp = head;
	        int count = 0;
	        while(tmp != null) {
	        	tmp = tmp.next;
	            count++;
	        }
	        tostore = head;
	        return helper(0, count-1);
	 }
	 public TreeNode helper(int start, int end) {
	        //end situation;
	        if (start > end) {
	            return null;
	        }
	        int mid = (start + end) / 2;
	        
	        TreeNode left = helper(start, mid - 1);
	        TreeNode ret = new TreeNode(tostore.val);
	        tostore = tostore.next;	       
	        ret.left = left;
	        ret.right = helper(mid + 1, end);
	        return ret;
	    }

	 	public void reorderList(ListNode head) {
	        //find the latter part and reorder it;
	        //then modify the former one with the latter one;
	        ListNode fast = head;
	        ListNode slow = head;
	        while(fast.next != null && fast.next.next != null) {
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        ListNode slow_store = slow;
	        
	        //build new ListNode which reverse the latter part;
	        slow = slow.next;
	        ListNode latter = null;
	        
	        while (slow != null) {
	            ListNode tmp = slow.next;
	            slow.next = latter;
	            latter = slow;
	            slow = tmp;
	        }
	        
	        ListNode former = head;
	        while (former != slow_store) {
	        	ListNode tmp = former.next;
	        	ListNode tmp2 = latter.next;
	        	former.next = latter;
	        	latter.next = tmp;
	        	
	        	former = tmp;
	        	latter = tmp2;
	        }
	        former.next = latter;
	        
	        while (head != null) {
	        	System.out.println(head.val);
	        	head = head.next;
	        }
	     
	    }
	    public ListNode insertionSortList(ListNode head) {
	        //1 break the node from the list; combine the former ones and the latter ones;
	        //2 find the appropriate place for this node in the former part;
	        if (head == null) {
	            return head;
	        }
	        ListNode newHead = new ListNode(0);
	        newHead.next = head;
	        
	        ListNode todo = head;
	        while (todo.next != null) {
	            //break the node;
	            ListNode break_node = todo.next;
	            ListNode latter = todo.next.next;
	            todo.next = null;
	            System.out.println(todo.val);
	            //if the node is where it should be break (the last one)
	            if (todo.val <= break_node.val) {
	                todo.next = break_node;
	                break_node.next = latter;
	                //renew the todo;
	                todo = todo.next;
	            } else {
	            
	            //attach the node to the former part;
	            //aware of to renew the head;
	            ListNode pre = head;
	            ListNode nex = head.next;
	            //the first one;
	            if (break_node.val <= pre.val) {
	                break_node.next = pre;
	                todo.next = latter;
	                head = break_node;
	            } else {
	                while (nex != null) {
	                    if (break_node.val <= nex.val) {
	                        pre.next = break_node;
	                        break_node.next = nex;
	                        todo.next = latter;
	                        break;
	                    }
	                    pre = pre.next;
	                    nex = nex.next;
	                }
	            }
	            }
	            
	        }
	        while (head != null) {
	        	System.out.println(head.val);
	        	head = head.next;
	        }
	        return head;
	    }
	public static void main(String[] args) {
		LinkedList sol = new LinkedList();
		ListNode head = new ListNode(4);
		head.next = new ListNode(19);
		head.next.next = new ListNode(14); 
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(-3);
		sol.insertionSortList(head);
	}
}
