class Solution(object):
    def splitArray(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        left, right = max(nums), sum(nums)

        while left < right:

            subArrayNeeded = 1
            currentSum = 0

            mid = left + (right-left)//2

            for n in nums:

                if n + currentSum> mid:
                    subArrayNeeded += 1
                    currentSum=n
                else:
                    currentSum+=n
            
            if subArrayNeeded > k :
                left = mid +1

            else:
                right = mid

        return left

