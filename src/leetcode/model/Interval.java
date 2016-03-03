package leetcode.model;

public class Interval {
  public int start;
  public int end;
  
  public Interval() {
    this(0, 0);
  }

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
