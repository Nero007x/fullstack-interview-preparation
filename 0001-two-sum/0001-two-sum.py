class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numSet = set()
        for i, n in enumerate(nums):
            if target - n in numSet:
                return [nums.index(target - n), i]
            numSet.add(n)
        