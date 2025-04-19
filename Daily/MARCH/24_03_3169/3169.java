import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings.length == 0) {
            return days;
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));


        List<int[]> mergedIntervals = new ArrayList<>();
        int currentStart = meetings[0][0];
        int currentEnd = meetings[0][1]

        for ( int i = 1; i < meetings.length; i++ ) {
            int nextStart = meetings[i][0];
            int nextEnd = meetings[i][1];

            if (nextStart <= currentEnd) {
                currentEnd = Math.max(currentEnd, nextEnd);
            } else {
                mergedIntervals.add(new int[]{currentStart, currentEnd});
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }
        mergedIntervals.add(new int[]{currentStart, currentEnd});

        int freeDays = days;
        for (int[] interval : mergedIntervals) {
            freeDays -= (interval[1] - interval[0] + 1);
        }

        return Math.max(0, freeDays);
    }
}