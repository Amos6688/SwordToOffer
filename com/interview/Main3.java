package com.interview;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 华为机试题3
 * 要求：扔 n 个骰子，向上面的数字之和为 S。给定 Given n，请列出所有可能的 S 值及其相应的概率。
 *
 * @author chuan
 */
public class Main3 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            List<Map.Entry<Integer, String>> result = dicesSum(n);
            for (int i = 0; i < result.size(); ++i) {
                Map.Entry<Integer, String> map = result.get(i);
                if (i == 0)
                    System.out.print("[[" + map.getKey() + ", " + map.getValue() + "], ");
                else if (i == result.size() - 1)
                    System.out.println("[" + map.getKey() + ", " + map.getValue() + "]]");
                else {
                    System.out.print("[" + map.getKey() + ", " + map.getValue() + "], ");
                }

            }
        }
    }

    public static List<Map.Entry<Integer, String>> dicesSum(int n) {

        DecimalFormat df = new DecimalFormat("0.00000");
        long[][] dp = new long[n + 1][6 * n + 1];
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        dp[1][5] = 1;
        dp[1][6] = 1;
        //计算2个以上骰子可能出现的和及其对应的次数
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                long x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0;
                if (j - 1 > 0) {
                    x1 = dp[i - 1][j - 1];
                }
                if (j - 2 > 0) {
                    x2 = dp[i - 1][j - 2];
                }
                if (j - 3 > 0) {
                    x3 = dp[i - 1][j - 3];
                }
                if (j - 4 > 0) {
                    x4 = dp[i - 1][j - 4];
                }
                if (j - 5 > 0) {
                    x5 = dp[i - 1][j - 5];
                }
                if (j - 6 > 0) {
                    x6 = dp[i - 1][j - 6];
                }
                dp[i][j] = x1 + x2 + x3 + x4 + x5 + x6;
            }
        }
        List<Map.Entry<Integer, String>> result = new ArrayList<>();
        for (int i = n; i <= 6 * n; i++) {
            AbstractMap.SimpleEntry<Integer, String> entry = new AbstractMap.SimpleEntry<>(i, df.format(dp[n][i] / Math.pow(6, n)));
            result.add(entry);
        }
        return result;
    }
}