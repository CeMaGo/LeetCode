var countDays = function(days, meetings) {
    if (meetings.length === 0) {
        return days;
    }

    // meetings.sort((a -b) => a[0] - b[0]);git 
    meetings.sort((a, b) => a[0] - b[0]);

    const mergedIntervals = [];
    let currentStart = meetings[0][0];
    let currentEnd = meetings[0][1];

    for  (let i = 1; i < meetings.length; i++) {
        const nextStart = meetings[i][0];
        const nextEnd = meetings[i][1];


    if (nextStart <= currentEnd) {
        currentEnd = Math.max(currentEnd , nextEnd);
    } else {
        mergedIntervals.push([currentStart, currentEnd]);
        currentStart = nextStart;
        currentEnd = nextEnd;
    }
    }
    mergedIntervals.push([currentStart, currentEnd]);

    let freeDays = days;
    for (const interval of mergedIntervals) {
        freeDays -= (interrval[1] - interval[0] + 1);
        }
        return Math.max(0, freeDays);
};