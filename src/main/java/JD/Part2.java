package JD;

import java.util.Scanner;

/**
 * Created by zsc on 2017/4/11.
 * 有一条很长的队伍，队伍里面一共有n个人。所有的人分为三类：警察，小偷和普通人。
 * 将队伍里面的人从前到后由1到n编号，编号为i的人与编号为j的人的距离为i与j之差的绝对值。
 * 每一个警察有一个能力值x，表示他能够监视与他距离不超过x的所有人，小偷被警察发现当且仅当他被一个或多个警察监视到。
 * 你知道在整条队伍中，一共有多少个小偷会被警察发现吗？
 */
public class Part2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String string = scanner.nextLine();
        char[] str = string.toCharArray();
        int result = 0;//要输出的结果

        for (int i = 0; i < n; i++) {
            if (str[i] == 'X') continue;
            else if (str[i] == '#') continue;
            else {
                int b = i;
                int a = Integer.valueOf(String.valueOf(str[i]));
                for (int j = 1; j <= a; j++) {
                    if (b - j < 0) break;
                    else if (str[b - j] == 'X') {
                        result = result + 1;
                        str[b - j] = '#';
                    } else continue;

                }
                for (int j = 1; j <= a; j++) {
                    if (b + j > n - 1) break;
                    else if (str[b + j] == 'X') {
                        result = result + 1;
                        str[b + j] = '#';
                    } else continue;
                }
            }

        }
        System.out.println(result);
    }
}
