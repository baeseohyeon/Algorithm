package baekjoon.floyd;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1956 {

    static int v, e, MAX = 99999999;
    static int[][] map;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = parseInt(st.nextToken());
        e = parseInt(st.nextToken());
        map = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            Arrays.fill(map[i], MAX);
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            map[a][b] = c;
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        int ans = MAX;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) {
                    continue;
                }
                if (map[i][j] != MAX && map[j][i] != MAX) {
                    ans = Math.min(map[i][j] + map[j][i], ans);
                }
            }
        }
        System.out.println(ans == MAX ? -1 : ans);
    }
}
