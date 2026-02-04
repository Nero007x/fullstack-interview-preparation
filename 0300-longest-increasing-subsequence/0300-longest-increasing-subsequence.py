class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        sub = []

        for num in nums:
            # --- Manual Binary Search Start ---
            # We want to find the first index 'left' where sub[left] >= num
            left, right = 0, len(sub)
            
            while left < right:
                mid = (left + right) // 2
                if sub[mid] < num:
                    # num is larger, so the insertion point is to the right
                    left = mid + 1
                else:
                    # sub[mid] >= num, so the insertion point is here or to the left
                    right = mid
            # --- Manual Binary Search End ---
            
            # 'left' is now the index where 'num' fits
            if left == len(sub):
                # num is larger than everything in sub
                sub.append(num)
            else:
                # Replace the first element that is >= num
                sub[left] = num
                
        return len(sub)