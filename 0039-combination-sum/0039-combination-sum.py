class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        
        # current_combination: the list of numbers we have picked so far
        # current_sum: the sum of those numbers
        # start_index: the index in 'candidates' we are currently considering
        def backtrack(current_combination, current_sum, start_index):
            
            # Base Case 1: Success
            if current_sum == target:
                result.append(list(current_combination))
                return
            
            # Base Case 2: Failure (Overshot the target)
            if current_sum > target:
                return
            
            # Recursive Step
            for i in range(start_index, len(candidates)):
                # 1. Choose the candidate
                current_combination.append(candidates[i])
                
                # 2. Explore
                # Key Detail: We pass 'i' (not i + 1) because we can REUSE the same number
                backtrack(current_combination, current_sum + candidates[i], i)
                
                # 3. Un-choose (Backtrack)
                current_combination.pop()
                
        backtrack([], 0, 0)
        return result