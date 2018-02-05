package com.zinkirin;
import java.util.ArrayList;
import java.util.List;
/** 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

public class MergeIntervals {
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
	public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return intervals;
        
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i - 1).end < intervals.get(i).start)
                continue;
            if (intervals.get(i).start >=  intervals.get(i - 1).start) {
                intervals.get(i - 1).end = Math.max(intervals.get(i).end, intervals.get(i - 1).end);
                intervals.remove(i);
                i--;
            } else {
                List<Interval> subpre = intervals.subList(0, i);
                subpre = insert(subpre, intervals.get(i));
                int j = subpre.size() - 1;
                subpre.addAll(intervals.subList(i + 1, intervals.size()));
                intervals = subpre;
                i = j;
            }
        }
        
        return intervals;
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
}
