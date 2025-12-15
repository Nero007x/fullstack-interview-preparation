import heapq
class Solution:
    def topKFrequent(self, nums, k):
        bucket = [[] for _ in range(len(nums) + 1)]
        Count = Counter(nums).items()  
        for num, freq in Count: bucket[freq].append(num) 
        final=[]
        for b in bucket[::-1]:
            for num in b:
                final.append(num)
                if len(final)==k:
                    return final
        
            



        
            
        