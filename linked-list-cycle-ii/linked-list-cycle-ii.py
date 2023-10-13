# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None: return head;
        slow = head
        fast = head
        tmp = head
        while(fast is not None and fast.next is not None):
            slow = slow.next
            fast = fast.next.next
            if slow == fast: break
        if fast is None or fast.next is None: return None
        while tmp != slow:
            tmp = tmp.next
            slow = slow.next
        return tmp