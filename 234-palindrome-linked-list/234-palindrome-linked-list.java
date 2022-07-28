/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        //check for null input 
        if(head == null)return true;
        
        //find the end of the first half
        ListNode firstHalfEnd = getFirstHalfEnd(head);
        //Reverse the second half
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        //Determine whether or not there is a palindrome
        ListNode node1 = head;
        ListNode node2 = secondHalfStart;
        boolean result = true;
        while(result && node2!= null){
            if(node1.val != node2.val)return false;
            node1=node1.next;
            node2=node2.next;
        }
        //Restore the list
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }
    public ListNode getFirstHalfEnd(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev= curr;
            curr= tmp;
        }
        return prev;
    }
}
/*Find the end of the first half.
  Reverse the second half.
  Determine whether or not there is a palindrome.
  Restore the list.
  Return the result.*/