package group.LC;

public class MyRandom {
	
	public static int getFirstRepeatingNumber(int[] arr ){
		if(arr == null || arr.length == 0)
			return Integer.MIN_VALUE;
		//try ORing everything, when the value does not change then return the number
		int ans = arr[0];
		for(int i=1; i<arr.length; i++){
			int temp = ans;
			ans &= arr[i];
			if(ans == temp)
				return arr[i];
		}
		return Integer.MIN_VALUE;
	}
	
	public static int getMaxNumberStoredInInteger(){
		int ans = 0;
		for(int i=0; i<(Integer.MAX_VALUE); i++){
			ans+=i;
		}
		return ans;
	}
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,8,9,10};
		System.out.println(getFirstRepeatingNumber(arr));
		System.out.println((long) Integer.MAX_VALUE*Integer.MAX_VALUE);
		System.out.println(getMaxNumberStoredInInteger());
	}
}
