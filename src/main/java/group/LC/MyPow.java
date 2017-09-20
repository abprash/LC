package group.LC;

public class MyPow {

	
	//********************
	//VERY SHITTY SOLUTION
	//&(**********************
	 public double myPow(double x, int n) {
	        //check values of x and n
	        if(n == 0)
	            return 1;
	        if(x == 1)
	            return 1;
	        if(x == -1)
	            return Math.abs(n) % 2==0 ? 1 :-1;
	        double res = x;
	        if(n > 0.00001){
	            for(int i=0; i<n-1; i++){
	                res = res * x;
	                if(Math.abs(res) <= 0.00001)
	                    return 0;
	            }
	        }
	        else if(n<0){
	            //n < 0
	            for(int i=0; i<Math.abs(n-1); i++){
	                res = res / x;
	                if(Math.abs(res) <= 0.00001)
	                    return 0;
	            }
	        }
	        return res;
	    }
	 
	 //************Putting the  actual good solution
	 //pow(x,n)
	 //OKOK solution
	 
	 public double myPow2(double x, double n){
		 //base case
		 if(n == 0)	return 1;
		 if(n%2 == 0)
			 return myPow2(x,n/2)*myPow2(x,n/2);
		 else
			 return x * myPow2(x,n/2)*myPow2(x,n/2);
		 
	 }
	 
	 //optimized - excellent solution
	 public double myPow3(double x, int n) {
	        if( n == 0)
	       return 1;
	    double temp = myPow3(x, n/2);       
	    if (n%2 == 0)
	        return temp*temp;
	    else
	    {
	        if(n > 0)
	            return x*temp*temp;
	        else
	            return (temp*temp)/x;
	    }
	    }
}
