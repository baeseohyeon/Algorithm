package baekjoon.bruteforce;

import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test17086 {

    static int n, m, ans;
    static List<Point> list;
    static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    list.add(new Point(i, j));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) {
                    continue;
                }
                ans = Math.max(ans, bfs(i, j));
            }
        }
        System.out.println(ans);
    }

    private static int bfs(int x, int y) {
        dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[x][y] = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point now = q.poll();
            x = now.x;
            y = now.y;
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || ny < 1 || nx > n || ny > m || dp[nx][ny] != -1) {
                    continue;
                }
                q.add(new Point(nx, ny));
                dp[nx][ny] = dp[x][y] + 1;
                if (map[nx][ny] == 1) {
                    return dp[nx][ny];
                }
            }
        }
        return 0;
    }
}

