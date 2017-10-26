package xiecheng;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by zsc on 2017/4/20.
 * 拼图，是一个老少皆宜的益智游戏，在打乱的3*3的范围中，玩家只能每次将空格(0)和相邻的数字格（上、下、左、右）交换，最终调整出一个完整的拼图。
 */
public class Part2 {
    public static String destNumbers = "123456780";
    public static Set<Integer> set = new HashSet<Integer>();
    public static int[] moveTable = new int[]{12, 14, 10, 13, 15, 11, 5, 7, 3};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numbers = new String();
        for (int rows = 3; rows > 0; rows--) {
            for (String n : scan.nextLine().split(" ")) {
                numbers += n;
            }
        }

        int res = run(numbers);

        System.out.println(String.valueOf(res));
    }

    static int run(String numbers) {
        if (numbers.equals(destNumbers)) {
            return 0;
        }
        ArrayList<Node> numsList = new ArrayList<Node>();
        numsList.add(new Node(null, numbers, ' '));
        while (numsList.size() > 0) {
            ArrayList<Node> tmpList = new ArrayList<Node>();

            for (Node pNode : numsList) {
                ArrayList<Node> cNodes = getNextMoveList(pNode);

                for (Node cNode : cNodes) {
                    if (cNode.numbers.equals(destNumbers)) {
                        return getResult(cNode);
                    }
                    tmpList.add(cNode);
                }
            }

            numsList = tmpList;
        }
        return -1;
    }

    public static ArrayList<Node> getNextMoveList(Node pNode) {

        int position = pNode.numbers.indexOf("0");
        int moveStatus = moveTable[position];
        ArrayList<Node> cNodes = new ArrayList<Node>();


        for (int status = 1; status <= 8; status = status << 1) {
            if ((moveStatus & status) > 0) {
                char[] charNumbers = pNode.numbers.toCharArray();
                int switchPosition = 0;
                if (status == 1) {
                    switchPosition = position - 3;
                } else if (status == 2) {
                    switchPosition = position - 1;
                } else if (status == 4) {
                    switchPosition = position + 1;
                } else if (status == 8) {
                    switchPosition = position + 3;
                }
                charNumbers[position] = charNumbers[switchPosition];
                charNumbers[switchPosition] = '0';
                String s = String.valueOf(charNumbers);
                if (!set.contains(Integer.valueOf(s))) {
                    set.add(Integer.valueOf(s));
                    Node n = new Node(pNode, s, charNumbers[position]);
                    cNodes.add(n);
                }
            }
        }
        return cNodes;
    }


    static int getResult(Node node) {
        String result = "";
        while (node.parentNode != null) {
            result += node.currentNum;
            node = node.parentNode;
        }
        return new StringBuffer(result).reverse().toString().length();
    }


}

class Node {
    public Node(Node parentNode, String numbers, char currentNum) {
        this.numbers = numbers;
        this.currentNum = currentNum;
        this.parentNode = parentNode;
    }

    public char currentNum;
    public String numbers;
    public Node parentNode;
}
