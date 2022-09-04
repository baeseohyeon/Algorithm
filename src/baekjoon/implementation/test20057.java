package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test20057 {

    static int n;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] dx2 = {
        {-1, 1, -1, 1, -1, 1, -2, 2, 0},
        {1, 1, 0, 0, -1, -1, 0, 0, 2},
        {-1, 1, -1, 1, -1, 1, -2, 2, 0},
        {-1, -1, 0, 0, 1, 1, 0, 0, -2}
    };
    static int[][] dy2 = {
        {-1, -1, 0, 0, 1, 1, 0, 0, -2},
        {-1, 1, -1, 1, -1, 1, -2, 2, 0},
        {1, 1, 0, 0, -1, -1, 0, 0, 2},
        {-1, 1, -1, 1, -1, 1, -2, 2, 0}
    };
    static int[] percent = {10, 10, 7, 7, 1, 1, 2, 2, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        int x = n / 2, y = n / 2;
        int cnt = 1, d = 0;
        int ans = 0;
        while (true) {
            for (int i = 0; i < cnt; i++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int sand = map[nx][ny];
                int lost = 0, sum = 0;
                for (int j = 0; j < 9; j++) {
                    int nx2 = nx + dx2[d][j];
                    int ny2 = ny + dy2[d][j];
                    int powder = sand * percent[j] / 100;
                    sum += powder;
                    if (isIn(nx2, ny2)) {
                        map[nx2][ny2] += powder;
                    } else { //맵 밖으로 날라갔을때
                        lost += powder;
                    }
                }
                if (isIn(nx + dx[d], ny + dy[d])) {
                    map[nx + dx[d]][ny + dy[d]] += map[nx][ny] - sum;
                } else { //맵 밖으로 날라갔을때
                    lost += map[nx][ny] - sum;
                }
                x = nx;
                y = ny;
                ans += lost;
                if (x == 0 && y == 0) {
                    System.out.println(ans);
                    return;
                }
            }
            d = (d + 1) % 4;
            if (d % 2 == 0) {
                cnt++;
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
