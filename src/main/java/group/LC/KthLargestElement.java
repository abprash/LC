package group.LC;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
	
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b){
			return b.compareTo(a);
			}
		});
		//Comparator<Integer> comp = (Integer n1, Integer n2) -> n1.compareTo(n2);
		
        //add all elements to the PQ
        for(int num : nums)
            pq.add(num);
		//get the number of k
		//int k = 2;
		for(int i=0; i<k-1; i++)
			pq.poll();
        return pq.poll();
    }

}

