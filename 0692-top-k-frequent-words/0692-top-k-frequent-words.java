class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String w : words){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> {
            int o1 = map.get(w1);
            int o2 = map.get(w2);

            if(o1 == o2){
                return w2.compareTo(w1);
            }

            return Integer.compare(o1, o2);
        });

        ArrayList<String> res = new ArrayList<>();

        for(String s : map.keySet()){
            heap.offer(s);
            if(heap.size() > k){
                heap.poll();
            }
        }

        while(!heap.isEmpty()){
            res.add(heap.poll());
        }

        Collections.reverse(res);
        return res;
    }
}