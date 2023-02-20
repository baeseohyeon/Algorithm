package programmers.level2;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dp;

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    q.add(new Point(i, j));
                    dp[i][j] = 0;
                    break;
                }
            }
        }
        while (!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            if (maps[x].charAt(y) == 'L') {
                answer += dp[x][y];
                for (int i = 0; i < n; i++) {
                    Arrays.fill(dp[i], -1);
                }
                dp[x][y] = 0;
                q.clear();
                q.add(new Point(x, y));
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx].charAt(ny) == 'X' || dp[nx][ny] != -1) {
                    continue;
                }
                dp[nx][ny] = dp[x][y] + 1;
                q.add(new Point(nx, ny));
            }
        }

        while (!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            if (maps[x].charAt(y) == 'E') {
                return answer + dp[x][y];
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx].charAt(ny) == 'X' || dp[nx][ny] != -1) {
                    continue;
                }
                dp[nx][ny] = dp[x][y] + 1;
                q.add(new Point(nx, ny));
            }
        }
        return -1;
    }
}
