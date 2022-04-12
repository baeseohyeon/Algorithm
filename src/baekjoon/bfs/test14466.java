package baekjoon.bfs;

import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test14466 {

    static int n, k, r;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static List<Point> cows;
    static List<Point>[][] bridges;

    public static void main(String[] args) throws IOException { //https://data-make.tistory.com/522 참고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        r = parseInt(st.nextToken());
        cows = new ArrayList<>();
        bridges = new ArrayList[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bridges[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = parseInt(st.nextToken());
            int y1 = parseInt(st.nextToken());
            int x2 = parseInt(st.nextToken());
            int y2 = parseInt(st.nextToken());
            bridges[x1][y1].add(new Point(x2, y2));
            bridges[x2][y2].add(new Point(x1, y1));
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            cows.add(new Point(x, y));
        }
        int cnt = 0;
        for (int i = 0; i < k - 1; i++) {
            visit = new boolean[n + 1][n + 1];
            Point cow = cows.get(i);
            bfs(cow.x, cow.y);
            for (int j = i + 1; j < k; j++) {
                cow = cows.get(j);
                if (!visit[cow.x][cow.y]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;
        while (!q.isEmpty()) {
            Point cow = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cow.x + dx[i];
                int ny = cow.y + dy[i];
                if (nx < 1 || ny < 1 || nx > n || ny > n || visit[nx][ny] || bridges[cow.x][cow.y]
                    .contains(new Point(nx, ny))) {
                    continue;
                }
                visit[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
    }
}
