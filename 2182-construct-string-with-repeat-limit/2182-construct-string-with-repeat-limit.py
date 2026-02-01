class Solution(object):
    def repeatLimitedString(self, s, repeatLimit):
        """
        :type s: str
        :type repeatLimit: int
        :rtype: str
        """
        freq = Counter(s)
        result = []

        while True:
            for ch in range(25, -1, -1):
                curr = chr(ord('a')+ch)
                if freq[curr]>0:
                    break
            else:
                break

            use = min(repeatLimit, freq[curr])
            result.append(curr*use)
            freq[curr] -=use

            if freq[curr]> 0:
                for next in range(ch-1, -1, -1):
                    nextCh = chr(ord('a')+next)
                    if freq[nextCh]>0:
                        result.append(nextCh)
                        freq[nextCh] -=1
                        break
                else:
                    break

        return "".join(result)


        

        