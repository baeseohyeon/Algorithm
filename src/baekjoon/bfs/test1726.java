package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.*;

public class test1726 {

    static class Pair {
        int x, y, d;

        Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int n;
    static int m;
    static int ex, ey, ed;
    static int[][] map;
    static int[][][] dp;
    static Queue<Pair> q;
    static int[] dx = {-1, 0, 1, 0}; //북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], MAX_VALUE);
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        String[] start = br.readLine().split(" ");
        String[] end = br.readLine().split(" ");
        int sx = parseInt(start[0]), sy = parseInt(start[1]), sd = parseInt(start[2]);
        q = new LinkedList<>();
        ex = parseInt(end[0]);
        ey = parseInt(end[1]);
        ed = parseInt(end[2]);
        if (sd == 2)
            sd = 3;
        else if (sd == 3)
            sd = 2;
        else if (sd == 4)
            sd = 0;
        if (ed == 2)
            ed = 3;
        else if (ed == 3)
            ed = 2;
        else if (ed == 4)
            ed = 0;
        q.add(new Pair(sx - 1, sy - 1, sd));
        dp[sx - 1][sy - 1][sd] = 0;
        while (!q.isEmpty()) {
            Pair now = q.poll();
            int x = now.x;
            int y = now.y;
            int d = now.d;
            int cnt = dp[x][y][d];
            if (x == ex - 1 && y == ey - 1 && d == ed) {
                System.out.println(cnt);
                return;
            }
            int ld = d - 1 < 0 ? 3 : d - 1;
            int rd = d + 1 > 3 ? 0 : d + 1;
            if (dp[x][y][ld] > dp[x][y][d] + 1) {
                dp[x][y][ld] = dp[x][y][d] + 1;
                q.add(new Pair(x,y,ld));
            }
            if (dp[x][y][rd] > dp[x][y][d] + 1) {
                dp[x][y][rd] = dp[x][y][d] + 1;
                q.add(new Pair(x,y,rd));
            }
            for (int i = 1; i <= 3; i++) {
                int nx = x + dx[d] * i;
                int ny = y + dy[d] * i;
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 1)
                    break;
                if(dp[nx][ny][d] > cnt+1) {
                    dp[nx][ny][d] = cnt + 1;
                    q.add(new Pair(nx, ny, d));
                }
            }
        }
    }
}
