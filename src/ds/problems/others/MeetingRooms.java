package ds.problems.others;
//https://www.lintcode.com/problem/meeting-rooms/description
//920. Meeting Rooms

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public class Interval {
     int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals,new Comparator<Interval>() {
            @Override
            public int compare(Interval i1,Interval i2) {
                int compare = i1.start - i2.start;
                if(compare!=0) return compare;
                return i2.end - i1.end;
            }
        });
        for(int i=0;i<intervals.size()-1;i++) {
            if(intervals.get(i).end > intervals.get(i+1).start) return false;
        }
        return true;
    }
}
