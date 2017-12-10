package group.LC2;

public class GraphValidTree {

}
//ACCEPTED SOLUTION
//****************************************************
class Solution {
    public boolean validTree(int n, int[][] edges) {
        //visited array - ints
        int[] visited = new int[n];
        //construct the adjacency list for the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; ++i) { adjList.add(new ArrayList<Integer>()); }
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        //if has cycle, will return false
        if (hasCycle(-1, 0, visited, adjList)) { 
            return false; 
        }  
        // not 1 single connected component
        for (int v: visited) { 
            if (v == 0)
                return false;  
        }  
        return true;
    }
    
    private boolean hasCycle(int pred, int vertex, int[] visited, List<List<Integer>> adjList) {
        visited[vertex] = 1;  // current vertex is being visited
        for (Integer succ: adjList.get(vertex)) {  // successors of current vertex
            if (succ != pred) {  // exclude current vertex's predecessor
                if (visited[succ] == 1) { return true; }  // back edge/loop detected!
                else if (visited[succ] == 0) {
                    if (hasCycle(vertex, succ, visited, adjList)) { return true; }
                }
            }
        }
        visited[vertex] = 2;
        return false;
    }
}


//*********************************
//tried a dfs with a visited array
//did not work fully
//28/41 test cases passed

class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        for(int i=0; i<edges.length; i++){
            if(!graph.containsKey(edges[i][0]))
                graph.put(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            if(!graph.containsKey(edges[i][1]))
                graph.put(edges[i][1], new ArrayList<>());
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        //now we should do a dfs with a visited array and check that there are no visited nodes
        int start = 0;
        return dfs(start, graph, visited);
        
    }
    
    public boolean dfs(int start, Map<Integer, List<Integer>> graph, boolean[] visited){
        if(!graph.containsKey(start))
            return false;
        if(visited[start])
            return false;//we have already visited this node
        else
            visited[start] = true;
        for(int i=0; i<graph.get(start).size(); i++){
            if(!dfs(graph.get(start).get(i), graph, visited))
                return false;
        }
        visited[start] = false;
        return true;
    }
}