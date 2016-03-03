package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters
 * and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a
 * line do not divide evenly between words, the empty slots on the left will be assigned more spaces than
 * the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * https://leetcode.com/problems/text-justification/
 */
public class TextJustification {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> cache = new ArrayList<>();
    int totalWordLen = 0;
    List<String> result = new ArrayList<>();

    for (int i = 0; i < words.length; ++i) {
      if (totalWordLen + words[i].length() > maxWidth) {
        result.add(justify(cache, maxWidth));
        cache.clear();
        totalWordLen = 0;
      }
      cache.add(words[i]);
      totalWordLen += words[i].length() + 1;
    }

    if (!cache.isEmpty()) {
      result.add(justifyLastLine(cache, maxWidth));
    }

    return result;
  }

  private String justify(List<String> words, int maxWidth) {
    int totalWordLen = 0;
    for (int i = 0; i < words.size(); ++i) {
      totalWordLen += words.get(i).length();
    }

    int lenDiff = maxWidth - totalWordLen;
    if (words.size() == 1) {
      String justified = words.get(0);
      for (int i = 0; i < lenDiff; ++i) {
        justified += " ";
      }
      return justified;
    }

    String justified = "";
    int gap = lenDiff / (words.size() - 1);
    int extraGap = lenDiff - gap * (words.size() - 1);

    for (int i = 0; i < words.size(); ++i) {
      justified += words.get(i);

      if (i != words.size() - 1) {
        for (int j = 0; j < gap; ++j) {
          justified += " ";
        }

        if (extraGap > 0) {
          justified += " ";
          --extraGap;
        }
      }
    }

    return justified;
  }

  private String justifyLastLine(List<String> words, int maxWidth) {
    int totalWordLen = 0;
    String justified = "";
    for (int i = 0; i < words.size(); ++i) {
      justified += words.get(i) + " ";
      totalWordLen += words.get(i).length() + 1;
    }

    if (totalWordLen < maxWidth) {
      for (int i = 0; i < maxWidth - totalWordLen; ++i) {
        justified += " ";
      }
    } else if (totalWordLen > maxWidth) {
      justified = justified.trim();
    }

    return justified;
  }
}
