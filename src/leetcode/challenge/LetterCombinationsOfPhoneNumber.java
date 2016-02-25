/*
 * Copyright (c) 2016 VMware, Inc. All Rights Reserved.
 */
package leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber {
  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) {
      return new ArrayList<>();
    }

    String combination = "";
    List<String> result = new ArrayList<>();
    Integer index = 0;

    letterCombinations(digits, index, combination, result);

    return result;
  }

  public void letterCombinations(String digits, Integer index, String combination, List<String> result) {
    if (index == digits.length()) {
      result.add(combination);
      return;
    }

    Character digit = digits.charAt(index);

    for (Character num : convert(digit)) {
      letterCombinations(digits, index + 1, combination + num, result);
    }
  }

  public List<Character> convert(Character digit) {
    if (digit == '0') {
      return Arrays.asList('_');
    } else if (digit == '1') {
      return Arrays.asList('\0');
    } else if (digit == '2') {
      return Arrays.asList('a', 'b', 'c');
    } else if (digit == '3') {
      return Arrays.asList('d', 'e', 'f');
    } else if (digit == '4') {
      return Arrays.asList('g', 'h', 'i');
    } else if (digit == '5') {
      return Arrays.asList('j', 'k','l');
    } else if (digit == '6') {
      return Arrays.asList('m', 'n', 'o');
    } else if (digit == '7') {
      return Arrays.asList('p', 'q', 'r', 's');
    } else if (digit == '8') {
      return Arrays.asList('t', 'u', 'v');
    } else if (digit == '9') {
      return Arrays.asList('w', 'x', 'y', 'z');
    }

    return Arrays.asList('\0');
  }
}
