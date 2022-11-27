package baekjoon.prefixsum;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test5549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = parseInt(st.nextToken());
        int n = parseInt(st.nextToken());
        int k = parseInt(br.readLine());
        char[][] map = new char[m + 1][n + 1];
        int[][][] arr = new int[m + 1][n + 1][3];
        int[][][] sum = new int[m + 1][n + 1][3];
        for (int i = 1; i <= m; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = s.charAt(j - 1);
                int l = 0;
                if (map[i][j] == 'O') {
                    l = 1;
                } else if (map[i][j] == 'I') {
                    l = 2;
                }
                arr[i][j][l]++;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 0; l < 3; l++) {
                    sum[i][j][l] = arr[i][j][l] + sum[i][j - 1][l] + sum[i - 1][j][l] - sum[i - 1][j - 1][l];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            int d = parseInt(st.nextToken());
            int j = sum[c][d][0] - sum[c][b - 1][0] - sum[a - 1][d][0] + sum[a - 1][b - 1][0];
            int o = sum[c][d][1] - sum[c][b - 1][1] - sum[a - 1][d][1] + sum[a - 1][b - 1][1];
            int i = sum[c][d][2] - sum[c][b - 1][2] - sum[a - 1][d][2] + sum[a - 1][b - 1][2];
            sb.append(j).append(" ").append(o).append(" ").append(i).append("\n");
        }
        System.out.println(sb);
    }
}
