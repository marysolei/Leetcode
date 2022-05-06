class Solution {
    public String removeDuplicates(String s, int k) {
        
        if(s == null || s.length() < k) return s;
        Stack<Pair> stack = new Stack<>();
       
        for(char c : s.toCharArray()){ 
            if(stack.isEmpty() || c != stack.peek().ch){
                stack.push(new Pair(c,1));
            }else {
                if(++stack.peek().cnt ==k) stack.pop();
            } 
        }
        
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            Pair curr = stack.pop();
            for(int i=0; i< curr.cnt; i++){
                res.append(curr.ch);
            }
        }
        return res.reverse().toString();
    }
    public class Pair{
        char ch; 
        int cnt;
        public Pair(char c , int cnt){
            this.ch = c;
            this.cnt = cnt;
        }
    }
}
//Time and Space complexity of O(n)