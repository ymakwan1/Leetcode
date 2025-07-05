class RandomizedSet {
    HashMap<Integer, Integer> valueIndexMap;
    ArrayList<Integer> valueList = new ArrayList<>();
    Random random;

    public RandomizedSet() {
        valueIndexMap = new HashMap<>();
        valueList = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(valueIndexMap.containsKey(val)){
            return false;
        }

        valueIndexMap.put(val, valueList.size());
        valueList.add(valueList.size(), val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!valueIndexMap.containsKey(val)) {
            return false;
        }

        int lastElement = valueList.get(valueList.size() - 1);
        int index = valueIndexMap.get(val);
        valueList.set(index, lastElement);
        valueIndexMap.put(lastElement, index);
        valueList.remove(valueList.size() - 1);
        valueIndexMap.remove(val);

        return true;
    }
    
    public int getRandom() {
        return valueList.get(random.nextInt(valueList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */