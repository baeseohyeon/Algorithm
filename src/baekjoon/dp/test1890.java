package baekjoon.dp;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int dist = arr[i][j];
                if (dist == 0 || dp[i][j] == 0) {
                    continue;
                }
                if (i + dist < n) {
                    dp[i + dist][j] += dp[i][j];
                }
                if (j + dist < n) {
                    dp[i][j + dist] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }

}
