package baekjoon.dfs;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test13023 {

    static boolean flag;
    static boolean[] visit;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        visit = new boolean[n];
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            visit[i] = true;
            dfs(i, 0);
            visit[i] = false;
            if (flag) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(flag ? 1 : 0);
    }

    private static void dfs(int now, int cnt) {
        if (cnt >= 4) {
            flag = true;
            return;
        }
        for (int next : list[now]) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(next, cnt + 1);
                visit[next] = false;
            }
        }
    }
}

