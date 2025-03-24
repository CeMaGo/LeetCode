class Solution:
    def countDays(self, days: int, meetings: list[list[int]]) -> int:
        occupied_intervals = []
        for start, end in meetings:
            occupied_intervals.append((start, end))

        if not occupied_intervals:
            return days

        occupied_intervals.sort(key=lambda x: x[0])

        merged_intervals = []
        if occupied_intervals:
            current_start, current_end = occupied_intervals[0]
            for i in range(1, len(occupied_intervals)):
                next_start, next_end = occupied_intervals[i]
                if next_start <= current_end:
                    current_end = max(current_end, next_end)
                else:
                    merged_intervals.append((current_start, current_end))
                    current_start, current_end = next_start, next_end
            merged_intervals.append((current_start, current_end))

        free_days = days

        for start, end in merged_intervals:
            free_days -= (end - start + 1)

        return max(0, free_days)