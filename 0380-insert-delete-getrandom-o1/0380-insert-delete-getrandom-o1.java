class RandomizedSet {
    HashMap<Integer,Integer> valueToIndex;
    List<Integer> values;
    Random rand;
    public RandomizedSet() {
        valueToIndex = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(valueToIndex.containsKey(val)){
            return false;
        }

        valueToIndex.put(val, values.size());
        values.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valueToIndex.containsKey(val)){
            return false;
        }

        int indexToRemove = valueToIndex.get(val);
        int lastValue = values.get(values.size()-1);

        values.set(indexToRemove, lastValue);
        valueToIndex.put(lastValue,indexToRemove);

        values.remove((values.size()-1));
        valueToIndex.remove(val);

        return true;
    }
    
    public int getRandom() {
        int randomIndex = rand.nextInt(values.size());

        return values.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */