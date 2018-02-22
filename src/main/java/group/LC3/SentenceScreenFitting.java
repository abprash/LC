package group.LC;

public class SentenceScreenFitting {

	public static void main(String[] args){
		String s = "afd";
		s.split("s");
	}
}

//*******************************Ok solution. Works well, but TLE on leetcode. Should improve this.
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        //initial validation
        
        //char[][] store = new char[rows][cols];
        int pointer = 0;
        int linePointer = 0, wordPointer = 0;
        int ans = 0;
        int[] lines = new int[rows];
        Arrays.fill(lines, cols);
        //System.out.println(Arrays.toString(lines));
        int[] lengths = new int[sentence.length];
        for(int i =0; i<sentence.length; i++)
            lengths[i] = sentence[i].length();
        //System.out.println(Arrays.toString(lengths));
        //now start incrementing
        int i = 0;
        while(linePointer < lines.length){
            //int curLine = lines[linePointer];
            
            while(lengths[i] <= lines[linePointer]){
                lines[linePointer] -= lengths[i];
                if(lines[linePointer] > 0)
                    lines[linePointer]--;
                if((i+1) < lengths.length)
                    i++;
                else{
                    i=0;
                    ans++;
                }
            }
            if(lengths[i] > lines[linePointer]){
                linePointer++;
            }
        }
        return ans;
    }
}