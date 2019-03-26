package xin.suttonprog.Arrays;

import java.util.Arrays;

/**
 * 48. Rotate Image
 * Tag:Array
 * @author codingZhengsz
 * @since 2019-03-26 16:13
 **/
public class _48RotateImage {

    /**
     * 对于每一个数字，求出旋转后存放的位置，然后求出下一个位置的数字的新位置
     * 每次循环更换4个数字
     * 1 2 3     '7' 2 '1'       7 '4' 1
     * 4 5 6  --> 4  5  6  -->  '8' 5 '2'
     * 7 8 9     '9' 8 '3'       9 '6' 3
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 37.4 MB, less than 24.59%
     */
    public void rotate_1(int[][] matrix) {
        int n = matrix.length;
        if(n <= 1) {
            return;
        }
        for(int i = 0; i < n/2;i++){
            for(int j = i;j< n - i - 1;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }

    /**
     * 从对角线为轴进行翻转，然后再以x轴中线上下翻转
     * 第一次翻转为 7 5 3 这一条轴
     * 第二次翻转为 8 5 2 这一条轴
     *
     * 1 2 3      9 6 3     7 4 1
     * 4 5 6  --> 8 5 2 --> 8 5 2
     * 7 8 9      7 4 1     9 6 3
     *
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 37.2 MB, less than 86.36%
     */
    public void rotate_2(int[][] matrix) {
        int n = matrix.length;
        if(n <= 1) {
            return;
        }
        for(int i= 0;i < n - 1;i++){
            for(int j = 0;j < n - i;j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = tmp;
            }
        }
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = tmp;
            }
        }
    }

    /**
     * 首先对原来的数组进行转置，然后对每一行的数组进行倒置
     *
     * 1 2 3      1 4 7     7 4 1
     * 4 5 6  --> 2 5 8 --> 8 5 2
     * 7 8 9      3 6 9     9 6 3
     *
     *  Runtime: 0 ms, faster than 100.00%
     *  Memory Usage: 37.2 MB, less than 86.96%
     */
    public void rotate_3(int[][] matrix){
        int n = matrix.length;
        if(n <= 1) {
            return;
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
            for(int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new _48RotateImage().rotate_3(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}
