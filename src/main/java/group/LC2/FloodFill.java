package group.LC2;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //dfs
        if(image == null || image.length == 0)
            return image;
        boolean[][] visited = new boolean[image.length][image[0].length];
        helper(image, visited, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    public void helper(int[][] image, boolean[][] visited, int sr, int sc, int newColor, int oldColor){
        //check for the starr coords
        //check if visited
        //check if the oldColor matches
        if(sr > image.length-1 || sc >image[0].length-1 || sr < 0 || sc < 0 ||visited[sr][sc] || oldColor != image[sr][sc])
            return;
        visited[sr][sc] = true;
        //chage color at the start point
        image[sr][sc] = newColor;
        
        helper(image, visited, sr+1, sc, newColor, oldColor);
        helper(image, visited, sr, sc-1, newColor, oldColor);
        helper(image, visited, sr-1, sc, newColor, oldColor);
        helper(image, visited, sr, sc+1, newColor, oldColor);
    }
}