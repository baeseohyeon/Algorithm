package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test16930 {

    public static class XY {

        int x, y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = -1;
        boolean visit[][] = new boolean[n + 1][m + 1];
        int dp[][] = new int[n + 1][m + 1];
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int MAX_NUM = 1000000;
        char map[][] = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = s.charAt(j - 1);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = MAX_NUM;
            }
        }
        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        Queue<XY> q = new LinkedList<>();
        q.add(new XY(sx, sy));
        dp[sx][sy] = 0;
        while (!q.isEmpty()) {
            XY xy = q.poll();
            int x = xy.x;
            int y = xy.y;
            if (x == ex && y == ey) {
                ans = dp[x][y];
                break;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= k; j++) {
                    int nx = x + (dx[i] * j);
                    int ny = y + (dy[i] * j);
                    if (nx < 1 || ny < 1 || nx > n || ny > m || map[nx][ny] == '#' || dp[nx][ny] <= dp[x][y]) {
                        break;
                    }
                    if (dp[nx][ny] == MAX_NUM) {
                        dp[nx][ny] = dp[x][y] + 1;
                        q.add(new XY(nx, ny));
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
