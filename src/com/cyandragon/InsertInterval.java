package com.cyandragon;
import java.util.ArrayList;
import java.util.List;
/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            if (newInterval == null)
                return null;
            else {
                intervals = new ArrayList<Interval>();
                intervals.add(newInterval);
                return intervals;
            }
        }
        int size = intervals.size();
        
        int i = 0;
        while (i < size && newInterval.start > intervals.get(i).end)
            i++;
        if (i == size) {
            intervals.add(newInterval);
            return intervals;
        }
        int j = intervals.size() - 1;
        while (j >= 0 && newInterval.end < intervals.get(j).start)
            j--;
        if (j == -1) {
            intervals.add(0, newInterval);
            return intervals;
        }
            
        List<Interval> result = new ArrayList<Interval>();
        for (int k = 0; k < i; k++) {
            result.add(intervals.get(k));
        }
        result.add(new Interval(Math.min(intervals.get(i).start, newInterval.start), 
                                    Math.max(intervals.get(j).end, newInterval.end)));
        for (int k = j + 1; k < intervals.size(); k++)
            result.add(intervals.get(k));
            
        return result;
    }
	
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 5));
		new InsertInterval().insert(list, new Interval(6, 8));
	}
}
