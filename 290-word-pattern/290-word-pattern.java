class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        //check edge cases 
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        
        //create two hashmaps one for char to word mapping the other 
        //one for word to char mapping
        HashMap<Character,String> chartoWordMap = new HashMap<>();
        HashMap<String,Character> wordtoCharMap = new HashMap<>();
        
        for(int i=0; i< words.length; i++){
            String word = words[i];
            char c = pattern.charAt(i);
            //if char exists in the char map
            if(!chartoWordMap.containsKey(c)){
                if(wordtoCharMap.containsKey(word)) return false;
                else {
                    chartoWordMap.put(c, word);
                    wordtoCharMap.put(word, c);
                }
            }else {
                String key = chartoWordMap.get(c);
                if(!key.equals(word)) return false;
            }
        }
        return true;
    }
}

//Time complexity: O(n) where n is the number of words in s 
//Space complexity: O(m) where m is the number of unique words in s 

/*have two hash maps, one for mapping characters to words and the other for mapping words to characters. While scanning each character-word pair,

- If the character is NOT in the character to word mapping, you additionally check whether that word is also in the word to character mapping.
    -If that word is already in the word to character mapping, then you can return False immediately since it has been mapped with some other character before.
    Else, update both mappings.
- If the character IS IN in the character to word mapping, you just need to check whether the current word matches with the word which the character maps to in the character to word mapping. If not, you can return False immediately.*/