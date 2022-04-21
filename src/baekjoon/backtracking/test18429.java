package baekjoon.backtracking;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test18429 {

    static int n, k, ans;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        arr = new int[n + 1];
        visit = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        dfs(0, 500);
        System.out.println(ans);
    }

    private static void dfs(int now, int weight) {
        if (now == n) {
            ans++;
            return;
        }
        for (int next = 1; next <= n; next++) {
            int nextWeight = weight + (arr[next] - k);
            if (!visit[next] && nextWeight >= 500) {
                visit[next] = true;
                dfs(now + 1, nextWeight);
                visit[next] = false;
            }
        }
    }
}
