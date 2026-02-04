class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        
        # Helper function for backtracking
        def backtrack(current_path):
            # Base Case: If the path length equals nums length, we found a permutation
            if len(current_path) == len(nums):
                result.append(list(current_path)) # Append a COPY
                return
            
            for num in nums:
                # Skip if num is already in the current path
                # Note: 'if num in current_path' is O(N) check. 
                # For small N this is fine. For larger N, use a Set or boolean array.
                if num not in current_path:
                    # 1. Choose
                    current_path.append(num)
                    
                    # 2. Explore
                    backtrack(current_path)
                    
                    # 3. Un-choose (Backtrack)
                    current_path.pop()
                    
        backtrack([])
        return result