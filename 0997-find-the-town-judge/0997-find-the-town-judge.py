from collections import defaultdict

class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        if n == 1 and not trust:
            return 1

        # Use a dictionary to store the score for each person ID
        scores = defaultdict(int)

        for a, b in trust:
            scores[a] -= 1  # 'a' trusts someone -> decrement score
            scores[b] += 1  # 'b' is trusted -> increment score

        # Iterate 1 to n to see who meets the criteria
        for i in range(1, n + 1):
            if scores[i] == n - 1:
                return i
                
        return -1