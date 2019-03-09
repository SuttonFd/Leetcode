package xin.suttonprog.Arrays;

/**
 * TODO...
 *
 * @author codingZhengsz
 * @since 2019-03-09 11:20
 **/
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1,2,2,3,0,4,2};
        int len = removeElement(nums,2);
        for(int i=0;i<len;i++){
            System.out.println(nums[i]);
        }
    }
}
