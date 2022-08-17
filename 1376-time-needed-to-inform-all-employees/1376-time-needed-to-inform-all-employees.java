class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        //building the graph
        List<Integer>[] graph = new List[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<n; i++) if(manager[i] != -1) graph[manager[i]].add(i);
        
        //make a queue for bfs
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{headID,0}); //add headId to the queue
        int res = 0;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currEmployee = curr[0];
            int currTime = curr[1];
            res = Math.max(res, currTime);
            //check neighbors
            for(int neighbor : graph[currEmployee]) {
                queue.add(new int[]{neighbor, currTime+informTime[currEmployee]});
            }
        }
        return res;
    }
}
//The time for a manager = max(manager's employees) + informTime[manager]
//Time and Space complexity O(n)