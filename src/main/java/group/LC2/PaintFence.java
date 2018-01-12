package group.LC2;

public class PaintFence {


    public int numWays(int n, int k) {
        if(n == 0)
            return 0;
        if(n == 1)
            return k;
        //now calc the same and diff color counts for 2 fences
        int same = k;
        int diff = k*(k-1);
        for(int i=3; i<=n; i++){
            int tempDiffColorCounts = diff;
            //calc the diff color count with the addition of a new fence
            diff = (diff + same) * (k-1);
            //have same store the prev diff color counts
            same = tempDiffColorCounts;
        }
        return same + diff;
    }
}