package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class test14442 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        int x, y, w;

        Pair(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());
        String[] map = new String[n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }
        int[][][] dp = new int[n][m][k + 1];
        int ans = -1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0));
        dp[0][0][0] = 1;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;
            int w = pair.w;
            if (x == n - 1 && y == m - 1) {
                ans = dp[x][y][w];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                char next = map[nx].charAt(ny);
                if (next == '0' && dp[nx][ny][w] == 0) {
                    dp[nx][ny][w] = dp[x][y][w] + 1;
                    q.add(new Pair(nx, ny, w));
                } else if (next == '1' && w < k && dp[nx][ny][w + 1] == 0) {
                    dp[nx][ny][w + 1] = dp[x][y][w] + 1;
                    q.add(new Pair(nx, ny, w + 1));
                }
            }
        }
        System.out.println(ans);

    }
}
