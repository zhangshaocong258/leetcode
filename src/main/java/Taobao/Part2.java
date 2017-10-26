package Taobao;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zsc on 2017/4/26.
 * 2 3 4 * ^ 5 +
 * AC
 */
public class Part2 {
    public static void main(String[] args) {

        Stack<Integer> inputs = new Stack<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim(), inputs);
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String str, Stack<Integer> inputs) {
        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].trim().equals("+")) {
                try {
                    int a = inputs.pop();
                    int b = inputs.pop();
                    inputs.push(a + b);
                    if (inputs.size() > 16) {
                        return -2;
                    }
                } catch (EmptyStackException e) {
                    return -1;
                }
            } else if (strs[i].trim().equals("*")) {
                try {
                    int a = inputs.pop();
                    int b = inputs.pop();
                    inputs.push(a * b);
                    if (inputs.size() > 16) {
                        return -2;
                    }
                } catch (EmptyStackException e) {
                    return -1;
                }
            } else if (strs[i].trim().equals("^")) {
                try {
                    int a = inputs.pop();
                    inputs.push(a + 1);
                    if (inputs.size() > 16) {
                        return -2;
                    }
                } catch (EmptyStackException e) {
                    return -1;
                }
            } else {
                inputs.push(Integer.parseInt(strs[i].trim()));
                if (inputs.size() > 16) {
                    return -2;
                }
            }
        }
        return inputs.pop();
    }
}
