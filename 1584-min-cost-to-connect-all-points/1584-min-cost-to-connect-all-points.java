class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<int[]> edges = new ArrayList<>();
        
        //sorting edges of our complete graph
        for(int curr =0; curr<n ; curr++) {
            for(int next = curr+1; next<n ; next++){
                int weight = Math.abs(points[curr][0]-points[next][0]) + Math.abs(points[curr][1] - points[next][1]);
                
                int[] currEdge = {weight, curr, next};
                edges.add(currEdge);
            }
        }
        //sort edges in ascending order
        Collections.sort(edges, (a,b) ->a[0]-b[0]);
        
        UnionFind uf = new UnionFind(n);
        int mstCost =0;
        int edgesUsed = 0;
        for(int i=0; i< edges.size() && edgesUsed<n-1; i++){
            
            int weight = edges.get(i)[0];
            int node1 = edges.get(i)[1];
            int node2 = edges.get(i)[2];
            if(uf.union(node1, node2)){
                mstCost += weight;
                edgesUsed++;
            }
        }
        return mstCost;
    }
}
    public class UnionFind {
        //to store the root and rank of each node
        int[] group;
        int[] rank;
        public UnionFind(int size) {
            group = new int[size];
            rank = new int[size];
            for(int i=0;i< size; i++) group[i] =i;
        }
        //to find the group of node a
        public int find (int node){
            if(group[node] != node) group[node] = find(group[node]);
            return group[node];
        }
        public boolean union (int node1, int node2){
            int group1 = find(node1);
            int group2 = find(node2);
            //node 1 and node2 already belong to same group
            if(group1 == group2) return false;
            
            if(rank[group1]> rank[group2]){
                group[group2] = group1;
            }else if (rank[group1] < rank[group2]) {
                group[group1] = group2;
            }else {
                group[group1] = group2;
                rank[group2] +=1;
            }
            return true;
        }
        
    }

/*From Leetcode: we can say we need to connect some points (the connection between any two points will be an edge whose weight is the Manhattan distance between those points) such that all points become connected and the sum of the weights of the chosen edges is minimized.this problem is a variant of graph problems. it is a Minimum Spanning Tree (MST) problem, where we are given nodes (points) and weighted edges (distance between two points) and we have to form an MST using them.

Given a connected, weighted, and undirected graph, a minimum spanning tree is a subset of edges that connect all vertices while the total weights of these edges are minimum among all possible subsets.

Kruskal's algorithm is a greedy algorithm for building a minimum spanning tree in a weighted and undirected graph.The algorithm operates by identifying the lowest-weighted edge that is not part of the MST. Then, if the nodes that belong to the edge are not connected, the edge is added to the MST. This process is repeated until all nodes are connected. Since we do not add an edge when its nodes are already connected, no cycles are formed.

First, we sort all the edges in increasing order of weight to prioritize adding the lowest-weighted edges first. We will continue to include edges in our MST until all nodes are connected*/