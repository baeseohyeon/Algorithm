package baekjoon.backtracking;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2580 {

    static int n = 9;
    static boolean flag = false;
    static int[][] map = new int[n][n];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        dfs(0, 0);

    }

    private static void dfs(int x, int y) {
        if (flag) {
            return;
        }
        if (x >= n) {
            flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        if (y >= n) {
            dfs(x + 1, 0);
            return;
        }
        if (map[x][y] != 0) {
            dfs(x, y + 1);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            map[x][y] = i;
            if (check(x, y)) {
                dfs(x, y + 1);
            }
            map[x][y] = 0;
        }

    }

    private static boolean check(int x, int y) {
        int num = map[x][y];
        for (int i = 0; i < n; i++) { //가로 체크
            if (i == y) {
                continue;
            }
            if (map[x][i] == num) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) { //세로 체크
            if (i == x) {
                continue;
            }
            if (map[i][y] == num) {
                return false;
            }
        }
        for (int i = 3 * (x / 3); i < 3 * (x / 3) + 3; i++) {
            for (int j = 3 * (y / 3); j < 3 * (y / 3) + 3; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (map[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

}
