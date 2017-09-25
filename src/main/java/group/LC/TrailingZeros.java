package group.LC;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrailingZeros {
	//500/502 test cases passed
	//the rest - time limit is exceeded
	
	public static int trailingZeroes(int n) {
        //we just have to count the number of 2s, 5s and 10s in the product
        int count = 0;
        int res = 1;
        for(int i=1; i<=n ; i+=2){
            if(i%5==0){
                //int temp = i;
                int q = i/5;
                count+=q;
            }
            
        }
        return  count;
    }
	
	public static void main(String[] args){
		///System.out.println(trailingZeroes(1808548329));
		//pass in a new comparator as part of the constructor
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b){
			return b.compareTo(a);
			}
		});
		Comparator<Integer> comp = (Integer n1, Integer n2) -> n1.compareTo(n2);
		pq.add(3);
		pq.add(3);
		pq.offer(3);
		pq.offer(2);
		//1,5,6,4
		pq.offer(1);
		pq.offer(5);
		pq.offer(6);
		pq.offer(4);
		//System.out.println(pq.poll());
		//get the number of k
		int k = 2;
		for(int i=0; i<k-1; i++)
			pq.poll();
		System.out.println(pq.poll());
	}
	
	//accepted right solution
	//*******************************
	public static int trailingZeroes2(int n) {
        //we just have to count the number of 5s
        int res=0;
        while(n > 0){
            n/=5;
            res+=n;
        }
        return res;
    }
	
	
}
