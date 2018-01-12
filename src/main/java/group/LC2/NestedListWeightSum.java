package group.LC2;

public class NestedListWeightSum {


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
	
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0)
            return 0;
        int curDepth = 1, curSum = 0;
        //iterate thro the list
        //check if each element is a nested integer or list
        //then go down further - call helper
        //else keep adding the nos.
        for(int i=0; i< nestedList.size(); i++){
            NestedInteger n = nestedList.get(i);
            if(n.isInteger())
                curSum += n.getInteger();
            else{
                //its a list
                //go down further
                curSum += helper(n, curDepth+1);
            }
        }
        return curSum;
    }
    
    public int helper(NestedInteger n, int curDepth){
        //initial validation
        
        if(n == null || n.getList() == null)
            return 0;
        int sum = 0;
        //it is a list
        for(int i=0; i<n.getList().size(); i++){
            NestedInteger element = n.getList().get(i);
            if(element.isInteger())
                sum += (element.getInteger()*curDepth);
            else
                sum += helper(element, curDepth+1);
        }
        System.out.println(sum);
        return sum;
    }
}