package baekjoon.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.*;

public class test17142 {

    static int ans = MAX_VALUE;
    static int n;
    static int m;
    static int zero = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static List<Pair> viruses;
    static List<Pair> activateViruses;

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        map = new int[n][n];
        viruses = new ArrayList<>();
        activateViruses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    viruses.add(new Pair(i, j));
                }
                if (map[i][j] == 0) {
                    zero++;
                }
            }
        }
        if (zero > 0) {
            checkVirus(0, 0);
            if (ans == MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(ans);
        } else {
            System.out.println(0);
        }
    }

    private static void checkVirus(int now, int cnt) {
        if (cnt == m) {
            bfs();
        } else if (cnt < m) {
            for (int i = now; i < viruses.size(); i++) {
                if (!activateViruses.contains(viruses.get(i))) {
                    activateViruses.add(viruses.get(i));
                    checkVirus(i + 1, cnt + 1);
                    activateViruses.remove(viruses.get(i));
                }
            }
        }
    }

    private static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        int num = 0, subZero = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (Pair activateVirus : activateViruses) {
            q.add(activateVirus);
            dp[activateVirus.x][activateVirus.y] = 0;
        }
        while (!q.isEmpty()) {
            Pair now = q.poll();
            int x = now.x;
            int y = now.y;
            num = Math.max(num, dp[x][y]);
            if (map[x][y] == 0)
                subZero++;
            if (subZero == zero) {
                ans = Math.min(ans, num);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || dp[nx][ny] != -1 || map[nx][ny] == 1)
                    continue;
                dp[nx][ny] = dp[x][y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
    }
}
