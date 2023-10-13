/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //check for null input 
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode tmp = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null)return null;
        while(tmp != slow){
            slow = slow.next;
            tmp = tmp.next;
        }
        return tmp;
    }
}
//Time complexity:O(n)
//space complexity:O(1)