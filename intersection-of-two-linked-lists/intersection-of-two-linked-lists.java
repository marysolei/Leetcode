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
     
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = pA== null? headB: pA.next;
            pB = pB== null? headA: pB.next;
        }
        return pA;
    }
}

//time complexity: O(n+m)
//space complexity: O(1)

/*From leetcode: 
Algorithm

Set pointer pA to point at headA.
Set pointer pB to point at headB.
While pA and pB are not pointing at the same node:
If pA is pointing to a null, set pA to point to headB.
Else, set pA to point at pA.next.
If pB is pointing to a null, set pB to point to headA.
Else, set pB to point at pB.next.
return the value pointed to by pA (or by pB; they're the same now).*/