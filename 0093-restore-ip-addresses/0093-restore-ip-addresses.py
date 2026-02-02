class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if len(s) >12:
            return []

        res = []

        def backtracking(i, dots, currentIP):
            if dots == 4 and i==len(s):
                res.append(currentIP[:-1])

            if dots > 4:
                return

            for j in range(i, min(i+3, len(s))):

                segment = s[i:j+1]
                
                if len(segment)>1 and segment[0] == '0':
                    continue

                if int(segment)> 255:
                    continue

                backtracking(j+1, dots+1, currentIP+segment+".")

        backtracking(0,0,"")
        return res
