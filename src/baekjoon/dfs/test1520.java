package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class test1520 {

    static int n;
    static int m;
    static int arr[][];
    static int dp[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j]=-1;
            }
        }
        System.out.println(solve(0, 0));
    }

    private static int solve(int nowX, int nowY) {
        if (nowX == m - 1 && nowY == n - 1) {
            return 1;
        }
        dp[nowX][nowY] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = nowX + dx[i];
            int nextY = nowY + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || arr[nextX][nextY] >= arr[nowX][nowY]) {
                continue;
            }
            if (dp[nextX][nextY] == -1) {
                dp[nowX][nowY] += solve(nextX, nextY);
            } else if (dp[nextX][nextY] >= 0) {
                dp[nowX][nowY] += dp[nextX][nextY];
            }
        }
        return dp[nowX][nowY];
    }
}
