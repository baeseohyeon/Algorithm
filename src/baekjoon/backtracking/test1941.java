package baekjoon.backtracking;

import java.util.Scanner;

public class test1941 {
    static int ans, cnt;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new char[5][5];
        visit = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < 25; i++) {
            visit[i / 5][i % 5] = true;
            dfs(i, 0, 1);
            visit[i / 5][i % 5] = false;
        }
        System.out.println(ans);
    }

    public static void dfs(int now, int S, int cnt) {
        if (map[now / 5][now % 5] == 'S')
            S++;
        if (cnt == 7) {
            if (S >= 4) {
                check();
            }
            return;
        }
        for (int i = now + 1; i < 25; i++) {
            if (!visit[i / 5][i % 5]) {
                visit[i / 5][i % 5] = true;
                dfs(i, S, cnt + 1);
                visit[i / 5][i % 5] = false;
            }
        }
    }

    private static void check() {
        for (int i = 0; i < 25; i++) {
            if (visit[i / 5][i % 5]) {
                boolean[][] finish = new boolean[5][5];
                cnt = 1;
                find(i / 5, i % 5, finish);
                return;
            }
        }
    }

    private static void find(int x, int y, boolean[][] finish) {
        finish[x][y] = true;
        if (cnt == 7) {
            ans++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || finish[nx][ny] || !visit[nx][ny])
                continue;
            cnt++;
            find(nx, ny, finish);
        }
    }
}
