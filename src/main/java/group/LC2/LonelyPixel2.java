package group.LC2;

public class LonelyPixel2 {

//https://leetcode.com/problems/lonely-pixel-ii/discuss/100216/Verbose-Java-O(m*n)-Solution-HashMap
	
	class Solution {
	    Map<String, Integer> map = new HashMap<>();
	    public int findBlackPixel(char[][] picture, int N) {
	        if(picture == null || picture.length == 0)
	            return 0;
	        int res = 0;
	        int[] colCount = new int[picture[0].length];
	        //use a hashmap to store the signature and keep going
	        for(int i=0; i<picture.length; i++){
	            String key = scanRow(picture, i, N, colCount);
	            if(key.length() >= 1){
	                if(map.containsKey(key))
	                    map.put(key, map.get(key)+1);
	                else map.put(key, 1);
	            }
	        }
	        //System.out.println(map);
	        //System.out.println(Arrays.toString(colCount));
	        
	        //now double check the cols just in case
	        
	        for(Map.Entry<String, Integer> e : map.entrySet()){
	            //check those cols alone
	            if(e.getValue() == N){
	                //count the num of B's
	                String key = e.getKey();
	                for(int i=0; i<colCount.length; i++){
	                    //just see if they match
	                    if(colCount[i] == N && key.charAt(i) == 'B')
	                        res += N;
	                }
	            }
	        }

	        return res;
	    }
	    
	    public String scanRow(char[][] picture, int row, int N, int[] colCount){
	        StringBuilder sb = new StringBuilder();
	        int rowCount = 0;
	        for(int i=0; i<picture[0].length; i++){
	            sb.append(picture[row][i]);
	            if(picture[row][i] == 'B'){
	                colCount[i]++;
	                rowCount++;
	            }
	        }
	        if(rowCount == N)
	            return sb.toString();
	        else
	            return "";
	    }
	}
}