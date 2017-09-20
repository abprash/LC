package group.LC;

public class FindDuplicate {
	
	
	/*
	 * *
	 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args){
		int[] nums = {3813,8229,15919,16146,19061,26146,11849,28124,22288,19711,6050,27586,25607,4226,16366,28307,19954,6764,27118,17464,21581,6627,9221,26702,15971,24298,23098,21967,26853,23008,14622,27549,1590,9776,8537,22716,23037,12719,19716,8266,9230,6897,22429,21539,18852,3470,8434,10895,5146,14841,22687,29176,23650,29111,6678,17754,23144,7501,2303,26700,24078,29702,6072,22366,5340,19726,16081,4594,2514,12237,12857,21376,4075,4867,25623,14322,5627,19661,29576,9735,17093,21938,11584,29387,27764,13154,28581,6634,29503,17074,7536,21327,20982,26266,25593,6201,26210,13506,21860,22228,12345,8854,18668,28127,815,11424,29167,8703,11327,16182,28450,12293,23438,18703,16766,13554,3268,19702,25420,19723,14355,9040,18287,29064,1387,29082,29847,16443,5329,29895,19808,10759,25715,15645,17198,23159,18070,22372,26576,20985,26907,17000,10087,18108,15584,7404,19051,12314,15799,29228,12743,23402,23869,11007,11543,931,5000,10879,24942,26556,19238,26741,24944,29866,13096,19510,4865,12506,7463,11430,17993,2896,5621,1974,27184,6974,22256,8256,16731,23503,26335,20273,8608,3909,23546,13144,16979,4572,21991,14783,4629,28087,21875,18592,11179,13478,24519,25320,13119,19803,2934,8173,5394,22077,29669,24426,14468};
		System.out.println(findDuplicate(nums));
	}
	/*public static int findDuplicate(int[] nums) {
        //find the sum of the array (SArray)
        //find the min and max numbers (min and max)
        //calc the sum from min to max (total = 1 to n)
        //subtract the sum from (SArray - total)
        
        if(nums == null)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int arraySum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            if(i == 0)
                sb.append(","+Integer.toString(nums[i])+",");
            else
                sb.append(Integer.toString(nums[i])+",");
        }
        int total = 0, ans = 0;
        String sbString = new String(sb);
        System.out.println(sbString);
        for(int i=0; i< nums.length; i++){
            String temp = Integer.toString(nums[i]);
            String requiredString = ","+temp+",";
            int pos = sbString.indexOf(requiredString);
            int pos2 = sbString.indexOf(requiredString,pos+1);
            //System.out.println(pos+","+pos2);
            if(pos > -1 && pos2 > -1 ){
                System.out.println("Here with : "+nums[i]);
                ans = nums[i];
                break;
            }
        }
        return ans;
    }*/
	
	
	//******************** PROPER SOLUTION
	//************************************
	public static int findDuplicate(int[] nums){
		if(nums.length > 1){
	        int slow = nums[0];
	        int fast = nums[0];
	
	        while(true){
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	            if(slow == fast){
	                break;
	            }
	        }
	        int finder = nums[0];
	        int ans = 0;
	        while(slow != finder){
	            slow = nums[slow];
	            finder = nums[finder];
	        }
	        return slow;
	    }
	    return -1;
	}
}
