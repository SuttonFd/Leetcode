package xin.suttonprog.Arrays;

import java.util.Arrays;

/**
 * @author codingZhengsz
 * @since 2019-03-10 11:18
 **/
public class NextPermutation {


    /**
     * 例子：3,4,6,5,2,1
     * 结果：3,5,1,2,4,6
     *
     * 1. 先从后往前找到一个不是依次增长的数，记录下位置p。比如上述例子中的4.因为4>3
     * 2. 如果上述数字是依次增长的，说明这个数组中数字组成的数字是最大的，只需要将这个
     *    数字反转之后，就是最小的数字。
     * 3. 否则，从后往前找到第一个大于数字nums[p]的数字，标记这个位置为q。
     *    交换p和q这两个数字。比如上述的p=1,q=3,nums[p]=4,nums[q]=5
     *    交换之后的结果为 3,5,6,4,2,1
     *    将p之后的数字进行逆序
     *    逆序之后的结果为 3,5,1,2,4,6
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return;
        }

        int p = nums.length - 2;
        while(p >= 0 && nums[p] >= nums[p+1]) {
            p--;
        }
        if(p >= 0) {
            int q = nums.length - 1;
            while(q >= 0 && nums[p] >= nums[q]) {
                q--;
            }
            swap(nums,p,q);
        }
        reverse(nums,p+1,nums.length-1);

    }

    private static void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums,i++,j--);
        }
    }


    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
