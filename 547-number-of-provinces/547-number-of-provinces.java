class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        //check for null input 
        if(isConnected == null || isConnected.length==0)return 0;
        int n = isConnected.length;
        int[] visited = new int[n];
        int numProvinces=0;
        //make a queue for bfs traversal
        Queue<Integer> queue = new ArrayDeque<>();
        
        //find the first 1
        for(int row=0;row<n ; row++){
            if(visited[row]==0){
                queue.add(row);
                while(!queue.isEmpty()){
                    int r = queue.poll();
                    visited[r]= 1;
                    for(int c=0; c< n ; c++){
                        if(isConnected[r][c] ==1 && visited[c] ==0){
                            queue.add(c);
                        }
                    }
                }
                numProvinces++;
            }
        }
        return numProvinces;
    }
}
//Time Complexity: O(n^2) matrix is of size of n^2
//space Complexity: O(n) a queue of size of n
/*we start from a particular node and visit all its directly connected nodes first. After all the direct neighbours have been visited, we apply the same process to the neighbour nodes as well. Thus, we exhaust the nodes of a graph on a level by level basis. 

We increment the count of connected components whenever we need to start off with a new node as the root node for applying BFS which hasn't been already visited.*/