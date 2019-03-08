package xin.suttonprog.Arrays;

/**
 * TODO...
 *
 * @author codingZhengsz
 * @since 2019-03-05 14:40
 **/
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int l = 0,r = height.length - 1;
        int ans = 0;
        while (l <= r) {
            ans = Math.max(ans,Math.min(height[l],height[r])*(r-l));
            if(height[l] < height[r]) {
                l ++;
            }else{
                r --;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(input));
    }


}
