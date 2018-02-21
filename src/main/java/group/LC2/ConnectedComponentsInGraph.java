package group.LC2;

import java.util.*;

public class ConnectedComponentsInGraph {
	
//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77578/Java-concise-DFS
    
	public int countComponents(int n, int[][] edges) {
        //this can be done as a graph problem - using hashmap
        //do a dfs
        if(n == 0 || edges == null || edges.length == 0)
            return n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            int start = edge[0];
            int end = edge[1];
            
            
            if(map.containsKey(start))
                map.get(start).add(end);
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(end);
                map.put(start, temp);
            }
            
            if(map.containsKey(end))
                map.get(end).add(start);
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                map.put(end, temp);
            }
        }
        int res = 0;
        boolean[] visited = new boolean[n];
        //use the map to do dfs
        for(Map.Entry<Integer, List<Integer>> e : map.entrySet()){
            if(!visited[e.getKey()]){
                dfs(e.getKey(), map, visited);
                res++;
            }
        }
        for(int i=0; i<n; i++){
            if(!visited[i])
                res++;
        }
        return res;
    }
    
    public void dfs(int startNode, Map<Integer, List<Integer>> map, boolean[] visited){
        //check if node is visited
        if(visited[startNode])
            return;
        visited[startNode] = true;
        if(!map.containsKey(startNode))
            return;
        List<Integer> neighbors = map.get(startNode);
        for(int n : neighbors){
            dfs(n, map, visited);
        }
    }
    
}