class Solution(object):
    def repeatLimitedString(self, s, repeatLimit):
        """
        :type s: str
        :type repeatLimit: int
        :rtype: str
        """
        freq = [0]*26
        for ch in s:
            freq[ord(ch) - ord('a')] +=1

        result = []
        curr= 25

        while curr>=0:
            if freq[curr] == 0:
                curr -=1
                continue
            
            use = min(freq[curr], repeatLimit)
            result.append(chr(ord('a')+curr)*use)
            freq[curr] -=use

            if freq[curr] >0:
                nextCurr = curr -1
                while nextCurr>=0 and freq[nextCurr] ==0 :
                    nextCurr -=1 

                if nextCurr <0:
                    break

                result.append(chr(ord('a')+nextCurr))
                freq[nextCurr] -= 1

            else:
                curr -= 1

        return "".join(result) 