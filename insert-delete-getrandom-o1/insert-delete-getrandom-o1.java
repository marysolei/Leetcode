class RandomizedSet {
    
    //Using a hashmap and arrlist
    HashMap<Integer, Integer> hmap;
    ArrayList<Integer> list ;
    public RandomizedSet() {
        hmap = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hmap.containsKey(val)) return false;
        hmap.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hmap.containsKey(val)) return false;
        int index = hmap.get(val);
        int lastElement = list.get(list.size()-1);
        hmap.put(lastElement, index);
        hmap.remove(val, index);
        list.set(index, lastElement);
        list.remove(list.size()-1);
        return true;
        
    }
    
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

//time complexity O(n)
//space complexity O(1)

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */