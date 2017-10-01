package group.LC;

import java.util.Arrays;

public class ValidateIPAddress {
    public static String validIPAddress(String IP) {
    	String neither = "Neither";
        if(IP == null)
            return neither;
        if(IP.contains(".")){
            //lets check if its split into 4 parts
            String[] parts = IP.split("[.]");
            System.out.println(Arrays.toString(parts));
            if(parts.length == 4){
                for(String part : parts){
                    //lets check if everything is digits
                    for(int i=0; i<part.length(); i++){
                        if(!Character.isDigit(part.charAt(i)))
                            return neither+"7";
                        
                    }
                    int ipNumber = Integer.parseInt(part);
                    //just find the number of leading zeroes
                    if(Integer.numberOfLeadingZeros(Integer.parseInt(part)) > 1)
                        return neither;
                    if(ipNumber > 255){
                        //its all ok
                        return neither+"5";
                    }
                }
            }
            else{
                return neither+"1";
            }
            return "IPv4";
        }
        else if(IP.contains(":")){
            //lets see if it contains :
            //
            
        }
        else
            return neither+"3";
    }
    
    public static void main(String[] args){
    	System.out.println(validIPAddress("172.16.254.1"));
    }
}