package not_understanding;

//https://leetcode.com/problems/mirror-reflection/description/
//https://leetcode.com/problems/mirror-reflection/discuss/146336/Java-solution-with-an-easy-to-understand-explanation

public class MirrorReflections {

    public int mirrorReflection(int p, int q) {
        int m = 1, n = 1;
        //m - number of room extensions
        //n is the number of light extensions (number of times light bounces)
        //basic principle is - keep going until mp = nq
        while( m*p != n*q){
            //take care to increment n instead of m
            n++;
            m = n*q/p;
        }
        //if the room extensions is even and light bounces is odd - then receptor 0 
        if(m%2 == 0 && n%2 == 1)
            return 0;
        if(m%2 == 1 && n%2 == 1)
            return 1;
        //if number of light bounces is odd - then it meets the receptor on left side which is 2
        if(m%2 == 1 && n%2 == 0)
            return 2;
        return -1;
    }
}