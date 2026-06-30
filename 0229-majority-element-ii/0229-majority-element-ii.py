class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        if not nums or len(nums)==0:
            return None

        elif len(nums) <= 2:
            return list(set(nums))

        res1, res2, count1, count2 = None, None, 0, 0

        for n in nums:
            if res1 == n:
                count1 +=1
            elif res2 == n:
                count2 +=1
            elif count1 ==0:
                res1 = n 
                count1 = 1
            elif count2 == 0:
                res2 = n
                count2 = 1

            else:
                count1 -=1
                count2 -=1 

        result = []

        for n in (res1, res2):
            if nums.count(n)> len(nums)//3:
                result.append(n)

        return result