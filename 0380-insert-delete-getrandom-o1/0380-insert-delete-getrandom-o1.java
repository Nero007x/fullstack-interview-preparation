class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> valMap;
    Random rand;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.valMap = new HashMap<>();
        this.rand = new Random();
    }
    
    public boolean insert(int val) {
        if(valMap.containsKey(val)){
            return false;
        }

        list.add(val);
        valMap.put(val, list.size()-1);
        return true;
        
    }
    
    public boolean remove(int val) {
        if(!valMap.containsKey(val)){
            return false;
        }

        int idx = valMap.get(val);
        int lastElement = list.get(list.size() -1);

        list.set(idx,lastElement);
        valMap.put(lastElement, idx);

        list.remove(list.size() -1);
        valMap.remove(val);

        return true;


        
    }
    
    public int getRandom() {

        int idx = rand.nextInt(list.size());
        return list.get(idx);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */