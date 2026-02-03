class Solution(object):
    def shipWithinDays(self, weights, days):
        """
        :type weights: List[int]
        :type days: int
        :rtype: int
        """
        left, right = max(weights), sum(weights)

        while left < right:

            daysNeeded = 1
            currentWeight = 0

            mid = left + (right-left)//2

            for weight in weights:

                if weight + currentWeight> mid:
                    daysNeeded +=1
                    currentWeight = weight

                else:
                    currentWeight+= weight

            if daysNeeded > days:
                left = mid+1

            else:
                right = mid

        return left