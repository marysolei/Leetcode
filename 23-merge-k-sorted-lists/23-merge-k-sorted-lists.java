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
        
        //check for null input 
        if(lists == null || lists.length ==0)return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val - b.val);
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        
        for(ListNode node : lists){
            if(node != null) minHeap.add(node);
        }
        while(!minHeap.isEmpty()){
            tmp.next = minHeap.poll();
            tmp = tmp.next;
            if(tmp.next != null)minHeap.add(tmp.next);
        }
        return res.next;
    }
}