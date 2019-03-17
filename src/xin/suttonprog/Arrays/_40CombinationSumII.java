package xin.suttonprog.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author codingZhengsz
 * @since 2019-03-17 20:01
 **/
public class _40CombinationSumII {

    /**
     * Runtime: 9 ms, faster than 79.66%
     * Memory Usage: 39.6 MB, less than 50.50%
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        dfsHelper(candidates,0,0,target,result,temp);
        return result;
    }

    public void dfsHelper(int[] candidates,int start,int sum,int target,List<List<Integer>> result,List<Integer> temp) {
        // 剪枝
        if(sum > target) {
            return;
        }
        // 保存后剪枝
        if(sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        int preElement = -1;
        for(int i=start;i<candidates.length;i++){
            // 每一次遍历从与上次不同的元素开始
            if(preElement != candidates[i]) {
                temp.add(candidates[i]);
                dfsHelper(candidates,i+1,sum+candidates[i],target,result,temp);
                temp.remove(temp.size() - 1);
                preElement = candidates[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(new _40CombinationSumII().combinationSum2(candidates, target).toString());
    }



}
