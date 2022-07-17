package baekjoon.bfs;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test17836 {

    static int n, m, t;
    static int[][] map;
    static int[][][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Human {

        int x, y, time, sword;

        Human(int x, int y, int time, int sword) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.sword = sword;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        t = parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        int ans = bfs(1, 1);
        System.out.println(ans == MAX_VALUE ? "Fail" : ans);
    }

    private static int bfs(int x, int y) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], MAX_VALUE);
            }
        }
        Queue<Human> q = new LinkedList<>();
        q.add(new Human(x, y, 0, 0));
        dp[x][y][0] = 0;
        while (!q.isEmpty()) {
            Human now = q.poll();
            x = now.x;
            y = now.y;
            int time = now.time;
            int sword = now.sword;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || ny < 1 || nx > n || ny > m || (sword == 0 && map[nx][ny] == 1) || time >= t) {
                    continue;
                }
                if (map[nx][ny] == 2) {
                    if (dp[nx][ny][1] > dp[x][y][sword] + 1) {
                        dp[nx][ny][1] = dp[x][y][sword] + 1;
                        q.add(new Human(nx, ny, time + 1, 1));
                    }
                }
                if (dp[nx][ny][sword] > dp[x][y][sword] + 1) {
                    dp[nx][ny][sword] = dp[x][y][sword] + 1;
                    q.add(new Human(nx, ny, time + 1, sword));
                }
            }
        }
        return Math.min(dp[n][m][0], dp[n][m][1]);
    }
}
