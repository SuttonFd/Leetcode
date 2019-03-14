package xin.suttonprog.Arrays;

/**
 * @author codingZhengsz
 * @since 2019-03-14 10:49
 **/
public class _66PlusOne {

    /**
     * 只有等于9的时候才进位，小于9的时候，数值加上一之后返回本数组就可以了
     * 如果全都是9的情况，比如999，只需要返回一个首数字为1的数组就可以了
     * O(n)
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 34.8 MB, less than 90.96%
     */
    public static int[] plusOne(int[] digits) {
        if(digits.length == 0) {
            return digits;
        }
        for(int i=digits.length-1;i>=0;i--) {
            if(digits[i] < 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {9,9,9};
        int[] ans = plusOne(nums);
        for(int i=0;i<nums.length;i++){
            System.out.println(ans[i]);
        }
    }
}
