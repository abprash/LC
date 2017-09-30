package group.LC;

import java.util.Objects;





public class NumberOfIslands {

	
	//*****************************CORRECT SOLUTION with BFS
	//take care in the conditions for exit
	
	public class Solution {
	    public int numIslands(char[][] grid) {
	        if(grid == null)
	            return 0;
	        int islandCounter = 0;
	        for(int i=0; i<grid.length; i++){
	            for(int j=0; j<grid[0].length; j++){
	                if(grid[i][j] == '1'){
	                    //start BFS
	                    //
	                    helper(i,j,grid);
	                    ++islandCounter;
	                }
	            }
	        }
	        return islandCounter;
	    }
	    
	    public void helper(int i, int j, char[][] grid){
	        if(i < 0 || j< 0 || i >=grid.length || j >=grid[0].length || grid[i][j] != '1') return;
	        grid[i][j] = '0';//we are doing this because this spot has been visited
	        helper(i-1,j, grid);
	        helper(i,j-1, grid);
	        helper(i+1,j, grid);
	        helper(i,j+1, grid);
	    }
	}
	
//***********************************************
	//********************************************
	//Wrong solution
	//but present just as a record
	//30/40 only passed
	// my iterative solution did not work
	//********************************************
    public int numIslands(char[][] grid) {
        HashMap<Coordinate, Integer> islandTracker = new HashMap<Coordinate,Integer>();
        if(grid == null)
            return 0;
        int islandCounter = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    System.out.println(islandTracker);
                    Coordinate temp = new Coordinate(i,j);
                    Coordinate temp1 = null, temp2 = null, temp3 = null, temp4 = null;
                    if(i-1 >= 0){
                        temp1 = new Coordinate(i-1, j);
                    }
                    if(i+1 < grid.length){
                        temp2 = new Coordinate(i+1, j);
                    }
                    if(j-1 >= 0){
                        temp3 = new Coordinate(i, j-1);
                    }
                    if(j+1 < grid[0].length){
                        temp4 = new Coordinate(i, j+1);
                    }
                    System.out.println(temp1+","+temp2+","+temp3+","+temp4);
                    if(islandTracker.containsKey(temp1) || islandTracker.containsKey(temp2) || islandTracker.containsKey(temp3) || islandTracker.containsKey(temp4)){
                        
                        //get that value and use that value
                        int islandNumber = 0;
                        if(islandNumber == 0 && islandTracker.containsKey(temp1))
                            islandNumber = islandTracker.get(temp1);
                        if(islandNumber == 0 && islandTracker.containsKey(temp2))
                            islandNumber = islandTracker.get(temp2);
                        if(islandNumber == 0 && islandTracker.containsKey(temp3))
                            islandNumber = islandTracker.get(temp3);
                        if(islandNumber == 0 && islandTracker.containsKey(temp4))
                            islandNumber = islandTracker.get(temp4);
                        
                        islandTracker.put(temp,islandNumber);
                        if(islandNumber > islandCounter)
                            islandCounter = islandNumber;
                    }
                    else{
                        islandCounter++;
                        islandTracker.put(temp,islandCounter);
                    }
                }
            }
        }
        return islandCounter;
    }
    
    class Coordinate{
        int x;
        int y;
        
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public String toString(){
            return "("+this.x+","+this.y+")";
        }
        
         @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Coordinate)) {
            return false;
        }
        Coordinate coordinate = (Coordinate) o;
        return this.x == coordinate.x &&
                Objects.equals(this.y, coordinate.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
    }
}