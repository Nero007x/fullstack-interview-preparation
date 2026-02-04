class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()  # Sorting helps with early pruning

        def dfs(i, cur, total):
            if total == target:
                res.append(cur[:])
                return
            if total > target:
                return

            for j in range(i, len(candidates)):
                if total + candidates[j] > target:
                    break  # Prune the search space early
                cur.append(candidates[j])
                dfs(j, cur, total + candidates[j])  # reuse same number
                cur.pop()

        dfs(0, [], 0)
        return res