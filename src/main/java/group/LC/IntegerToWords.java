package group.LC;

public class IntegerToWords {

	class Solution {
		
		//**********************THIS IS AMAZINGGGGGGGGGGGGGGGGGG
	    
	    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",       "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

	    public String numberToWords(int num) {
	        if(num == 0)
	            return "Zero";
	        int i=0;
	        String ans = new String();
	        while(num > 0){
	            if(num % 1000 != 0){
	                //we neeed to keep appending to the old ans
	                ans = helper(num % 1000) +THOUSANDS[i]+ " "+ans;
	            }
	            //divide by 1000
	            num /= 1000;
	            //move the pointer to handle the next nos
	            i++;
	        }
	        ans = ans.trim();
	        return ans;
	    }
	    
	    
	    public String helper(int num){
	        if(num == 0)
	            return "";
	        if(num < 20)
	            return LESS_THAN_20[num]+" ";
	        if(num < 100)
	            return TENS[num/10] +" "+ helper(num%10);
	        else{
	            //its more than 100
	            return LESS_THAN_20[num/100] +" Hundred " + helper(num % 100) ;
	        }
	        
	    }
	}
	
	
	
	//ABSOLUTE DISASTER... DONT EVER TRY THIS
	//*****************************************
	
	
	
	
    int[] numbers = {1000000000,100000000, 1000000, 
                        100000, 1000, 100, 1};
       int[] tens = {90,80,70,60,50,40,30,20,10};
       int[] ones = {9,8,7,6,5,4,3,2,1};
       String[] tensWords = {"Ten", "Twenty","Thirty","Forty","Fifty", "Sixty","Seventy", "Eighty","Ninety"};
       
       String[] onesWords = {"One", "Two","Three","Four", "Five", "Six","Seven", "Eight", "Nine"};
       String[] words = {"x Billion", "x Hundred Million", "x Million",
                        "x Hundred Thousand", "x Thousand",
                        "x Hundred", "x One"};
   public String numberToWords(int num) {
       if(num == 0)
           return "Zero";
       if(num <20 && num > 10)
           return bet1020(num);
       int copy = num, counter = 0;
       String ans = new String();
       while(num > 0){
           int times = 0;
           while(num >= numbers[counter]){
               times++;
               num-=numbers[counter];
           }
           //System.out.println(ans);
           //int prevTimes = times;
           int multiplier = numbers[counter]; 
           //put the prev number to it
           if(times > 0){
               //get the particular number now
               String currWord = words[counter];
               
               if(multiplier < 100){
                   //it has to be in 10s or 1s
                   if(multiplier == 1){
                       //get the corresponding times
                       currWord = onesWords[times - 1];
                   }
                   if(multiplier == 10){
                        currWord = tensWords[times - 1];
                   }
               }
               else{
                   if(times > 20)
                       currWord = currWord.replace("x", wordify(times));
                   else if (times < 20 && times > 10)
                       currWord = currWord.replace("x", bet1020(times));
                   else
                       currWord = currWord.replace("x", Integer.toString(times));
               }
               ans+=currWord+" ";
           }
           if(counter >= numbers.length-1)
               break;
           counter++;
           
       }
       //do a final parse where you subs with the corresponding elements
       for(int i=1; i<=9;i++){
           String toFind = Integer.toString(i)+" ";
           ans = ans.replace(toFind, onesWords[i-1]+" ");
       }
       
       //check for multiple occurrences of Thousand or Million
       int tCount = 0, mCount = 0, ix1=0, ix2 = 0;
       String[] split = ans.split(" ");
       for(int i=0; i<split.length; i++){
           if(split[i].equals("Million") ){
               if(mCount == 0)
                   ix1 = i;
               mCount++;
           }
           if(split[i].equals("Thousand") ){
               if(tCount == 0)
                   ix2 = i;
               tCount++;
           }
       }
       if(tCount == 2)
           split[ix2] = "";
       if(mCount == 2)
           split[ix1] = "";
       StringBuilder ans2 = new StringBuilder();
       for(int i=0; i<split.length; i++){
           if(i< (split.length - 1))
               ans2.append(split[i]+" ");
           else
               ans2.append(split[i]);
       }
       ans = ans2.toString();
       ans = ans.replaceAll("  ", " ");
       return ans; 
   }
   public String bet1020(int num){
       int[] nums = {11,12,13,14,15,16,17,18,19};
       String ans = new String();
       String[] numWords = {"Eleven","Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
       for(int i=0; i<nums.length; i++){
           if(nums[i] == num){
               ans = numWords[i];
               break;
           }
       }
       return ans;
   }
   public String wordify(int num) {
       System.out.println(num);
		// num has to be less than 100
		if (num < 100) {
			int i = 0;
			while (num > 10){
				if(i >tens.length-1)
					break;
				if(num >= tens[i]){
					num -= tens[i];
					break;
				}
				else
					i++;
			}
			// get the tens word now
			String w1 = tensWords[tensWords.length - i - 1];
			i = 0;
			while (num > 0){
				if(i > ones.length-1)
					break;
				if(num >= ones[i]){
					num -= ones[i];
					break;
				}
				else
					i++;
			}
           
			String w2 = onesWords[onesWords.length - i -1 ];
			return w1 + " " + w2;
		} else
			return null;

	}
}