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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length ==0)return null;
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node : lists){
           if(node != null) minHeap.add(node);
        }
        while(!minHeap.isEmpty()){
            tmp.next = minHeap.poll();
            tmp = tmp.next;
            if(tmp.next != null) minHeap.add(tmp.next);
        }
        return res.next;
    }
}
//Time complexity: O(nlogk) where k is the number of linked lists. and n total number of nodes in final list.
//Space complexity: O(n) creating a new linked list 
