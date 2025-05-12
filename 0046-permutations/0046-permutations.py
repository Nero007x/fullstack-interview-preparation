class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        perms = [[]]

        for n in nums:
            nextPerms = []
            for p in perms:
                for i in range(len(p)+1):
                    pcopy = p.copy()
                    pcopy.insert(i, n)
                    nextPerms.append(pcopy)
            perms = nextPerms
        return perms

        