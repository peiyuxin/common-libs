/**
 * 
 */
package org.pyx.common.libs.algorithms;

/**
 * Bean拷贝工具类 FIXME Arrays.binarySearch貌似有bug?
 * @author pyx
 * @date 2018/8/8
 */
public abstract class BinarySearch {

  public static int rank(long key, long[] array) {
    int lo = 0;
    int hi = array.length - 1;
    while (lo <= hi) {
      // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if (key < array[mid]) {
        hi = mid - 1;
      }

      else if (key > array[mid]) {
        lo = mid + 1;
      }

      else {
        return mid;
      }

    }
    return -1;
  }

  public static int rank(int key, int[] array) {
    int lo = 0;
    int hi = array.length - 1;
    while (lo <= hi) {
      // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if (key < array[mid]) {
        hi = mid - 1;
      }

      else if (key > array[mid]) {
        lo = mid + 1;
      }

      else {
        return mid;
      }

    }
    return -1;
  }

  public static <T extends Comparable<? super T>> int rank(T key, T[] array) {
    int lo = 0;
    int hi = array.length - 1;
    while (lo <= hi) {
      // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if (key.compareTo(array[mid]) < 0) {
        hi = mid - 1;
      }

      else if (key.compareTo(array[mid]) > 0) {
        lo = mid + 1;
      }

      else {
        return mid;
      }

    }
    return -1;
  }

}
