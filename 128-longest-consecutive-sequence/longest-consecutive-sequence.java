class DS{
    private int[] parent;
    private int[] size;

    public DS(int n){
        parent = new int[n];
        size = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u){
        if(u == parent[u]){
            return u;
        }

        return parent[u] = find(parent[u]);
    }

    public void unionBySize(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            if(size[rootX] < size[rootY]){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }else{
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    public int maxSeq() {
        int seq = Integer.MIN_VALUE;
        for (int i = 0; i < size.length; i++) {
            if (parent[i] == i) {
                seq = Math.max(size[i], seq);
            }
        }
        return seq;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        //int count = 0;
        int seqCount = 0;
        int lastSmaller = Integer.MIN_VALUE;

        //Better approach
        // Arrays.sort(nums);
        // for(int i = 0; i < n; i++){
        //     if(nums[i] - 1 == lastSmaller){
        //         count++;
        //         lastSmaller = nums[i];
        //     }else if(nums[i] != lastSmaller){
        //         count = 1;
        //         lastSmaller = nums[i];
        //     }
        //     seqCount = Math.max(seqCount, count);
        // }

        //Optimal
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(Integer i : set){
            if(!set.contains(i-1)){
                int count = 1;
                int x = i;
                while(set.contains(x+1)){
                    x = x + 1;
                    count++;
                }
                seqCount = Math.max(seqCount, count);
            }
        }

        return seqCount;

        //UnionFind
        // DS ds = new DS(n);
        // if(n == 0){
        //     return 0;
        // }
        // HashMap<Integer, Integer> map = new HashMap<>(); //Map values to indices
        // for (int i = 0; i < n; i++) {
        //     if (!map.containsKey(nums[i])) {
        //         map.put(nums[i], i);
        //     }
        // }

        // //Union adjacent elements
        // for (int num : nums) {
        //     if (map.containsKey(num - 1)) { //Check if num-1 exists
        //         ds.unionBySize(map.get(num), map.get(num - 1));
        //     }
        // }

        // return ds.maxSeq();
    }
}