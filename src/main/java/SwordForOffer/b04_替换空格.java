package SwordForOffer;

/**
 * Created by zsc on 2017/3/16.
 * 替换空格
 */
public class b04_替换空格 {

    public static void main(String args[]) {
        b04_替换空格 test = new b04_替换空格();
        String s = "  ";
        System.out.println(test.replaceBlank(s));
    }

    private String replaceBlank(String input) {
        if (input == null)
            return null;
        StringBuffer outputBuffer = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                outputBuffer.append("%");
                outputBuffer.append("2");
                outputBuffer.append("0");
            } else {
                outputBuffer.append(String.valueOf(input.charAt(i)));
            }
        }
        return new String(outputBuffer);
    }
}
