package baekjoon.backtracking;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1189 {

    static int r, c, k, ans;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = parseInt(st.nextToken());
        c = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        map = new char[r][c];
        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        dfs(r - 1, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int cnt) {
        if (x == 0 && y == c - 1) {
            if (cnt == k) {
                ans++;
            }
            return;
        }
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= r || ny >= c || visit[nx][ny] || map[nx][ny] == 'T') {
                continue;
            }
            dfs(nx, ny, cnt + 1);
        }
        visit[x][y] = false;
    }
}
