class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       // {1: 3}, {2 : 2}, {3:1}
       // k = 2
       
       HashMap<Integer, Integer> frequencyMap = new HashMap(); //{element : freq}
       
       for(int num : nums){
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
       }
       
       PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
       
       for(Map.Entry<Integer, Integer> entry :frequencyMap.entrySet()){
        pq.offer(entry);
        if(pq.size() > k){
            pq.poll();
        }
       }
       
       int[] result = new int[k];
       int i = 0;
       while(!pq.isEmpty()){
        result[i++] = pq.poll().getKey();
       }
       
       return result;
    }
}