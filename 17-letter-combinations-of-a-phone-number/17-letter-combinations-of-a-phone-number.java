class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        //check for null input 
        if(digits == null || digits.length() == 0)return result;
        HashMap<Character, String> hmap = new HashMap<>();
        hmap.put('2', "abc");
        hmap.put('3', "def");
        hmap.put('4', "ghi");
        hmap.put('5', "jkl");
        hmap.put('6', "mno");
        hmap.put('7', "pqrs");
        hmap.put('8', "tuv");
        hmap.put('9', "wxyz");
        
        StringBuilder res = new StringBuilder();
        helper(digits, hmap, res, result);
        return result;
    }
    public void helper(String digits,HashMap<Character, String> hmap, StringBuilder curr, List<String> result) {
        
        //check base case 
        if(curr.length() == digits.length()) {
            result.add(curr.toString());
            return;
        }
        String letters = hmap.get(digits.charAt(curr.length()));
        for(int i=0; i< letters.length(); i++) {
            curr.append(letters.charAt(i));
            helper(digits,hmap, curr, result);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}