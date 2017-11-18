package group.LC;

public class MedianInTwoSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       
        //now if both are non null
        //we will be considering for both odd and even length arrays 
        int l1 = (nums1.length + nums2.length + 1) /2;
        int l2 = (nums1.length + nums2.length + 2) /2;
        return (getMedian(nums1, 0, nums2, 0, l1) + getMedian(nums1, 0, nums2, 0, l2))/2.0;
}
    
    public double getMedian(int[] A, int startA, int[] B, int startB, int k){
        
        if(startA > A.length - 1)
            return B[startB + k - 1];
        if(startB > B.length - 1)
            return A[startA + k - 1];
        
        //if there is only one element in the array
        if(k == 1)
            return Math.min(A[startA], B[startB]);
        
        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if(startA + k/2 -1  < A.length ) aMid = A[startA + k/2 - 1];
        if(startB + k/2 -1  < B.length ) bMid = B[startB + k/2 - 1];
        
        if(aMid < bMid)
            return getMedian(A, startA + k/2, B, startB      , k - k/2);// checking aRight + bLeft
        else
            return getMedian(A, startA      , B, startB + k/2, k - k/2); // checking next bRight + aLeft
    }
}