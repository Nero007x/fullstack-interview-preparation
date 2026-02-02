class Solution(object):
    def rotatedDigits(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        
        for i in range(1, n + 1):
            s = str(i)
            
            # 1. Immediate Disqualification: If it contains invalid digits
            if '3' in s or '4' in s or '7' in s:
                continue
                
            # 2. Must contain at least one digit that changes (2, 5, 6, 9)
            if '2' in s or '5' in s or '6' in s or '9' in s:
                count += 1
                
        return count