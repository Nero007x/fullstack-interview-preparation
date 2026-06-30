class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return None

        elif len(nums) == 1:
            return nums[0]

        
        count = {}
        result = maxCount = 0

        for n in nums:
            count[n] = 1 + count.get(n, 0)

            if count[n]> maxCount:
                maxCount = count[n]
                result = n

        return result
            