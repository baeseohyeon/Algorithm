package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class test17471 {
    static int n;
    static int end;
    static int ans = -1;
    static int[] point;
    static int[] team;
    static int[] people;
    static boolean[] visit; //인접 노드 방문 체크
    static boolean[] check; //부분집합 방문 체크
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        people = new int[n + 1];
        list = new ArrayList[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                list[i].add(parseInt(st.nextToken()));
            }
        }
        for (int i = 1; i <= n / 2; i++) {
            end = i;
            check = new boolean[n + 1];
            comb(0, 0);
        }
        System.out.println(ans);
    }

    private static void comb(int now, int cnt) {
        if (cnt == end) {
            team = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (check[i]) {
                    team[i] = 1;
                }
            }
            checkTeam();
        } else {
            for (int i = now + 1; i <= n; i++) {
                check[i] = true;
                comb(i, cnt + 1);
                check[i] = false;
            }
        }
    }

    private static void checkTeam() {
        point = new int[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visit[i] && team[i] == 1) {
                dfs(i);
                break;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i] && team[i] == 0) {
                dfs(i);
                break;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i])
                return;
        }
        int num = Math.abs(point[0] - point[1]);
        ans = ans == -1 ? num : Math.min(ans, num);
    }

    private static void dfs(int now) {
        visit[now] = true;
        point[team[now]] += people[now];
        for (int next : list[now]) {
            if (!visit[next] && team[now] == team[next]) {
                dfs(next);
            }
        }
    }

}
