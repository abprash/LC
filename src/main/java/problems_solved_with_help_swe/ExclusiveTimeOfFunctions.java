package problems_solved_with_help_swe;

//https://leetcode.com/problems/exclusive-time-of-functions/description/
//https://leetcode.com/problems/exclusive-time-of-functions/discuss/163614/java-using-stack-straightforward-implementation

public class ExclusiveTimeOfFunctions {


    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0)
            return new int[0];
        int[] res = new int[n];
        int prevTime = 0;
        Stack<Integer> stack = new Stack<>();//will store the func ids 
        for(String log : logs){
            //parse the log string
            String[] logSplit = log.split(":");
            int id = Integer.parseInt(logSplit[0]);
            int curr = Integer.parseInt(logSplit[2]);
            String state = logSplit[1];
            
            if(state.equals("start")){
                //function starts
                //if stack is not empty - update the time for the func inside stack
                //this may or may not be a different func
                if(!stack.isEmpty()){
                   res[stack.peek()] += curr - prevTime; 
                }
                stack.push(id);
                //update the prev time
                prevTime = curr;
            }
            else{
                //function ends
                //we need to pop it and update the final time for this function run
                res[stack.peek()] += curr - prevTime + 1;
                stack.pop();
                //update the prevTime as well
                prevTime = curr + 1;
            }
        }
        return res;
    }
}