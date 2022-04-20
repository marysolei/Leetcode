class Solution {
    public String simplifyPath(String path) {
        
        //check for null input 
        if(path == null || path.length() == 0)return path;
        //use stack to track the directories
        Stack<String> stack = new Stack<>();
        //split the path by "/"
        String[] pathArr = path.split("/");
        StringBuilder res = new StringBuilder();
        
        for(String dir: pathArr){
            if(dir.isEmpty() || dir.equals(".") ){
                continue;
            }else if (dir.equals("..")){
                //current dir is .. then we need to pop the last element of stack == going back one directory
                if(!stack.isEmpty()) stack.pop();
            }else {
                stack.push(dir); //a dir name so we add it to stack
            }
        }
        for(String key: stack){
            res.append("/");
            res.append(key);
        }
        if(res.length() ==0) return "/";
        return res.toString();
        
    }
}
//Time complexity: O(n) where n is the number of characters in the path
//Space complexity: O(n)