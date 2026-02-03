class Solution(object):
    def minEatingSpeed(self, piles, h):
        """
        :type piles: List[int]
        :type h: int
        :rtype: int
        """
        left, right  = 1, max(piles)

        while left < right:

            hoursTake = 0
            mid = left +(right -left)//2

            for pile in piles:

                hoursTake += (pile+mid-1)//mid

            if hoursTake> h:
                left = mid +1

            else:
                right = mid

        return left