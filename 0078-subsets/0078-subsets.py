class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsets, curset = [], []
        self.helper(0, nums, curset, subsets)
        return subsets
    
    def helper(self, i, nums, curset, subsets):
        if i>= len(nums):
            subsets.append(curset.copy())
            return
        
        #decision to include nums[i]
        curset.append(nums[i])
        self.helper(i+1, nums, curset, subsets)
        curset.pop()

        #decision NOT to include nums[i]
        self.helper(i+1, nums, curset, subsets)