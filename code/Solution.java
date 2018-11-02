package code;

import java.util.*;
import static Tool.ArrayGenerator.*;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public static <T extends Comparable<T>> int findDuplicatedInSortedArray(T[] sortedArray) {
        assert isSorted(sortedArray);
        int i = 0, j = 0, count = 1;
        while (j < sortedArray.length) {
            if (sortedArray[i].compareTo(sortedArray[j]) != 0) {
                i = j;
                count++;
            } else {
                j++;
            }
        }
        return count;
    }
    public static <T extends Comparable<T>> boolean correctnessCheck(T[] sortedArray, int dupCount) {
        HashSet<T> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (!set.contains(sortedArray[i])) {
                set.add(sortedArray[i]);
                count++;
            }
        }
        return count == dupCount;
    }
    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++)
            if (array[i].compareTo(array[i - 1]) < 0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        int k = 100, dupCount = 0;
        while (k-- > 0) {
            Integer[] test = Integers(10);
            Arrays.sort(test);
            print(test);
            dupCount = findDuplicatedInSortedArray(test);
            StdOut.printf("%d 个重复元素\n\n", dupCount);
            
            /* 正确性校验 */
            assert correctnessCheck(test, dupCount);
        }
    }
    // output
    /*
     * 
        0      1      2      3      4      5      6      7      8      9      
        -8     -6     -2     2      2      3      4      4      5      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -8     -8     -3     -1     1      3      3      4      9      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -7     -6     -4     1      1      3      5      9      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -7     -3     -2     -1     0      0      2      3      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -2     2      3      5      5      6      6      8      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -9     -8     -6     -3     -2     4      5      7      8      
        10 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -7     -4     -4     2      2      3      4      7      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -5     -4     0      4      4      7      8      9      9      9      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -6     -2     -1     0      1      2      2      4      8      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -8     -2     -1     1      2      3      7      8      9      
        10 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -8     -6     -1     0      2      2      7      8      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -8     -7     -6     -3     -1     1      3      4      5      10     
        10 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -6     -5     -5     -1     1      1      4      6      8      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -7     -3     -2     -1     0      3      6      6      8      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -6     -3     -1     -1     1      1      2      4      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -4     1      1      2      3      4      8      10     10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -8     -8     -8     -8     -6     -3     -2     1      2      5      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -6     -6     -4     -2     -1     -1     6      7      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -7     -7     -6     -6     -4     -4     -2     -1     2      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -9     -7     -2     0      0      0      1      6      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -9     -3     3      5      5      6      7      8      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -2     -2     -1     0      0      2      4      4      8      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -10    -6     -1     1      1      2      5      7      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -6     -5     -4     -4     -2     -1     7      7      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -7     -7     -4     -3     4      4      5      8      8      
        6 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -2     -2     0      1      3      4      4      5      6      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -8     -7     -4     -3     -1     -1     0      1      8      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -6     -3     -3     2      5      6      6      7      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -7     -7     -4     -2     -1     3      3      8      9      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -8     -6     -3     -3     2      6      7      7      7      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -10    -9     -5     -4     -3     0      0      7      9      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -3     -2     0      3      3      4      6      9      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -1     2      3      6      7      7      8      8      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -9     -8     -8     1      2      2      6      8      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -5     -3     -2     4      5      5      6      7      9      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -8     -6     -5     -4     -4     -3     0      3      6      8      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -3     -2     3      3      4      5      7      8      9      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -6     -2     -2     3      6      6      7      7      9      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -2     -2     -1     2      5      6      7      9      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -9     -7     -6     -5     -3     -2     -2     -1     6      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -6     -4     -3     -2     2      2      5      5      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -9     -5     -5     1      2      4      8      9      9      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -7     -6     -6     -3     -3     -1     2      4      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -9     -9     -9     -2     1      2      3      7      9      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -10    -6     -6     -4     -4     -3     4      5      6      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -5     -1     0      1      3      4      6      9      
        10 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -6     -5     -4     -1     2      4      5      7      9      10     
        10 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -8     -7     -5     -3     -1     -1     2      3      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -6     -6     -5     -3     -1     5      7      7      9      9      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -6     -2     -1     3      3      3      4      5      7      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -6     -3     -3     -3     3      6      7      9      9      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -8     -7     -1     2      2      4      5      7      8      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -7     -6     -5     -4     -3     0      9      10     
        10 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -7     -7     -6     -3     -3     1      5      8      8      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -8     -8     -7     -6     -4     0      1      5      8      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -7     -7     -4     -4     -4     -3     0      4      10     
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -8     -7     -6     -6     -5     -5     -4     1      2      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -7     1      1      2      3      3      7      8      9      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -8     -5     -2     0      2      3      6      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -9     -6     -2     -1     1      2      8      8      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -6     -5     -4     -2     1      2      2      4      5      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -8     -6     -5     -5     -2     4      5      6      6      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -8     -5     -3     -2     -1     4      4      6      7      9      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -3     2      5      5      5      8      10     10     10     
        6 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -6     -5     0      1      1      2      4      4      5      5      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -7     -5     -5     -5     -3     -2     -1     7      7      
        6 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -8     -4     -1     1      1      2      4      5      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -5     -5     -3     -1     0      1      3      5      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -5     -4     -2     1      1      4      4      7      9      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -6     1      1      1      2      3      5      9      10     10     
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -8     -4     -3     0      1      2      5      6      9      
        10 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -6     -6     -5     -5     -5     -2     0      0      10     
        6 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -7     -6     -3     -3     -1     1      2      9      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -7     -3     -3     -2     -2     0      1      5      6      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -6     -6     -4     0      2      4      7      8      9      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -3     -2     -2     1      6      6      7      8      10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -9     -8     -7     -7     -6     -5     2      6      8      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -10    -7     -6     -5     -5     -4     4      4      8      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -6     -4     2      4      5      6      7      9      
        10 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -7     -5     -4     1      2      6      7      9      9      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -5     0      1      2      3      3      5      5      7      8      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -7     -5     -1     0      1      3      4      7      8      
        10 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -4     -4     -3     -3     -1     3      5      6      8      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -6     -4     -1     0      1      3      3      4      4      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -7     2      3      4      5      6      9      9      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -6     -5     -5     -4     -4     -2     2      5      9      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -10    -5     -2     -2     -1     3      4      8      8      
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -7     -5     -3     -3     0      3      8      10     10     
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -7     -6     -3     -2     1      4      8      9      9      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -4     -4     2      2      3      6      7      9      
        8 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -4     -3     -1     2      3      7      8      9      
        10 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -9     -5     -5     -1     0      1      5      6      9      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -5     -3     -1     1      4      7      9      10     10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -8     -8     -4     1      1      6      7      7      9      10     
        7 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -7     -3     -2     -1     0      3      4      6      7      8      
        10 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -8     -8     -4     -2     -1     2      5      6      8      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -10    -8     -3     -2     -1     1      3      3      5      9      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     -9     -3     2      3      4      5      8      9      10     
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -5     -4     -3     0      1      2      6      8      8      9      
        9 个重复元素
        
        
        0      1      2      3      4      5      6      7      8      9      
        -9     0      0      3      4      6      6      7      9      9      
        7 个重复元素


     */
}
