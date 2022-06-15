class Solution {
    public int longestStrChain(String[] words) {
        
        //check for null input 
        if(words == null || words.length ==0)return 0;
        //make a hash map where keys are the words, and value is the length of the longest word sequence
        HashMap<String, Integer> hmap = new HashMap<>();
        //sort array based on the length of the words in the array 
        Arrays.sort(words, (a,b) -> a.length()-b.length());
        //the length of the longest seq possible
        int longestSeqLen =1;
        for(String word: words){
            //for each word we initialize current len
            int currLen = 1;
            //iterate over the entire len of each word
            for(int i=0; i< word.length(); i++){
                //delete the char at ith position from the current word 
                StringBuilder tmp = new StringBuilder(word);
                tmp.deleteCharAt(i);
                String predecessor = tmp.toString();
                int previousLen = 0;
                //if predecessor is present in the current list get its value and assign it to previousLen
                if(hmap.containsKey(predecessor)) previousLen = hmap.getOrDefault(predecessor, 0);
                currLen = Math.max(previousLen+1, currLen);
            }
            //assign the currLen to the current word in the map
            hmap.put(word, currLen);
            longestSeqLen = Math.max(longestSeqLen, currLen);
        }
        return longestSeqLen;
    }
}
//Time complexity: O(nlogn + n*l^2) where n is the number of words in the list and l i the max length of word (nlogn) for sorting the list and n*l^2 -> is for the outer loop iterates O(n) the inner loop runs for l^2 