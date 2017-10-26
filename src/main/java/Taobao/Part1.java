package Taobao;

import java.util.Scanner;

/**
 * Created by zsc on 2017/4/26.
 * 匹配字符串
 */
public class Part1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String pattern = scanner.nextLine();
        System.out.println(str + pattern);
        System.out.println(filter(str, pattern));

    }

    public static int filter(String str, String pattern) {
        if (str.equals(pattern)) {
            return 1;
        }
        if (str.toCharArray()[0] == '?' || str.toCharArray()[0] == pattern.toCharArray()[0]) {
            return 1;
        }
        if (str.toCharArray()[0] != '?' && str.toCharArray()[0] != pattern.toCharArray()[0]) {
            return 0;
        }
        String[] pStrs = pattern.split("\\*");
        int k = -1;
        int m = -1;
        for (int i = 0; i < pStrs.length; i++) {
            if (!pStrs[i].contains("?")) {
                if ((str.indexOf(pStrs[i])) > k) {
                    k = str.indexOf(pStrs[i]);
                    continue;
                } else {
                    return 0;
                }
            } else {
                String[] pStrsSub = pStrs[i].split("\\?");
                for (int j = 0; j < pStrsSub.length; j++) {

                    if (pStrsSub[j].trim().length() == 0) {
                        continue;
                    }
                    if ((str.indexOf(pStrsSub[j])) > m) {
                        m = str.indexOf(pStrsSub[j]);
                        continue;
                    } else {
                        return 0;
                    }
                }
                k = m;
            }
        }
        return 1;
    }
}
