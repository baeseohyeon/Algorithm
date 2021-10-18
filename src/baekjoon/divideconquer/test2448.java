package baekjoon.divideconquer;


import java.util.Arrays;
import java.util.Scanner;

public class test2448 {


    static char[][] map;

    public static void solve(int x, int y, int n) {
        if (n >= 4) {
            solve(x, y, n / 2);
            solve(x + n / 2, y - n / 2, n / 2);
            solve(x + n / 2, y + n / 2, n / 2);
        } else {
            map[x][y] = '*';
            map[x + 1][y - 1] = map[x + 1][y + 1] = '*';
            map[x + 2][y - 2] = map[x + 2][y - 1] = map[x + 2][y] = map[x + 2][y + 1] = map[x + 2][y + 2] = '*';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new char[n][n * 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], ' ');
        }
        solve(0, n - 1, n);
        for (int i = 0; i < n; i++) {
            System.out.println(map[i]);
        }
    }

}
