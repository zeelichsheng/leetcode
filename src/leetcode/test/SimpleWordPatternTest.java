package leetcode.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import leetcode.challenge.SimpleWordPattern;

public class SimpleWordPatternTest {

  private static SimpleWordPattern simpleWordPattern;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    simpleWordPattern = new SimpleWordPattern();
  }

  @Test
  public void testNullPatternNonNullStr() {
    String pattern = null;
    String str = "cat dog";
    boolean isMatch = simpleWordPattern.isMatch(pattern, str);
    
    assertEquals(false, isMatch);
  }
  
  @Test
  public void testNonNullPatternNullStr() {
    String pattern = "ab";
    String str = null;
    boolean isMatch = simpleWordPattern.isMatch(pattern, str);
    
    assertEquals(false, isMatch);
  }
  
  @Test
  public void testNullPatternNullStr() {
    String pattern = null;
    String str = null;
    boolean isMatch = simpleWordPattern.isMatch(pattern, str);
    
    assertEquals(true, isMatch);
  }
  
  @Test
  public void testPatternLengthNotEqualToStrLength() {
    String pattern = "aabb";
    String str = "cat cat dog";
    boolean isMatch = simpleWordPattern.isMatch(pattern, str);
    
    assertEquals(false, isMatch);
  }
  
  @Test
  public void testSinglePatternAndStr() {
    String pattern = "a";
    String str = "cat";
    boolean isMatch = simpleWordPattern.isMatch(pattern, str);
    
    assertEquals(true, isMatch);
  }
  
  @Test
  public void testSingleRepeatPatternAndStr() {
    String pattern = "aaa";
    Object[][] strAndMatchTestCases = new Object[][] {
      {"cat cat cat", true},
      {"dog cat cat", false},
      {"cat dog cat", false},
      {"cat cat dog", false},
      {"ca cat cat", false},
      {"cat ca cat", false},
      {"cat cat ca", false},
    };
    
    for (Object[] testCase : strAndMatchTestCases) {
      String str = (String) testCase[0];
      Boolean expectedIsMatch = (Boolean) testCase[1];
      boolean isMatch = simpleWordPattern.isMatch(pattern, str);
      
      assertEquals(expectedIsMatch, isMatch);
    }
  }
  
  @Test
  public void testMultipleStrsMatchSamePattern() {
    String pattern = "abbcac";
    String str = "cat cat cat dog cat dog";
    boolean isMatch = simpleWordPattern.isMatch(pattern, str);
    
    assertEquals(false, isMatch);
  }
}
