package group.LC;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval.
 */ 
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
 
class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        //lets sort it
        if(intervals.size() <= 1)
            return intervals;
        
        //sort the collection using the first start point
        //using lambda anonymous function to sort the damn list
        
        intervals.sort((i1,i2) -> Integer.compare(i1.start, i2.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        //now lets construct the answer
        List<Interval> ans = new ArrayList<Interval>();
        Interval p1 = null;
        for( Interval i : intervals){
            //
            if(i.start <= end){
                //keep extending the end
                end = Math.max(end, i.end);
            }else{
                //when you hit a disjoince, add it to the ans else keep it within the loop
                ans.add(new Interval(start,end));
                start = i.start;
                end = i.end;
            }
        }
        //add the final interval before which the loop exited as there were no disjoince after the end of list
        ans.add(new Interval(start,end));
        return ans;
    }
}