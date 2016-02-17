package leetcode.challenge;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArray {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {    
    int total = nums1.length + nums2.length;
    
    if (total == 0) {
      return 0.0;
    }
    
    if (total == 1) {
      if (nums1.length == 0) {
        return nums2[0];
      } else {
        return nums1[0];
      }
    }
    
    if (total % 2 != 0) {
      return getMedian(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, total / 2);
    } else {
      return (getMedian(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, total / 2) +
          getMedian(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, total / 2 - 1)) * 0.5;
    }
  }
  
  private double getMedian(int A[], int B[], int aStart, int aEnd, int bStart, int bEnd, int k) {
    int aLen = aEnd - aStart + 1;
    int bLen = bEnd - bStart + 1;
    
    if (aLen == 0) {
      return B[bStart + k];
    }
    
    if (bLen == 0) {
      return A[aStart + k];
    }
    
    if (k == 0) {
      return Math.min(A[aStart], B[bStart]);
    }
    
    int aMid = k * aLen / (aLen + bLen);
    int bMid = k - aMid - 1;
    
    aMid = aStart + aMid;
    bMid = bStart + bMid;
    
    if (A[aMid] < B[bMid]) {
      k = k - (aMid - aStart + 1);
      aStart = aMid + 1;
      bEnd = bMid;
    } else {
      k = k - (bMid - bStart + 1);
      bStart = bMid + 1;
      aEnd = aMid;
    }
    
    return getMedian(A, B, aStart, aEnd, bStart, bEnd, k);
  }
}
