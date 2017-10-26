package Taobao;

import java.util.Scanner;

/**
 * Created by zsc on 2017/4/26.
 */
public class Part2_2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        char[] str = string1.toCharArray();//要匹配的字符串
        char[] pattern = string2.toCharArray();//匹配模式
        int result = 0;//要输出的结果
        int n1 = str.length;
        int n2 = pattern.length;
        int j = 0;
        bfor:
        for (int i = 0; i < n1; i++) {
            if (pattern[i] == '*') {
                if (i + 1 == n2) {
                    result = 1;
                    break;
                }
                for (j = i; j < n2; j++) {
                    if (str[j] == pattern[i + 1]) {
                        result = 1;
                        break;
                    } else {
                        continue;
                    }
                }
                if (j == n2) {
                    result = 0;
                    break bfor;
                }
            } else if (pattern[i] == '?') {
                result = 1;
                continue;
            } else if (pattern[i] == str[i]) {
                result = 1;
                continue;
            } else if (pattern[i] != str[i]) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }
}
