/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        //check edge cases
        if (headA == null || headB == null)return null;
        if (headA == headB) return headA;
        
        //get tail and the len of each ll
        Result resA = getTailandLen(headA);
        Result resB = getTailandLen(headB);
        ListNode longer= null;
        ListNode shorter = null;
        int diff =0;
        
        //determine which one is the longer list and which one the shorter
        if (resA.len > resB.len) {
            longer = headA;
            shorter = headB;
            diff = resA.len - resB.len;
        }else {
            longer = headB;
            shorter = headA;
            diff = resB.len - resA.len;
        }
       //go through the longer for diff
        while (diff >0 ){
            longer = longer.next;
            diff--;
        }
        //start with both nodes till they intersect
        while(longer != shorter) {
            longer = longer.next;
            shorter= shorter.next;
        }
        return shorter;
        
    }
    
    //get the tail and len of a linked list
    public Result getTailandLen(ListNode head ) {
        
        Result res = new Result();
        int cnt =1;
        while(head.next != null) {
            head = head.next;
            cnt++;
        }
        res.tail = head;
        res.len = cnt;
        return res;
    }
    public class Result {
        ListNode tail; 
        int len;
        public Result() {
            this.tail = null;
            this.len=0;
        }
    }
}