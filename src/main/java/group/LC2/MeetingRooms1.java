package group.LC2;

public class MeetingRooms1 {

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return false;
        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });
        
        //now have a straightforward loop and test it
        for(int i=1; i<intervals.length; i++){
            if(intervals[i-1].start < intervals[i].end)
                return false;
        }
        return true;
    }
}