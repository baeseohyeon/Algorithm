package baekjoon.backtracking;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test18430 {

    static int n, m, ans;
    static int[][] dx = {{0, 1}, {-1, 0}, {-1, 0}, {0, 1}};
    static int[][] dy = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        dfs(1, 1, 0);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int cnt) {
        if (x > n) {
            ans = Math.max(ans, cnt);
            return;
        }
        if (y > m) {
            dfs(x + 1, 1, cnt);
            return;
        }
        if (!visit[x][y]) {
            visit[x][y] = true;
            int now = map[x][y] * 2;
            for (int i = 0; i < 4; i++) {
                int x1 = x + dx[i][0];
                int y1 = y + dy[i][0];
                int x2 = x + dx[i][1];
                int y2 = y + dy[i][1];
                if (isOut(x1, y1, x2, y2) || visit[x1][y1] || visit[x2][y2]) {
                    continue;
                }
                visit[x1][y1] = true;
                visit[x2][y2] = true;
                dfs(x, y + 1, cnt + now + map[x1][y1] + map[x2][y2]);
                visit[x1][y1] = false;
                visit[x2][y2] = false;
            }
            visit[x][y] = false;
        }
        dfs(x, y + 1, cnt);
    }

    private static boolean isOut(int x1, int y1, int x2, int y2) {
        if (x1 < 1 || y1 < 1 || x1 > n || y1 > m || x2 < 1 || y2 < 1 || x2 > n || y2 > m) {
            return true;
        }
        return false;
    }
}
