package baekjoon.dp;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = parseInt(br.readLine());
        int[] dp = new int[x + 1];
        int[] prev = new int[x + 1];
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[x]).append("\n");
        while (x > 0) {
            sb.append(x).append(" ");
            x = prev[x];
        }
        System.out.println(sb);
    }
}
