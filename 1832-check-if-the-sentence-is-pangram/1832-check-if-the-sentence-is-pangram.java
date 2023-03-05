class Solution {
    public boolean checkIfPangram(String sentence) {
        
        if(sentence.length() == 0 || sentence == null) return false;
        HashSet<Character> hset = new HashSet<>();
        for(char c : sentence.toCharArray()){
            hset.add(c);
        }
        return hset.size() ==26;
    }
}