package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test18808 {

    static int n, m, k;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        map = new boolean[n][m];
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            boolean[][] sticker = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    if (parseInt(st.nextToken()) == 1) {
                        sticker[i][j] = true;
                    }
                }
            }
            solve(r, c, sticker);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void solve(int r, int c, boolean[][] sticker) {
        for (int cnt = 0; cnt < 4; cnt++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (isPut(i, j, sticker)) {
                        putSticker(i, j, sticker);
                        return;
                    }
                }
            }
            sticker = getRotateSticker(r, c, sticker);
            r = sticker.length;
            c = sticker[0].length;
        }
    }

    private static void putSticker(int x, int y, boolean[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j]) {
                    map[x + i][y + j] = sticker[i][j];
                }
            }
        }
    }

    private static boolean isPut(int x, int y, boolean[][] sticker) {
        int r = sticker.length, c = sticker[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int nx = x + i;
                int ny = y + j;
                if (isOut(nx, ny) || (map[nx][ny] && sticker[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isOut(int x, int y) {
        return x >= n || y >= m;
    }

    private static boolean[][] getRotateSticker(int r, int c, boolean[][] sticker) {
        boolean[][] tmp = new boolean[c][r];
        int a = 0, b = r - 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tmp[a++][b] = sticker[i][j];
            }
            a = 0;
            b--;
        }
        return tmp;
    }
}
