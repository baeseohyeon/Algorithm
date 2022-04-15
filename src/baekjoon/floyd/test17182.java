package baekjoon.floyd;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test17182 {

    static int n, k, ans = MAX_VALUE;
    static int[] distance;
    static boolean[] visit;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        distance = new int[n];
        visit = new boolean[n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int weight = parseInt(st.nextToken());
                map[i][j] = weight;
            }
        }
        floyd();
        dfs(k, 0, 0);
        System.out.println(ans);
    }

    private static void dfs(int now, int cnt, int sum) {
        if (cnt == n - 1) {
            ans = Math.min(ans, sum);
            return;
        }
        visit[now] = true;
        for (int next = 0; next < n; next++) {
            if (!visit[next]) {
                dfs(next, cnt + 1, sum + map[now][next]);
            }
        }
        visit[now] = false;
    }

    private static void floyd() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }
    }
}
