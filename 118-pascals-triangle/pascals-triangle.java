class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            r.add(generateRow(i));
        }
        return r;
    }

    private List<Integer> generateRow(int numRowsIn){
        int ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(ans);

        for(int col = 1; col < numRowsIn; col++){
            ans = ans * (numRowsIn - col);
            ans = ans / col;
            ansRow.add(ans);
        }

        return ansRow;
    }
}