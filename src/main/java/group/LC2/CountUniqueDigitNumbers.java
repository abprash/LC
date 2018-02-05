package group.LC2;

public class CountUniqueDigitNumbers {

}


//bRUTE FORCE solution

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n <= 0)
            return 1;
        int start = 0, count  = 0;
        String startString = Integer.toString(start);
        while(startString.length() <= n){
            char[] charArr = startString.toCharArray();
            Set<Character> set = new HashSet<Character>();
            for(Character c : charArr){
                // if(set.contains(c))
                //     break;
                set.add(c);
            }
            if(set.size() == charArr.length)
                count++;
            start++;
            startString = Integer.toString(start);
        }
        return count;
    }
}


//Backtracking solution


class Solution {
    int count = 0;
    List<String> list = new ArrayList<>();
    public int countNumbersWithUniqueDigits(int n) {
        if(n <= 0)
            return 1;
        //int count = 0;
        int[] nums = {0, 1,2,3,4,5,6,7,8,9};
        StringBuilder sb = new StringBuilder();
        //list.add("0");//for the 0
        count++; //for the 0
        backtrack(sb, 0, nums, n);
        //System.out.println(list);
        return count;
    }
    
    public void backtrack(StringBuilder sb, int start, int[] nums,  int n){
        if(sb.length() >= 1 && sb.length() <= n && sb.toString().charAt(0) != '0'){
            //list.add(sb.toString());
            count++;
            //if(count > 100000)
            //System.out.println(count);
            if(sb.length() == n)
                return;
        }
        for(int i=start; i<nums.length; i++){
            int prevLen = sb.length();
            //if(sb.toString().contains(""+nums[i]))
            //    continue;
            sb.append(nums[i]);
            backtrack(sb, start+1, nums, n);
            sb.setLength(prevLen);
        }
    }
}