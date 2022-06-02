package baekjoon.simulation;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test15684 {

    static int n, m, h, num, ans = MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        h = parseInt(st.nextToken());
        map = new int[h + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            map[a][b] = 1;
        }
        solve();
        System.out.println(ans == MAX_VALUE ? -1 : ans);
    }

    private static void solve() {
        for (int i = 0; i <= 3; i++) {
            num = i;
            addRadder(1, 1, i);
            if (ans != MAX_VALUE) {
                return;
            }
        }
    }

    private static void addRadder(int x, int y, int cnt) {
        if (x > h) {
            return;
        }
        if (y > n) {
            addRadder(x + 1, 1, cnt);
            return;
        }
        if (cnt == 0) {
            if (isRightRadder()) {
                ans = Math.min(ans, num);
            }
            return;
        }
        if (map[x][y] != 1) {
            map[x][y] = 1;
            addRadder(x, y + 1, cnt - 1);
            map[x][y] = 0;
        }
        addRadder(x, y + 1, cnt);
    }

    private static boolean isRightRadder() {
        for (int i = 1; i <= n; i++) {
            int now = 1;
            int j = i;
            while (now <= h && j <= n) {
                if (map[now][j] == 1) {
                    j = j + 1;
                } else if (map[now][j - 1] == 1) {
                    j = j - 1;
                }
                now++;
            }
            if (j != i) {
                return false;
            }
        }
        return true;
    }
}
