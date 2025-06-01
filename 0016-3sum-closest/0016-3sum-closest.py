class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        diff,close=float('inf'),0
        nums.sort()
        for i in range(len(nums)-2):
            if i>0 and nums[i]==nums[i-1]:
                continue
            start=i+1
            end=len(nums)-1
            while(start<end):
                temp=nums[i]+nums[start]+nums[end]
                d=abs(target-temp)
                if d<diff:
                    close=temp
                    diff=d
                if temp==target:
                    return target
                elif temp<target:
                    start+=1
                else:
                    end-=1  
        return close              


