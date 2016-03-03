package leetcode.challenge;

import leetcode.model.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
  public List<Interval> mergeIntervals(List<Interval> intervals) {
    if (intervals.isEmpty()) {
      return intervals;
    }

    Collections.sort(intervals, new IntervalComparator());

    Stack<Interval> st = new Stack<>();
    st.push(intervals.get(0));

    for (int i = 1; i < intervals.size(); ++i) {
      Interval it = intervals.get(i);
      Interval lastIt = st.peek();
      if (it.start <= lastIt.end) {
        Interval newInterval = new Interval(lastIt.start, Math.max(it.end, lastIt.end));
        st.pop();
        st.push(newInterval);
      } else {
        st.push(it);
      }
    }

    return new ArrayList<>(st);
  }

  public static class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
      return a.start - b.start;
    }
  }
}
