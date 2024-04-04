class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int key=0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() > count){
                count = m.getValue();
                key = m.getKey();
            }
        }
        System.out.println(count);
        return (key);
    }
}