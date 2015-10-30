package leetcode.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import leetcode.challenge.MedianFinder;

public class MedianFinderTest {

  private static MedianFinder finder;

  @Before
  public void setUp() throws Exception {
    finder = new MedianFinder();
  }

  @Test
  public void testFindMedian_OneElement() {
    finder.addNum(5);

    double median = finder.findMedian();
    assertEquals(5, median, 0.0);
  }

  @Test
  public void testFindMedian_TwoElements() {
    finder.addNum(5);
    finder.addNum(6);

    double median = finder.findMedian();
    assertEquals(5.5, median, 0.0);
  }

  @Test
  public void testFindMedian_ThreeElements() {
    finder.addNum(5);
    finder.addNum(4);
    finder.addNum(6);

    double median = finder.findMedian();
    assertEquals(5, median, 0.0);
  }

  @Test
  public void testFindMedian() {
    int[] values = new int[] { -1, -2, -3, -4, -5 };

    double[] medians = new double[] { -1.0, -1.5, -2.0, -2.5, -3.0 };

    for (int i = 0; i < values.length; ++i) {
      finder.addNum(values[i]);
      double median = finder.findMedian();
      assertEquals(medians[i], median, 0.0);
    }
  }
}
