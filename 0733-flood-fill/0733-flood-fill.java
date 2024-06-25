class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];
        if (initColor != color) {
            dfs(image, sr, sc, initColor, color);
        }

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int initColor, int color){
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != initColor) {
            return;
        }

        image[sr][sc] = color;
        
        dfs(image, sr-1, sc, initColor, color);
        dfs(image, sr+1, sc, initColor, color);
        dfs(image, sr, sc-1, initColor, color);
        dfs(image, sr, sc+1, initColor, color);
    }
}