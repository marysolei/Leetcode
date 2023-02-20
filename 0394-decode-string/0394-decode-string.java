class Solution {
    public String decodeString(String s) {
        
        if(s == null || s.length() ==0)return s;
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) queue.add(c);
        return helper(queue);
    }
    public String helper(Queue<Character> queue){
        int num = 0;
        StringBuilder sb = new StringBuilder();
        
        while(!queue.isEmpty()){
            char c = queue.poll();
            if(Character.isDigit(c)) {
                num = num*10 + c-'0';
            }else if(c == '['){
                String curr = helper(queue);
                for(int i=0;i<num; i++) sb.append(curr);
                num=0;
            }else if(c == ']') {
                break;
            } else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}