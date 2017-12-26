package group.LC2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

}


 /* Definition for undirected graph.*/
  class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
 
class Solution {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        return helper(map, node);
    }
    
    public UndirectedGraphNode helper(Map<Integer, UndirectedGraphNode> map, UndirectedGraphNode oldNode){
        //check if oldNode is null
        if(oldNode == null)
            return null;
        if(map.containsKey(oldNode.label))
            return map.get(oldNode.label); // this will return that particular node
        map.put(oldNode.label, new UndirectedGraphNode(oldNode.label));
        //now if it is not present
        //we iterate thro the neighbors
        for(int i = 0; i < oldNode.neighbors.size(); i++){
            map.get(oldNode.label).neighbors.add(helper(map, oldNode.neighbors.get(i)));
        }
        return map.get(oldNode.label);
    }
    
}