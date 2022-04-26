/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
//DFS solution
/*class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }
    public int dfs (List<NestedInteger> list, int depth){
        
        int total = 0;
        for(NestedInteger num : list){
            if(num.isInteger()) {
                total+= num.getInteger()*depth;
            }else {
                total += dfs(num.getList(), depth+1);
            }
        }
        return total;
    }
}*/

//BFS solution
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        
        Queue<NestedInteger> queue = new ArrayDeque<>();
        queue.addAll(nestedList);
        
        int total = 0;
        int depth = 1;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            for(int i=0; i< size; i++){
                NestedInteger curr = queue.poll();
                if(curr.isInteger()){
                    total+= curr.getInteger() * depth;
                }else {
                    queue.addAll(curr.getList());
                }
            }
            depth++;
        }
        return total;
    }
}
//Time and space complexity O(n) for both dfs and bfs solution where n is the total number of nested elements in the input