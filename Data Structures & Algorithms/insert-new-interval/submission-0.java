class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<int[]> ();
        int i = 0;
        int s = newInterval[0];
        int e = newInterval[1];
        int l = intervals.length;
        while (i < l) {
            if (intervals[i][1] < s) {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
                i++;
            } else {
                break;
            }
        }

        if (i == l) {
            result.add(newInterval);
        } else {
            while (i < l && intervals[i][0] <= e) {
                s = Math.min(s, intervals[i][0]);
                e = Math.max(e, intervals[i][1]);
                i++;
            }
            result.add(new int[]{s, e});
        }

        while (i < l) {
            result.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }  
 }
