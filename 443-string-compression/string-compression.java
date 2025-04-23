class Solution {
    public int compress(char[] chars) {
        //Brute - StringBuilder extra space of O(N)
        // StringBuilder sb = new StringBuilder();
        // int index = 0;

        // while(index < chars.length){
        //     char currentCharacter = chars[index];
        //     int count = 0;

        //     while (index < chars.length && chars[index] == currentCharacter) {
        //         count++;
        //         index++;
        //     }

        //     sb.append(currentCharacter);
        //     if (count > 1) {
        //         sb.append(count);
        //     }
        // }

        // for (int i = 0; i < sb.length(); i++) {
        //     chars[i] = sb.charAt(i);
        // }

        // return sb.length();

        //Better - Two pointer
        int n = chars.length;
        int writeIndex = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            if(j == n - 1 || chars[j] != chars[j + 1]){
                chars[writeIndex++] = chars[i];

                int count = j - i + 1;
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[writeIndex++] = c;
                    }
                }
                i = j + 1;
            }
        }

        return writeIndex;
    }
}