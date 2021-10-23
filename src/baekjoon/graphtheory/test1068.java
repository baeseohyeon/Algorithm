package baekjoon.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class test1068 {


    static int target;
    static int ans = 0;
    static boolean[] visit;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int start = 0;
        visit = new boolean[n];
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = parseInt(st.nextToken());
            if (v == -1) {
                start = i;
                continue;
            }
            list[v].add(i);
        }
        target = parseInt(br.readLine());
        if(start == target)
            System.out.println(0);
        else {
            dfs(start);
            System.out.println(ans);
        }
    }

    private static void dfs(int now) {
        visit[now] = true;
        if (list[now].contains(target)) {
            list[now].remove((Integer) target);
        }
        if (list[now].size() == 0) {
            ans++;
            return;
        }
        for (int i = 0; i < list[now].size(); i++) {
            int next = list[now].get(i);
            if (!visit[next]) {
                dfs(next);
            }
        }
    }
}
