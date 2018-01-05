package group.LC2;

public class AddBinary {

	
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
		sb.append("ass");
		//sb.replace(0, 1, "x");
		sb.replace(2,3,"p");
		System.out.println(sb);
		String s = new String();
	}
	
    public String addBinary(String a, String b) {
        
    	
    	//start from the right most end and go left
        int carry = 0;
        int i = a.length()-1, j = b.length()-1;
        int d1 = 0, d2 = 0;
        String ans = "";
        while(i>=0 || j>=0){
            if(i >= 0)
                d1 = Character.getNumericValue(a.charAt(i));
            else
                d1 = 0;
            if(j >= 0)
                d2 = Character.getNumericValue(b.charAt(j));
            else
                d2 = 0;
            int sum = d1 + d2 + carry;
            if(sum == 3){
                carry = 1;
                ans = "1" + ans;
            }
            else if(sum == 2){
                carry = 1;
                ans = "0" + ans;
            }
            else if(sum == 1){
                carry = 0;
                ans = "1" + ans;
            }
            else{
                //sum == 0
                carry = 0;
                ans = "0" + ans;
            }
            i--;
            j--;
        }
        if(carry == 1)
            ans = "1" + ans;
        return ans;
    }
}