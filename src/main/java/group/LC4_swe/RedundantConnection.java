package group.LC4_swe;

//https://leetcode.com/problems/redundant-connection/description/
//https://leetcode.com/problems/redundant-connection/discuss/123819/Logical-Thinking-with-Java-Code-Beats-96.02
// Referred this also - https://www.youtube.com/watch?v=0jNmHPfA_yE

public class RedundantConnection {


    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0)
            return new int[0];
        //create a disjoint set
        DisjointSet ds = new DisjointSet(edges.length+1);
        for(int[] edge : edges){
            if(ds.find(edge[0]) == ds.find(edge[1])){
                //both the nodes have the same parent, thus this is a redundant node
                return edge;
            }
            else{
                ds.union(edge[0], edge[1]);
            }
        }
        return null;
    }
}

class DisjointSet{
    int[] parent;
    
    public DisjointSet(int n){
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    
    public int find(int x){
        //we need to keep going up until we find the parent of the current node
        //should break when we find the parent
        while(parent[x] != x){
            x = parent[x];//keep replacing x with the parent. (essentially going up in the graph)
        }
        return x;
    }
    
    public void union(int a, int b){
        //find the parent of nodes a and b, and then unite them
        int rootA = find(a);
        int rootB = find(b);
        parent[rootA] = rootB;
    }
}
