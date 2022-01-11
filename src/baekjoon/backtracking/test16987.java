package baekjoon.backtracking;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test16987 {

    static class Egg {

        int durability;
        int weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

    }

    static int n, ans;
    static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        eggs = new Egg[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(parseInt(st.nextToken()), parseInt(st.nextToken()));
        }
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int now, int cnt) {
        if (now == n) {
            ans = Math.max(ans, cnt);
            return;
        }
        if (eggs[now].durability <= 0) {
            dfs(now + 1, cnt);
            return;
        }
        boolean flag = false;
        for (int next = 0; next < n; next++) {
            int nowCnt = 0;
            int nextCnt = 0;
            if (now == next) {
                continue;
            }
            if (eggs[next].durability > 0) {
                flag = true;
                eggs[now].durability -= eggs[next].weight;
                eggs[next].durability -= eggs[now].weight;
                if (eggs[now].durability <= 0) {
                    nowCnt = 1;
                }
                if (eggs[next].durability <= 0) {
                    nextCnt = 1;
                }
                dfs(now + 1, cnt + nowCnt + nextCnt);
                eggs[now].durability += eggs[next].weight;
                eggs[next].durability += eggs[now].weight;
            }
        }
        if (!flag) {
            dfs(now + 1, cnt);
        }
    }

}
