class Solution {
    public boolean isValid(String s) {
        
        if(s== null || s.length()<=1) return false;
        HashMap<Character, Character> hmap = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        hmap.put('(',')');
        hmap.put('{','}');
        hmap.put('[',']');
        for(char c : s.toCharArray()){
            if(c == '{' || c== '(' || c =='[') stack.push(hmap.get(c));
            else {
                if(stack.isEmpty() || stack.pop() != c )  return false;
                  }
        }
         return stack.size() ==0;
    }
}
//Time and space complexity: O(n) where n is the number of chars in s