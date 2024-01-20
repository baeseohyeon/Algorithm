package baekjoon.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Test16946 {

    static int n, m, level;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] levels;
    static boolean[][] visit;
    static int[][] map;
    static Set<Integer>[][] setMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        level = 0;
        levels = new int[1000000];
        visit = new boolean[n][m];
        map = new int[n][m];
        setMap = new HashSet[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
                setMap[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !visit[i][j]) {
                    bfs(i, j);
                    level++;
                }
            }
        }
        int[][] ans = getAns();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(ans[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] getAns() {
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                ans[i][j]++;
                for (int level : setMap[i][j]) {
                    ans[i][j] += levels[level];
                }
                ans[i][j] %= 10;
            }
        }
        return ans;
    }

    private static int bfs(int x, int y) {
        visit[x][y] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        int cnt = 1;
        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 1) {
                    setMap[nx][ny].add(level);
                    continue;
                }
                if (visit[nx][ny]) {
                    continue;
                }
                cnt++;
                visit[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
        levels[level] = cnt;
        return cnt;
    }
}
