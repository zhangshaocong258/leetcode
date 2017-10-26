package kedaxunfei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zsc on 2017/9/16.
 * 采用回溯
 */
public class Part1 {
    private static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        delete(list);
        System.out.println(result);

    }


    private static void delete(List<Character> list) {
        System.out.println(list);
        int k = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == 'R' && list.get(i + 1) == 'L') {
                k = i;
                break;
            }
        }
        if (k == -1) {
            if (result > list.size()) {
                result = list.size();
            }
        } else {
            //需要保证递归调用delete后，list状态没变
            char c = list.remove(k);
            delete(list);
            list.add(k, c);
            c = list.remove(k + 1);
            delete(list);
            list.add(k + 1, c);
        }
    }
}
