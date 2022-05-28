package baekjoon.simulation;

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

public class test21610 {

    static int n, m;
    static int[][] map;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static Queue<Point> beforeQ;
    static List<Point> movedList;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        map = new int[n][n];
        beforeQ = new LinkedList<>();
        movedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        beforeQ.add(new Point(n - 1, 0));
        beforeQ.add(new Point(n - 1, 1));
        beforeQ.add(new Point(n - 2, 0));
        beforeQ.add(new Point(n - 2, 1));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = parseInt(st.nextToken());
            int s = parseInt(st.nextToken());
            moveCloud(d, s);
            copyWater();
            setNextCloud();
            movedList.clear();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += map[i][j];
            }
        }
        System.out.println(ans);
    }

    private static void setNextCloud() {
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (map[a][b] >= 2 && !movedList.contains(new Point(a, b))) {
                    beforeQ.add(new Point(a, b));
                    map[a][b] -= 2;
                }
            }
        }
    }

    private static void copyWater() {
        for (Point point : movedList) {
            int cnt = 0;
            for (int j = 2; j <= 8; j += 2) {
                int nx = point.x + dx[j];
                int ny = point.y + dy[j];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (map[nx][ny] > 0) {
                    cnt++;
                }
            }
            map[point.x][point.y] += cnt;
        }
    }

    private static void moveCloud(int d, int s) {
        while (!beforeQ.isEmpty()) {
            Point now = beforeQ.poll();
            int x = now.x;
            int y = now.y;
            int nx = (x + n + dx[d] * (s % n)) % n;
            int ny = (y + n + dy[d] * (s % n)) % n;
            map[nx][ny]++;
            movedList.add(new Point(nx, ny));
        }
    }
}

