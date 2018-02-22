package group.LC;

public class PowerOfFour {

	//basically the number will have only 1 bit set and even number of zeros
	public boolean isPowerOfFour(int num){
		return (Integer.bitCount(num) == 1) && (Integer.toBinaryString(num).length()%2==1);
	}
}
