class Solution(object):
    def shipWithinDays(self, weights, days):
        """
        :type weights: List[int]
        :type days: int
        :rtype: int
        """
        left,right = max(weights), sum(weights)

        while left < right:

            days_needed = 1
            currentWeight = 0
            
            mid = left+(right-left)//2

            for weight in weights:

                if weight + currentWeight >mid:
                    days_needed +=1
                    currentWeight = weight

                else:
                    currentWeight += weight

            if days_needed> days:
                left = mid +1

            else:
                right = mid

        return left