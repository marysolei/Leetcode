class Solution {
    int[] parent;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        //check for null input 
        if(s == null || s.length() ==0)return null;
        //make the parent arr for union find
        parent = new int[s.length()];
        for(int i=0;i<s.length(); i++){
            parent[i]= i;
        }
        //union
        for(List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }
        HashMap<Integer, PriorityQueue<Character>> hmap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            int root = find(i);
            if(!hmap.containsKey(root)) hmap.put(root, new PriorityQueue<>());
            hmap.get(root).add(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            int curr = find(i);
             res.append(hmap.get(curr).poll());
        }
        return res.toString();
    }
    public int find(int index){
        while(parent[index] != index){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
    public void union(int a , int b){
        int aParent = find(a);
        int bParent = find(b);
        if(aParent<bParent){
            parent[bParent] = aParent;
        }else{
            parent[aParent] = bParent;
        }
    }
   
}
/*From Leetcode: The important point to note here is that if we have pairs like (a, b) and (b, c), then we can swap characters at indices a and c. Although we don't have the pair (a, c), we can still swap them by first swapping them with the character at index b. Thus, because we can swap the characters at these indices any number of times, we can rearrange the characters a, b, and c into any order.
This can be depicted as a graph problem. Each index is a vertex and each given pair is an edge between the vertices. An edge implies that we can travel from one vertex to another, or in other words, we can swap them.(Sort the characters within each connected group.)
1) For each the given pairs, create connected groups using union-find. Always mark the smaller index as parent;
2) For each character in s, create mapping from root -> a list of candidate char. Since we want to use the smallest one every time, use PriorityQueue.
3)Finally, for each index, choose the first char in the associated pq and append into result.
*/