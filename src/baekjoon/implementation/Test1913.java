package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1913 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int target = parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int x = n / 2, y = n / 2;
        int num = 1;
        int d = 0;
        int cnt = 0, turn = 1;
        while (num <= n * n) {
            arr[x][y] = num++;
            cnt++;
            x = x + dx[d];
            y = y + dy[d];
            if (cnt == turn) {
                d = (d + 1) % 4;
                if (d % 2 == 0) {
                    turn++;
                }
                cnt = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
                if (arr[i][j] == target) {
                    x = i + 1;
                    y = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }
}
