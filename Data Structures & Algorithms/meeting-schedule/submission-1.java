/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return true;
        }

        // OPTIMIZATION 1: Use an anonymous inner class instead of a lambda.
        // While lambdas are clean, they occasionally carry a tiny bit of runtime overhead 
        // depending on the JVM. For absolute peak speed, this is technically safer.
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });

        // OPTIMIZATION 2: Cache the previous meeting's end time.
        // Calling .get() repeatedly on a List triggers bounds-checking inside Java. 
        // We extract the value once and update it to minimize memory access.
        int prevEnd = intervals.get(0).end;
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            
            if (current.start < prevEnd) {
                return false; // Overlap found
            }
            // Update the end time to the current meeting's end
            prevEnd = current.end; 
        }
        
        return true;
    }
}
