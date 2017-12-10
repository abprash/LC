package group.LC2;

public class GraphValidTree {

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