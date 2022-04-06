package baekjoon.backtracking;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1799 { //https://pangsblog.tistory.com/84

    static char block;
    static int n, ans, bishop;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        block = 'b';
        findBishopPlace(1, 1, 0);
        ans += bishop;
        block = 'w';
        bishop = 0;
        visit = new boolean[n + 1][n + 1];
        findBishopPlace(1, 2, 0);
        System.out.println(ans + bishop);
    }

    private static void findBishopPlace(int x, int y, int cnt) {
        bishop = Math.max(bishop, cnt);
        if (x > n) {
            return;
        }
        if (y > n) { //다음행으로 가야할때
            int nextY = (block == 'b' ? (x % 2 == 0 ? 1 : 2) : (x % 2 == 0 ? 2 : 1));
            findBishopPlace(x + 1, nextY, cnt);
            return;
        }
        if (isRightPlace(x, y)) {
            visit[x][y] = true;
            findBishopPlace(x, y + 2, cnt + 1);
            visit[x][y] = false;
        }
        findBishopPlace(x, y + 2, cnt);
    }

    private static boolean isRightPlace(int x, int y) {
        if (map[x][y] == 0) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;
                if ((nx >= 1 && ny >= 1 && nx <= n && ny <= n) && visit[nx][ny]) {
                    return false;
                }
            }
        }
        return true;
    }
}
