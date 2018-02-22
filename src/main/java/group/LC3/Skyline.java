package group.LC;

public class Skyline {

	
	//************************BEAUTIFUL Solution
	
	
	class Solution {
	    public List<int[]> getSkyline(int[][] buildings) {
	        //initial validation
	        List<int[]> ans = new ArrayList<>();
	        List<int[]> heights = new ArrayList<>();
	        if(buildings == null || buildings.length == 0)
	            return ans;
	        for(int[] b : buildings){
	            //put the start point with a negative sign, so that we know how to differentiate it
	            heights.add(new int[]{b[0], -b[2]});
	            //end points of the building go in with the +ve sign
	            heights.add(new int[]{b[1], b[2]});
	        }
	        
	        //now sort them according to the start points
	        Collections.sort(heights, (a,b)->{
	            if(a[0] != b[0])
	                return a[0] - b[0];
	            return a[1] - b[1];
	        });
	        
	        //now create a priority queue to keep track of the max heights
	        //max heap
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
	        pq.offer(0);
	        int prev = 0;
	        for(int[] h : heights){
	            //now lets start processing
	            //if we encounter a start point, we consider it
	            if(h[1] < 0)
	                pq.offer(-h[1]);
	            //if its an end point we drop it from the pq
	            if(h[1] > 0)
	                pq.remove(h[1]);
	            
	            //now compare with the current height
	            int cur = pq.peek();
	            
	            if(cur != prev){
	                //update the prev
	                ans.add(new int[]{h[0], cur});
	                prev = cur;
	            }
	        }
	        return ans;
	        
	    }
	}
	
	
	
	
	
	//*******************************************DID not scale well when buildings had values like
	// Integer.MAX_VALUE
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> list = new ArrayList<>();
        if(buildings == null || buildings.length == 0)
            return list;
        //treat
        
        List<Integer> ans = new LinkedList<>();
        int[] ans = new int[buildings[buildings.length - 1][1]];
        int firstBuilding = buildings[0][0];
        int lastBuilding = buildings[buildings.length - 1][2];
        for(int i=0; i<buildings.length; i++){
            int[] row = buildings[i];
            int start = row[0];
            int end = row[1];
            int height = row[2];
            for(int j=start; j<end; j++){
                if( height > ans[j] ){
                    ans[j] = height;
                }
            }
        }
        
        //
        //System.out.println(Arrays.toString(ans));
        int currentHeight = Integer.MIN_VALUE;
        if(ans.length == 1){
            //simply add the one start and height
            list.add(new int[]{0, ans[0]});
        }
        for(int i=firstBuilding; i<ans.length-1; i++){
            // if(i == 15){
            //     System.out.println("currheight="+currentHeight+", ans[i]="+ans[i]);
            //     System.out.println(currentHeight < ans[i]);
            // }
            if(currentHeight == Integer.MIN_VALUE)
                currentHeight = ans[i];
            if(i==firstBuilding)
                list.add(new int[]{i, currentHeight});
            if(currentHeight > ans[i]){
                
                currentHeight = ans[i];
                list.add(new int[]{i, ans[i]});
            }
            else if(currentHeight < ans[i]){
                currentHeight = ans[i];
                
                list.add(new int[]{i, currentHeight});
            }
            
        }
        
        list.add(new int[]{ans.length,0});
        //for(int[] i : list)
            //System.out.println("-->"+Arrays.toString(i));
        return list;
    }
}