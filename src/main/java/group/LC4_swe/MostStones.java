package group.LC4_swe;

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/

public class MostStones {


    int count = 0;

    public int removeStones(int[][] stones) {
        //this problem uses Union Find algorithm
        //i guess from the submissions, even DFS works.

        //validate the input
        if(stones == null || stones.length <= 1)
            return 0;
        count = stones.length;
        Map<String, String> map = new HashMap<>();
        //create the component map
        for(int[] stone : stones){
            String s = stone[0]+" " + stone[1];
            map.put(s,s);
        }
        //we create the above map for faster lookups

        //now we start the  union find algo
        for(int[] stone : stones){
            //we get one stone
            String s = stone[0]+" "+stone[1];
            //now we get stone 2 from the list
            for(int[] stone2 : stones){
                //check if they have either the same row or column connection...
                if(stone[0] == stone2[0] || stone[1] == stone2[1]){
                    //we will be checking inside if they are not the same stone
                    union(map, stone, stone2);
                }
            }
        }
        return stones.length - count;
    }

    public void union(Map<String, String> map, int[] s1, int[] s2){
        String stone1 = s1[0]+" "+s1[1];
        String stone2 = s2[0]+" "+s2[1];
        //now we need to find the parents for the stones - see how they are connected
        String r1 = find(map, stone1);
        String r2 = find(map, stone2);
        if(r1.equals(r2)){
            return;//they are the same stone (i think, so we do not consider them as connected components)
        }
        //we update the map now
        map.put(r1,r2);
        //we increase the number of components now
        count--;

    }

    public String find(Map<String, String> map, String s){
        //we are to find the parent of s1
        if(!map.get(s).equals(s)){
            //if they do not have the same parent yet, then, we start finding the parent for s
            map.put(s, find(map, map.get(s)));
        }
        return map.get(s);
    }
}