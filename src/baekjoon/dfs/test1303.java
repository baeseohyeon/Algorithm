package baekjoon.dfs;

import java.util.Scanner;

public class test1303 {

    static int n, m, cnt, w, b;
    static char now;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visit = new boolean[n][m];
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map[i] = s.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    cnt = 0;
                    now = map[i][j];
                    dfs(i, j);
                    if (now == 'W') {
                        w += cnt * cnt;
                    } else {
                        b += cnt * cnt;
                    }
                }
            }
        }
        System.out.println(w + " " + b);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny]) {
                continue;
            }
            if (now == map[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
