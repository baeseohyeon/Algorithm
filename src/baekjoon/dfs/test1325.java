package baekjoon.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class test1325 {
    static int n;
    static int m;
    static int max = 0;
    static int[] arr;
    static boolean[] visit;
    static List<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        arr = new int[n + 1];
        visit = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            list[a].add(b);
        }
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            dfs(i);
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] >= max)
                max = arr[i];
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] == max)
                bw.write(i + " ");
        }
        bw.flush();
    }

    private static void dfs(int now) {
        arr[now]++;
        visit[now] = true;
        for (int next : list[now]) {
            if (!visit[next])
                dfs(next);
        }
    }
}
