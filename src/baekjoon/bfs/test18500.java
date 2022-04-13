package baekjoon.bfs;

import static java.lang.Integer.*;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test18500 { //https://geniusjo-story.tistory.com/442

    static int r, c, n, turn, h;
    static char[][] map;
    static boolean[][] visit;
    static List<Point> cluster;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = parseInt(st.nextToken());
        c = parseInt(st.nextToken());
        map = new char[r][c];
        cluster = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        n = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int height = parseInt(st.nextToken());
            throwStick(height);
            turn++;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void throwStick(int height) {
        if (isMineralBroken(height)) {
            checkCluster();
        }
    }

    private static boolean isMineralBroken(int height) {
        if (turn % 2 == 0) { //왼쪽에서 던질때
            for (int i = 0; i < c; i++) {
                if (map[r - height][i] == 'x') {
                    map[r - height][i] = '.';
                    return true;
                }
            }
        } else {
            for (int i = c - 1; i >= 0; i--) {
                if (map[r - height][i] == 'x') {
                    map[r - height][i] = '.';
                    return true;
                }
            }
        }
        return false;
    }

    private static void checkCluster() {
        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'x' && !visit[i][j]) {
                    findClusterIdx(i, j);
                    if (h < r - 1) { //공중에 떠있음
                        moveCluster();
                        return;
                    }
                }
            }
        }
    }

    private static void findClusterIdx(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        cluster = new ArrayList<>();
        q.add(new Point(x, y));
        cluster.add(new Point(x, y));
        visit[x][y] = true;
        h = x;
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c || visit[nx][ny] || map[nx][ny] != 'x') {
                    continue;
                }
                q.add(new Point(nx, ny));
                cluster.add(new Point(nx, ny));
                visit[nx][ny] = true;
                h = Math.max(h, nx);
            }
        }
    }

    private static void moveCluster() {
        boolean flag = true;
        for (Point point : cluster) {
            map[point.x][point.y] = '.';
        }
        while (true) { //한칸씩 이동하면서 확인
            for (Point point : cluster) {
                if (point.x + 1 >= r || map[point.x + 1][point.y] == 'x') {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            for (Point point : cluster) {
                point.x++;
            }
        }
        for (Point point : cluster) {
            map[point.x][point.y] = 'x';
        }
    }
}
