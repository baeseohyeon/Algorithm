package baekjoon.backtracking;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test20819 {

    static int n, MIN = -10000, ans = MIN;
    static int[] arr;
    static int[] tmp;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        Arrays.fill(tmp, MIN);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            visit[i] = true;
            dfs(0, arr[i]);
            visit[i] = false;
        }
        System.out.println(ans);
    }

    private static void dfs(int now, int num) {
        tmp[now] = num;
        if (now == n - 1) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(tmp[i] - tmp[i + 1]);
            }
            ans = Math.max(ans, sum);
        } else if (now < n - 1) {
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(now + 1, arr[i]);
                    visit[i] = false;
                }
            }
        }
    }

}
