class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        stack = []
        numk = float('-inf')

        for num in reversed(nums):
            if num < numk:
                return True
            while stack and num> stack[-1]:
                numk = stack.pop()
            stack.append(num)

        return False
        