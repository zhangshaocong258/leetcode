package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsc on 2018/10/8.
 * Z字形变换
 */
public class ZigZagConversion {
}

class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int col = 0;
        //true 表示递增
        boolean flag = false;
        for (char c : s.toCharArray()) {
            list.get(col).append(c);
            if (col == 0 || col == numRows - 1) {
                flag = !flag;
            }
            col += flag ? 1 : -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            stringBuilder.append(list.get(i).toString());
        }
        return stringBuilder.toString();
    }
}
