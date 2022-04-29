class Solution {
    public boolean isBipartite(int[][] graph) { 
        //check for null input 
        if(graph == null || graph.length ==0)return false;
        int n = graph.length;
        int[] colors = new int[n];
        
        for(int i=0; i< n ; i++) {
            if(colors[i] != 0)continue; //already colored
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            colors[i]= 1; //blue: 1 red: -1
            
            while(!queue.isEmpty()){
                int curr = queue.poll();
                for(int neighbor : graph[curr]){
                    if(colors[neighbor] ==0) { //if the node hasn't been visited
                        colors[neighbor] = -colors[curr]; //color it with a different color
                        queue.add(neighbor);
                    }else if(colors[neighbor] != -colors[curr]) return false;//it is colored with a different color
                }
            }
        }
        return true;
    }
}