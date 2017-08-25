/**
 * 
 */
package group.LC;

/**
 * @author abprashanth
 *
 *Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it 
 *moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
The output should be true or false representing whether the robot makes a circle.
 */
public class JudgeCircle {
	
	public static boolean judgeCircle(String moves) {
        //there should be n equal number of R and L pairs, and/or U and D pairs
        int upDown = 0;
        int leftRight = 0;
        if(moves == null)
            return true;
        if(moves == "" || moves == " ")
            return false;
        for(int i=0; i<moves.length(); i++){
            char c = moves.charAt(i);
            //System.out.println(c);
            if(c == 'U' || c == 'u')
                upDown++;
            if(c=='D' || c == 'd')
                upDown--;
            if(c == 'R' || c == 'r')
                leftRight++;
            if(c=='L' || c == 'l')
                leftRight--;
        }
        if(upDown+leftRight == 0)
            return true;
        else
            return false;
    }
	
	public static void main(String[] args){
		judgeCircle("URLDDUUUDLR");
	}

}
