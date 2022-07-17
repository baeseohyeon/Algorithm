package baekjoon.datastructure;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class test5568 {

    static int n, k;
    static String[] nums;
    static boolean[] visit;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        k = parseInt(br.readLine());
        nums = new String[n + 1];
        visit = new boolean[n + 1];
        set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            nums[i] = br.readLine();
        }
        dfs("", 0);
        System.out.println(set.size());
        br.close();
    }

    public static void dfs(String num, int cnt) {
        if (cnt == k) {
            set.add(num);
            return;
        }
        for (int next = 1; next <= n; next++) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(num + nums[next], cnt + 1);
                visit[next] = false;
            }
        }
    }
}
