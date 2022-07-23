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
        if(head == null)return head;
        HashSet<ListNode> visited = new HashSet<>();
        ListNode tmp = head;
        
        while(tmp != null){
            if(visited.contains(tmp)) return tmp;
            visited.add(tmp);
            tmp = tmp.next;
        }
        return null;
    }
}
//Time and space complexity: O(n)