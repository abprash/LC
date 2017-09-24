package group.LC;

public class TrailingZeros {
	//500/502 test cases passed
	//the rest - time limit is exceeded
	
	public int trailingZeroes(int n) {
        //we just have to count the number of 2s, 5s and 10s in the product
        int count = 0;
        int res = 1;
        for(int i=1; i<=n ; i++){
            if(i%5==0){
                int temp = i;
                while(temp%5==0){
                    count+=1;
                    temp = temp/5;
                }
            }
            
        }
        return  count;
    }
}
