class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return None

        elif len(nums) == 1:
            return nums[0]

        result = count = 0

        for n in nums:

            if count == 0:
                count = 0
                result = n

            count +=1 if n == result else -1

        return result
            