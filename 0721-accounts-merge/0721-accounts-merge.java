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
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DS ds = new DS(n);
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail, i);
                }else{
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for(int i = 0; i < n; i++){
            mergedMail[i] = new ArrayList<String>();
        }
        for(Map.Entry<String, Integer> it : map.entrySet()){
            String mail = it.getKey();
            int node = ds.find(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(mergedMail[i].size() == 0){
                continue;
            }else{
                Collections.sort(mergedMail[i]);
                List<String> temp = new ArrayList<>();
                temp.add(accounts.get(i).get(0));
                for(String s : mergedMail[i]){
                    temp.add(s);
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}