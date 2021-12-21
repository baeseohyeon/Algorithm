package baekjoon.dp;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test14863 { //https://hororolol.tistory.com/151 참고

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());
        int[][] arr = new int[n][4];
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = parseInt(st.nextToken());
            arr[i][1] = parseInt(st.nextToken());
            arr[i][2] = parseInt(st.nextToken());
            arr[i][3] = parseInt(st.nextToken());
        }
        dp[0][arr[0][0]] = arr[0][1];
        dp[0][arr[0][2]] = Math.max(dp[0][arr[0][2]],arr[0][3]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                int wTime = arr[i][0];
                int wMoney = arr[i][1];
                int bTime = arr[i][2];
                int bMoney = arr[i][3];
                if (dp[i - 1][j] == 0) {
                    continue;
                }
                if (j + wTime <= k) {
                    dp[i][j + wTime] = Math.max(dp[i - 1][j] + wMoney, dp[i][j + wTime]);
                }
                if (j + bTime <= k) {
                    dp[i][j + bTime] = Math.max(dp[i - 1][j] + bMoney, dp[i][j + bTime]);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = Math.max(ans, dp[n - 1][i]);
        }
        System.out.println(ans);
    }

}

