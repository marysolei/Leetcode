class Solution {
    public int makeConnected(int n, int[][] connections) {
       
        //check for null input 
        if(connections.length ==0 || connections== null) return -1;
        if(connections.length < n-1)return -1; //to connect n nodes we need at least n-1 connections
        //make a graph from connections
        List<Integer>[] graph = new List[n];
        for(int r=0; r< n; r++) graph[r]= new ArrayList<>();
        for(int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        int totalComponents = 0;
        boolean[] visited = new boolean[n];
        //bfs through the vertices to get the total component
        for(int v=0; v <n ; v++) totalComponents += bfsHelper(v, visited, graph);
        return totalComponents-1;
    }
    public int bfsHelper(int node, boolean[] visited, List<Integer>[] graph){
        
        if(visited[node]) return 0;
        visited[node] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            //get the neighbors
            for(int neighbor: graph[curr]){
                if(!visited[neighbor]){
                    visited[neighbor]= true;
                    queue.add(neighbor);
                }
            }
        }
        return 1;
    }
}
//Time Complexity: O(n+m) m is the length of connections
//Space Complexity: O(n)