class Solution {
    public int maximumGain(String s, int x, int y) {
        String highP = x > y ? "ab" : "ba";
        String lowP = x > y ? "ba" : "ab";

        int highS = Math.max(x, y);
        int lowS = Math.min(x, y);
        int score = 0;

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            sb.append(c);
            int len = sb.length();
            
            if(len >= 2 && sb.substring(len - 2).equals(highP)){
                sb.setLength(len-2);
                score += highS;
            }
        }

        String result = sb.toString();
        sb.setLength(0);
        
        for(char c : result.toCharArray()){
            sb.append(c);
            int len = sb.length();

            if(len >= 2 && sb.substring(len - 2).equals(lowP)){
                sb.setLength(len-2);
                score += lowS;
            }
        }

        return score;
    }
}