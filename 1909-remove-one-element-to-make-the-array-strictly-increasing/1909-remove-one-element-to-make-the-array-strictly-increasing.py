class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        prev = nums[0]
        count = 0
        for i in range(1, len(nums)):
            if nums[i] > prev:
                prev = nums[i]
            else:
                count +=1
                if count > 1:
                    return False

                if i== 1 or nums[i]> nums[i-2]:
                    prev = nums[i]
        return True