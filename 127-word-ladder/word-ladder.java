class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<String>();
        for(String s : wordList){
            set.add(s);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            String word = q.peek().str;
            int c = q.peek().count;
            q.poll();

            if(word.equals(endWord)){
                return c;
            }

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedArr = word.toCharArray();
                    replacedArr[i] = ch;
                    String replaced = new String(replacedArr);
                    if(set.contains(replaced)){
                        set.remove(replaced);
                        q.add(new Pair(replaced, c+1));
                    }
                }
            }
        }

        return 0;
    }
}

class Pair{
    String str;
    int count;
    Pair(String strIn, int countIn){
        str = strIn;
        count = countIn;
    }
}