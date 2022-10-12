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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        //check for null input 
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while(list1 != null && list2 != null){
            if(list1.val< list2.val){
                tmp.next = list1;
                list1 = list1.next;
            }else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        if(list1 != null) tmp.next = list1;
        else if(list2 != null) tmp.next = list2;
        return res.next;
    }
}

//Time and Space complexity O(m+n) where m is the length of list1 and n is the length of list2