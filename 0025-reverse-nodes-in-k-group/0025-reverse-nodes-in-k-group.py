# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def getKth(self, curr, k):
        while curr and k>0:
            curr = curr.next
            k -=1

        return curr

    def reverseKGroup(self, head, k):
        """
        :type head: Optional[ListNode]
        :type k: int
        :rtype: Optional[ListNode]
        """
        dummy = ListNode(0, head)
        groupPrev = dummy

        while True:

            kth = self.getKth(groupPrev, k)
            if not kth:
                break

            groupNext = kth.next
            prev, curr = groupNext, groupPrev.next

            while curr!= groupNext:
                tmp = curr.next
                curr.next = prev
                prev = curr
                curr = tmp

            tmp = groupPrev.next
            groupPrev.next = prev
            groupPrev = tmp

        return dummy.next
