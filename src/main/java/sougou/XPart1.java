package sougou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zsc on 2017/9/9.
 */
public class XPart1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        double[] array = new double[n];

        for (int i = 0; i < n; i++) {
            array[i] = Double.parseDouble(reader.readLine());
        }

        int start = 0, end = 1;
        double result = 0;
        while (start < n && end < n) {
            double value = array[end] - array[start];
            if (value < 180) {
                end++;
                result = Math.max(result, value);
            } else {
                start++;
                result = Math.max(result, 360 - value);
            }

        }
        System.out.println(String.format("%.8f", result));
    }
}
