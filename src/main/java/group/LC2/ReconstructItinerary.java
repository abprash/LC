package group.LC2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

}

//ACCEPTED DFS Solution
//*************************************
class Solution {
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            //priority queue is min heap by default
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        //we start dfs-ing from JFK
        dfs("JFK");
        return path;
    }

    public void dfs(String place){
        //check if its in the map
        if(!flights.containsKey(place)){
            path.addFirst(place);
            return;
        }
        PriorityQueue<String> pqueue = flights.get(place);
        while(pqueue != null && !pqueue.isEmpty()){
            //we dfs further down
            dfs(pqueue.poll());
        }
        path.addFirst(place);
    }
}

//*******************not good solution .... not fully correct
//passes 18/80 test cases

class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> ans = new ArrayList<>();
        if(tickets == null || tickets.length == 0)
            return ans;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        //have a priority queue ready to put into the graph
        
        //start loading the graph
        for(String[] ticket : tickets){
            if(!graph.containsKey(ticket[0])){
                PriorityQueue<String> pq = new PriorityQueue<>((x,y) ->  x.compareTo(y));
                graph.put(ticket[0], pq);
            }
            graph.get(ticket[0]).add(ticket[1]);
        }
        
        //now we start putting our ans
        String key = "JFK";
        ans.add(key);
        while(graph.containsKey(key) && !graph.get(key).isEmpty()){
            key = graph.get(key).poll();
            ans.add(key);
        }
        //System.out.println(graph);
        return ans;
    }
}