class Solution {
    public int countVowelStrings(int n) {
     
        //check base cases
        if(n == 0)return 0;
        StringBuilder curr = new StringBuilder();
        String letters = "aeiou";
        List<String> result = new ArrayList<>();
        helper(n, letters, curr, result,0);
        return result.size();
    }
    public void helper(int n, String letters, StringBuilder curr, List<String> result, int index){
        if(n == curr.length()){
            result.add(curr.toString());
            return;
        }
        for(int i=index; i<letters.length(); i++){
            curr.append(letters.charAt(i));
            helper(n,letters, curr, result, i);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}