package group.LC2;

public class LonelyPixel2 {

//https://leetcode.com/problems/lonely-pixel-ii/discuss/100216/Verbose-Java-O(m*n)-Solution-HashMap
	
    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length;
        if (m == 0) return 0;
        int n = picture[0].length;
        if (n == 0) return 0;
        
        Map<String, Integer> map = new HashMap<>();
        int[] colCount = new int[n];
        
        for (int i = 0; i < m; i++) {
            String key = scanRow(picture, i, N, colCount);
            if (key.length() != 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        int result = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == N) {
                for (int j = 0; j < n; j++) {
                    if (key.charAt(j) == 'B' && colCount[j] == N) {
                        result += N;
                    }
                }
            }
        }
        
        return result;
    }
    
    private String scanRow(char[][] picture, int row, int target, int[] colCount) {
        int n = picture[0].length;
        int rowCount = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int j = 0; j < n; j++) {
            if (picture[row][j] == 'B') {
                rowCount++;
                colCount[j]++;
            }
            sb.append(picture[row][j]);
        }
        
        if (rowCount == target) return sb.toString();
        return "";
    }
}
//still not correct
//not a great approach
//100/118 cases passed..
class Solution {
    Set<Integer> cols = new HashSet<>();
    public int findBlackPixel(char[][] picture, int N) {
     if(picture == null || picture.length == 0)
            return 0;
        int ans = 0, col = 0, rowCount = 0;
        List<Integer> colPositions = new ArrayList<>();
        
        for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[0].length; j++){
                //check each row
                //if each row has only one pixel, then check that column, 
                //if both return true - yes lonely
                //else no
                if(picture[i][j] == 'B' && !cols.contains(j)){
                    colPositions.add(j);
                    rowCount++;
                }
            }
            if(rowCount == N){
                //check that col
                ans += isLonelyCol(picture, colPositions, N);
            }
            //reset the positions
            colPositions = new ArrayList<>();
            rowCount = 0;
        }
        return ans;
    }
    
    public int isLonelyCol(char[][] picture, List<Integer> list, int N){
        int colCount = 0;
        int res = 0;
        for(int col : list){
            for(int i=0; i<picture.length; i++){
                if(picture[i][col] == 'B')
                    colCount++;
            }
        
            if(colCount == N){
                res += N;
                cols.add(col);
            }
            colCount = 0;
        }
        return res;
    }
}