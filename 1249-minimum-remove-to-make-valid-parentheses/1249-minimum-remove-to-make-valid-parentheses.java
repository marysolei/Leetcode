class Solution {
    public String minRemoveToMakeValid(String s) {
        
       //check for null input 
        if (s == null || s.length() == 0)return s;
        //use a stack and a hashset for indexes
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> indexesToRemove = new HashSet<>();
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c== '('){
                stack.push(i);
            }else if(c==')'){
                if(stack.isEmpty()) indexesToRemove.add(i); //unbalanced parantheses
                else stack.pop();
            }
        }
        //add any remaining parantheses to the set
        while(!stack.isEmpty()) indexesToRemove.add(stack.pop());
        for(int i=0; i< s.length(); i++){
            if(!indexesToRemove.contains(i)) res.append(s.charAt(i));
        }
        return res.toString();
    }
}

//Time and Space complexity of O(n)