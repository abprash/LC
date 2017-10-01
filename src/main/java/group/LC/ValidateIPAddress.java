package group.LC;

import java.util.Arrays;

public class ValidateIPAddress {
	    public String validIPAddress(String IP) {
	        String neither = "Neither";
	        String permissibleChars = "1234567890abcdefABCDEF";
	        if(IP == null)
	            return neither;
	        if(IP.contains(".")){
	            if(IP.length() > 15)
	                return neither;
	            if(countSymbols('.',IP) != 3)
	                return neither;
	            //lets check if its split into 4 parts
	            String[] parts = IP.split("[.]");
	            //System.out.println(Arrays.toString(parts));
	            if(parts.length == 4){
	                for(String part : parts){
	                    //lets check if everything is digits
	                    for(int i=0; i<part.length(); i++){
	                        if(!Character.isDigit(part.charAt(i)))
	                            return neither;
	                        
	                    }
	                    if(part.length() == 0)
	                        return neither;
	                    int ipNumber = Integer.parseInt(part);
	                    //just find the number of leading zeroes
	                    if(ipNumber <= 9 && part.length() > 1 )
	                        return neither;
	                    if(ipNumber >= 10 && ipNumber <= 99 && part.length() > 2)
	                        return neither;
	                    if(ipNumber >= 100 && ipNumber <= 255 && part.length() > 3)
	                        return neither;
	                    if(ipNumber > 255){
	                        //its all ok
	                        return neither;
	                    }
	                }
	            }
	            else{
	                return neither;
	            }
	            return "IPv4";
	        }
	        else if(IP.contains(":")){
	            //lets see if it contains :
	            //
	            if(IP.length()>39)
	                return neither;
	            if(countSymbols(':',IP) != 7)
	                return neither;
	            String[] parts = IP.split(":");
	            if(parts.length == 8){
	                //ok
	                //now we need to check if each part is around the required set
	                for(String part : parts){
	                    if(part.length() == 0)
	                        return neither;
	                        if(part.length() <= 4){
	                            //we may have to examine this more
	                            //it can be 00, 000, 0 , 01 etc.
	                            //we check if it only contains numbers

	                        for(int i=0; i<part.length(); i++){
	                            char ch = part.charAt(i);
	                            if(!permissibleChars.contains(ch+""))
	                                return neither;
	                        }
	                    }
	                    else
	                        return neither;
	                }
	            }
	            else{
	                return neither;
	            }
	            return "IPv6";
	        }
	        else
	            return neither;
	    }
	    
	    public int countSymbols(char symbol, String s){
	        int counter = 0;
	        for(int i=0; i<s.length(); i++){
	            if(s.charAt(i) == symbol)
	                counter++;
	        }
	        return counter;
	    }
    public static void main(String[] args){
    	System.out.println(new ValidateIPAddress().validIPAddress("172.16.254.1"));
    	System.out.println(new ValidateIPAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:73"));
    	System.out.println(Arrays.toString("2001:0db8:85a3:0:0:8A2E:0370:7334:".split(":")));
    }
}