class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> freqMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        freqMap = new HashMap<>();

        for(int num : nums2){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
    }
    
    public void add(int index, int val) {
        int oldValue = nums2[index];
        int newValue = nums2[index]+val;

        freqMap.put(oldValue, freqMap.get(oldValue)-1);
        if(freqMap.get(oldValue)==0){
            freqMap.remove(oldValue);
        }

        nums2[index] += val;

        freqMap.put(newValue, freqMap.getOrDefault(newValue, 0)+1);
    }
    
    public int count(int tot) {
          int count = 0;
          for(int num : nums1){
            int diff = tot - num;
            count += freqMap.getOrDefault(diff, 0);
          }
          return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */