class Solution {
    public int compress(char[] chars) {
        //Brute - StringBuilder extra space of O(N)
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while(index < chars.length){
            char currentCharacter = chars[index];
            int count = 0;

            while (index < chars.length && chars[index] == currentCharacter) {
                count++;
                index++;
            }

            sb.append(currentCharacter);
            if (count > 1) {
                sb.append(count);
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();

        //Better
    }
}