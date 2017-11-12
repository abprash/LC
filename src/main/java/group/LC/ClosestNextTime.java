package group.LC;

/*
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Input: "19:34"
Output: "19:39"


Input: "23:59"
Output: "22:22"
 * 
*/
public class ClosestNextTime {

	    public String nextClosestTime(String time) {
	        //initial validation
	        if(time == null || time.equals(""))
	            return time;
	        if(!time.contains(":"))
	            return time;
	        //now we take the mins alone and check if we will be able to make it
	        String[] hhmm = time.split(":");
	        int mins = Integer.parseInt(hhmm[1]);
	        int hours = Integer.parseInt(hhmm[0]);
	        String ans = new String();
	        //put all the digits into a set
	        Set<Integer> table = new HashSet<>();
	        
	            //put every digit into the table
	        table.add(Character.getNumericValue(hhmm[0].charAt(0)));
	        table.add(Character.getNumericValue(hhmm[0].charAt(1)));
	        table.add(Character.getNumericValue(hhmm[1].charAt(0)));
	        table.add(Character.getNumericValue(hhmm[1].charAt(1)));
	        int finalMM = Integer.MIN_VALUE, finalHH = hours;
	        //lets go from m+1 to 59
	        for(int i=mins+1; i<=59; i++){
	            String temp = Integer.toString(i);
	            if(temp.length() < 2)
	                temp = "0" + temp;
	            if(checkIfTimeValid(temp, table)){
	                finalMM = i;
	                break;
	            }
	        }
	        if(finalMM != Integer.MIN_VALUE){
	            //finalHH + : + finalMM
	            String p1 = null, p2 = null;
	            if(finalMM < 10)
	                p2 = "0" + Integer.toString(finalMM);
	            else
	                p2 = Integer.toString(finalMM);
	            p1 = hhmm[0] + ":";
	            return p1+p2;
	        }
	        
	        //we still need to get the valid mins
	        for(int i=0; i<=mins; i++){
	            String temp = Integer.toString(i);
	            if(temp.length() < 2)
	                temp = "0" + temp;
	             if(checkIfTimeValid(temp, table)){
	                finalMM = i;
	                break;
	            }
	        }
	        
	        //now we should have got the mins
	        //now we need the hours
	        for(int i=hours+1; i<=23; i++){
	            String temp = Integer.toString(i);
	            if(temp.length() < 2)
	                temp = "0" + temp;
	            if(checkIfTimeValid(temp, table)){
	                finalHH = i;
	                break;
	            }
	        }
	        if(finalHH != hours){
	            //return the new time
	            //finalHH + : + finalMM
	            String p1 = null, p2 = null;
	            if(finalMM < 10)
	                p2 = "0" + Integer.toString(finalMM);
	            else
	                p2 = Integer.toString(finalMM);
	            String temp = null;
	            if(finalHH < 10)
	                temp = "0" + Integer.toString(finalHH);
	            else
	                temp =  Integer.toString(finalHH);
	            p1 = temp + ":";
	            return p1+p2;
	        }
	        //we still need to get the valid mins
	        for(int i=0; i<=hours; i++){
	            String temp = Integer.toString(i);
	            if(temp.length() < 2)
	                temp = "0" + temp;
	             if(checkIfTimeValid(temp, table)){
	                finalHH = i;
	                break;
	            }
	        }
	        
	        String p1 = null, p2 = null;
	        if(finalMM < 10)
	                p2 = "0" + Integer.toString(finalMM);
	            else
	                p2 = Integer.toString(finalMM);
	        String temp = null;
	        if(finalHH < 10)
	                temp = "0" + Integer.toString(finalHH);
	            else
	                temp =  Integer.toString(finalHH);
	        p1 = temp + ":";
	        return p1+p2;
	        //return the new time
	        //finalHH + : + finalMM
	    }
	    
	    public boolean checkIfTimeValid(String time, Set<Integer> table){
	        //should be 2 digit
	        //System.out.println("**"+time);
	        if(time != null && time.length() == 2){
	            int dig1 = Character.getNumericValue(time.charAt(0));
	            int dig2 = Character.getNumericValue(time.charAt(1));
	            if(table.contains(dig1) && table.contains(dig2))
	                return true;
	            else
	                return false;
	        }
	        return false;
	    }
	    
//	     public String makeTimeValid(int hh, int mm){
	        
//	     }
}