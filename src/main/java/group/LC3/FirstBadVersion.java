package group.LC3;

public class FirstBadVersion {

	
	//https://leetcode.com/problems/first-bad-version/discuss/71311/A-good-warning-to-me-to-use-start+(end-start)2-to-avoid-overflow

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


    public int firstBadVersion(int n) {
        int high = n, low = 1;
        //int mid = (high + low)/2;
        while(low <= high){
            if(low == high)
                return low;
            //this is important
            //(high + low)/2 can cause overflow
            //so instead use, low + (high-low)/2
            int mid = low + (high - low)/2;
            boolean res = isBadVersion(mid);
            if(res){
                //mid is bad
                //so it has to be in the first half
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        
        return isBadVersion(high) ? high : low;
            
    }
}