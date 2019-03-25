package xin.suttonprog.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * HashTable TwoPoints String SlidingWindow
 * @author codingZhengsz
 * @since 2019-03-25 09:54
 **/
public class _3LongestSubstringWithoutRepeatingCharacters {

    /**
     * 暴力破解
     * 使用Set保存已经遍历过的字符，一旦出现重复就记录这个不重复子字符串的长度
     * Runtime: 72 ms, faster than 18.36%
     * Memory Usage: 40.1 MB, less than 12.77%
     */
    public int lengthOfLongestSubstring_1(String s) {
        int length = s.length();
        if(length <= 1) {
            return s.length();
        }
        int maxLength = 0;
        for(int i = 0; i < length - 1; i++) {
            Set<Character> map = new HashSet<>();
            map.add(s.charAt(i));
            int j = i + 1;
            for(; j < length; j++) {
                if(!map.add(s.charAt(j))){
                    break;
                }
            }
            maxLength = Math.max(maxLength,j-i);
        }
        return maxLength;
    }

    /**
     *
     * Runtime: 21 ms, faster than 83.95%
     * Memory Usage: 39.1 MB, less than 23.47%
     */
    public int lengthOfLongestSubstring_2(String s) {
        int length = s.length();
        if(length <= 1) {
            return s.length();
        }
        int maxLength = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0,j=0;i<length;i++){
            if(map.containsKey(s.charAt(i))) {
                j=Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            maxLength = Math.max(maxLength,i-j+1);
        }
        return maxLength;
    }

    /**
     * 与第二种解法相似
     * 用数组的索引作为key
     * 用数组的值作为value
     * Runtime: 15 ms, faster than 98.95%
     * Memory Usage: 39 MB, less than 26.80%
     */
    public int lengthOfLongestSubstring_3(String s) {
        int length = s.length();
        if(length < 2) {
            return s.length();
        }
        int maxLength = 0;
        int[] alpha = new int[255];
        for(int i=0,j=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            alpha[ch] ++;
            while(alpha[ch] > 1){
                alpha[s.charAt(j++)] --;
            }
            maxLength = Math.max(maxLength,i-j+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new _3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_3("  "));
    }

}
