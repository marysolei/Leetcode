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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        //check for null input 
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        int currSum = 0;
        int carry = 0;
        while(l1 != null || l2 != null){
            currSum = carry;
            if(l1 != null){
                currSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                currSum += l2.val;
                l2 = l2.next;
            }
            carry = currSum /10;
            tmp.next = new ListNode(currSum%10);
            tmp = tmp.next;
        }
        if(carry != 0) tmp.next = new ListNode(carry);
        return res.next;
    }
}