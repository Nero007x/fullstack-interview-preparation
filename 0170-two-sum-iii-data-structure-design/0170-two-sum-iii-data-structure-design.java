class TwoSum {

    Map<Integer, Integer> pairs;

    public TwoSum() {
        pairs = new HashMap<>();
    }
    
    public void add(int number) {
        pairs.put(number, pairs.getOrDefault(number, 0)+1);
        
    }
    
    public boolean find(int value) {
        for(int val : pairs.keySet()){
            int remain = value - val;
            if(remain == val){
                if(pairs.get(val)>=2){
                    return true;
                }
            }else{
                if(pairs.containsKey(remain)){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */