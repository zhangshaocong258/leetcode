package baidu;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by zsc on 2017/5/5.
 * 买帽子 第三便宜
 * in
 * 10
 * 10 10 10 10 20 20 30 30 40 40
 * out
 * 30
 */
public class Part1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            treeSet.add(scanner.nextInt());
        }
        Iterator<Integer> iterator = treeSet.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            int temp = iterator.next();
            if (i == 3) {
                System.out.println(temp);
            }
        }
        if (i < 3) {
            System.out.println(-1);
        }
    }
}
