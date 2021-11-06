package baekjoon.bfs;

import java.util.*;

public class test2665 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map[i] = s.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = Integer.MAX_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        dp[0][0] = 0;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;
            if (x == n - 1 && y == n - 1) {
                ans = Math.min(ans, dp[x][y]);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if (map[nx][ny] == '1' && (dp[nx][ny] > dp[x][y] || dp[nx][ny] == -1)) {
                    dp[nx][ny] = dp[x][y];
                    q.add(new Pair(nx, ny));
                } else if (map[nx][ny] == '0' && (dp[nx][ny] > dp[x][y] + 1 || dp[nx][ny] == -1)) {
                    dp[nx][ny] = dp[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }
        System.out.println(ans);
    }
}
