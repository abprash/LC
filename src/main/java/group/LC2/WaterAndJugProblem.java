package group.LC2;

public class WaterAndJugProblem {

}

//GCD Math problem


class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        
        if(x + y < z)
            return false;
        
        if(x == y || y == z || x+y == z)
            return true;
    
       return z%GCD(x, y) == 0;
}

    public int GCD(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}