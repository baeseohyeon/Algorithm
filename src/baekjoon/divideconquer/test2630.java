package baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2630 {
    static int[][] map;
    static int[] ans = new int[2];

    public static boolean check(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[x][y] != map[i][j])
                    return false;
            }
        }
        ans[map[x][y]]++;
        return true;
    }

    public static void solve(int x, int y, int size) {
        if (!check(x, y, size)) {
            int nextSize = size / 2;
            solve(x, y, nextSize);
            solve(x, y + nextSize, nextSize);
            solve(x + nextSize, y, nextSize);
            solve(x + nextSize, y + nextSize, nextSize);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, n);
        System.out.print(ans[0] + "\n" + ans[1]);
    }
}
