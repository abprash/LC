package group.LC;

public class Atoi {

	///https://leetcode.com/problems/string-to-integer-atoi/description/
	
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
   		return 0;
	   	str = str.trim();
	   	char firstChar = str.charAt(0);
	   	int sign = 1, start = 0, len = str.length();
	   	double sum = 0;
	   	if (firstChar == '+') {
	   		sign = 1;
	   		start++;
	   	} else if (firstChar == '-') {
	   		sign = -1;
	   		start++;
	   	}
	   	for (int i = start; i < len; i++) {
	   		if (!Character.isDigit(str.charAt(i)))
   			return (int) sum * sign;
   		sum = sum * 10 + str.charAt(i) - '0';
   		if (sign == 1 && sum > Integer.MAX_VALUE)
   			return Integer.MAX_VALUE;
   		if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
   			return Integer.MIN_VALUE;
   		}

   		return (int) sum * sign;   
    }
}
