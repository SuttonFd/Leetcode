package xin.suttonprog.String;

/**
 * @author codingZhengsz
 * @since 2019-03-27 11:37
 **/
public class _6ZigZagConversion {

    /**
     * http://www.cnblogs.com/springfor/p/3889414.html
     * Runtime: 3 ms, faster than 99.93%
     * Memory Usage: 39.5 MB, less than 83.13%
     */
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }
        int size = 2 * numRows - 2;
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++ ){
            for(int j = i; j < length; j+=size ){
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows - 1) {
                    int index = j + size - 2 * i;
                    if(index < length) {
                        sb.append(s.charAt(index));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _6ZigZagConversion().convert("PAYPALISHIRING",4));
    }
}
