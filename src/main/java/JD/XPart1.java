package JD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zsc on 2017/9/8.
 */
public class XPart1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        int result = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                if (count != 0) {
                    list.add(count);
                }
                count--;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            result *= list.get(i);
        }
        System.out.println(result);
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String str = scanner.nextLine();
//            Stack<Character> stack = new Stack<Character>();
//            int result = 1;
//            for (int i = 0; i < str.length(); i++) {
//                char c = str.charAt(i);
//                if (c == '(') {
//                    stack.push(c);
//                } else if (c == ')') {
//                    result *= stack.size();
//                    stack.pop();
//                }
//            }
//            System.out.println(result);
//        }
//    }
}
