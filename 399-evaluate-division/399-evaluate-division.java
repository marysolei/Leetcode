class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        HashMap<String , HashMap<String, Double>> graph = new HashMap<>();
        //build the graph from equation
        for(int i=0; i< equations.size() ; i++) {
            List<String> curr = equations.get(i);
            String a = curr.get(0); 
            String b = curr.get(1);
            double value = values[i];
            
            if(!graph.containsKey(a)) graph.put(a, new HashMap<String, Double>());
            if(!graph.containsKey(b)) graph.put(b, new HashMap<String, Double>());
            graph.get(a).put(b,value);
            graph.get(b).put(a, 1/value);  
        }
        //find each query using dfs
        double[] results = new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            if(!graph.containsKey(a) || !graph.containsKey(b)){
                results[i] = -1.0;
            }else if(a ==b){
                results[i] = 1.0;
            }else {
                HashSet<String> visited = new HashSet<>();
                results[i]= backtrackEvaluate(graph, a,b, 1, visited);
            }
        }
        return results;
    }
    private double backtrackEvaluate(HashMap<String, HashMap<String, Double>> graph, String currNode, String targetNode, double accProduct, Set<String> visited) {

        // mark the visit
        visited.add(currNode);
        double ret = -1.0;

        Map<String, Double> neighbors = graph.get(currNode);
        if (neighbors.containsKey(targetNode))
            ret = accProduct * neighbors.get(targetNode);
        else {
            for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nextNode = pair.getKey();
                if (visited.contains(nextNode))
                    continue;
                ret = backtrackEvaluate(graph, nextNode, targetNode,
                        accProduct * pair.getValue(), visited);
                if (ret != -1.0)
                    break;
            }
        }

        // unmark the visit, for the next backtracking
        visited.remove(currNode);
        return ret;
    }
}
/*From Leetcode: We could reformulate the equations with the graph data structure, where each variable can be 
represented as a node in the graph, and the division relationship between variables can be modeled as edge with 
direction and weight.To evaluate a query (e.g. a/c=?) is equivalent to performing two tasks on the graph: 1)find if  there exists a path between the two entities. 2)if so, calculate the cumulative products along the paths.

More precisely, we can reinterpret the problem as "given two nodes, we are asked to check if there exists a path 
between them. If so, we should return the cumulative products along the path as the result.
Alg:
Step 1). we build the graph out of the list of input equations.Each equation corresponds to two edges in the graph.

Step 2). once the graph is built, we then can evaluate the query one by one.The evaluation of the query is done via
searching the path between the given two variables.
Other than the above searching operation, we need to handle two exceptional cases as follows:
Case 1): if either of the nodes does not exist in the graph, i.e. the variables did not appear in any of the input equations, then we can assert that no path exists.

Case 2): if the origin and the destination are the same node, i.e. a/a we can assume that there exists an invisible 
self-loop path for each node and the result is one.
*/