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
    public int pairSum(ListNode head) {
        
       if(head == null)return 0;
        
        //find the middle of linkedlist
        ListNode middle = getMiddle(head);
        
        //reverse second part 
        ListNode rev = reverse(middle);
        int max =0;
        //get the max
        while(head != null && rev != null){
            int currSum = head.val + rev.val;
            max = Math.max(max, currSum);
            head = head.next; 
            rev = rev.next;
        }
        return max;
    }
    public ListNode getMiddle(ListNode head){
        if(head == null)return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}