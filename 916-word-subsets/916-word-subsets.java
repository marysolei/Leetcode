class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> result = new ArrayList<>();
        if(words2 == null || words2.length ==0)return result;
        int[] count = new int[26];
        int[] tmp = count;
        int i;
        //For each word in words2,we use function counter to count occurrence of each letter.
        //We take the maximum occurrences of counts, and use it as a filter of words1.
        for(String word2 : words2){
            tmp = counter(word2);
            for(i=0;i<26; i++){
                count[i] = Math.max(count[i], tmp[i]);
            }
        }
        for(String word1 : words1){
            tmp = counter(word1);
            for(i=0;i<26; i++){
                if(tmp[i]<count[i]) break;
            }
            if(i==26) result.add(word1);
        }
        return result;
    }
    public int[] counter(String word){
        int[] count = new int[26];
        for(char c : word.toCharArray()) count[c-'a']++;
        return count;
    }
}