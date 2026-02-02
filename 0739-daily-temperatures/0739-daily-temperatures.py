class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        n = len(temperatures) 
        stack = []
        result = [0]*n

        for i, temp in enumerate(temperatures):

            while stack and temp > temperatures[stack[-1]]:
                previous_index = stack.pop()
                result[previous_index] = i - previous_index

            stack.append(i)

        return result