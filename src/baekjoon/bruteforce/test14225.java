package baekjoon.bruteforce;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test14225 {

    static int n;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        arr = new int[n + 1];
        visit = new boolean[2000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        dfs(0, 0);
        for (int i = 1; ; i++) {
            if (!visit[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    public static void dfs(int now, int num) {
        visit[num] = true;
        for (int i = now + 1; i <= n; i++) {
            dfs(i, num + arr[i]);
        }
    }
}
