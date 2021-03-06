package com.cmm.leetcode.binarysearch.easy._1351countNegatives;

/**
 * @author cmm
 * @date 2020/7/16 3:34 PM
 * @desc
 * Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.
 *
 * Return the number of negative numbers in grid.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * Example 2:
 *
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * Example 3:
 *
 * Input: grid = [[1,-1],[-1,-1]]
 * Output: 3
 * Example 4:
 *
 * Input: grid = [[-1]]
 * Output: 1
 */
public class Solution {

    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int clos = grid[0].length;

        int ret = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < clos; j++) {
                if (grid[i][j] < 0) {
                    ret += clos - j;
                    break;
                }
            }
        }
        return ret;
    }
}
