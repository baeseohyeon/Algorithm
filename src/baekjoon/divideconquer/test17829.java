package baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.*;

public class test17829 {
    static int[][] map;

    public static int solve(int x, int y, int size) {
        int[] arr;
        if (size == 2) {
            arr = new int[]{map[x][y], map[x][y + 1], map[x + 1][y], map[x + 1][y + 1]};
        } else {
            arr = new int[]{solve(x, y, size / 2), solve(x, y + size / 2, size / 2),
                    solve(x + size / 2, y, size / 2), solve(x + size / 2, y + size / 2, size / 2)};
        }
        Arrays.sort(arr);
        return arr[2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        System.out.println(solve(0, 0, n));
    }
}