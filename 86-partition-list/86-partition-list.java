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
    public ListNode partition(ListNode head, int x) {
    
        //check for null input 
        if(head == null || head.next == null)return head;
        
        ListNode tmp = head;
        ListNode before_head = new ListNode(-1);
        ListNode after_head = new ListNode(-1);
        ListNode before = before_head;
        ListNode after = after_head;
        
        while(tmp != null){
            if(tmp.val < x){
                before.next = tmp;
                before = before.next;
            }else {
                after.next = tmp;
                after = after.next;
            }
            tmp = tmp.next;
        }
        after.next = null;
        before.next = after_head.next;
        return before_head.next;
    }
}
//Time complexity: O(n)
//space complexity: O(1)