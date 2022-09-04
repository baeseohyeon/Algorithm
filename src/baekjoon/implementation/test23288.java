package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test23288 {

    static int n, m, k, point, d = 1;
    static int west = 4, east = 3, north = 2, south = 5, top = 1, bottom = 6;
    static int[][] map;
    static int[][] numArr;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        map = new int[n][m];
        numArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(point);
    }

    private static void setNextDirection(int nx, int ny) {
        if (bottom > map[nx][ny]) {
            d = (d + 1) % 4;
        } else if (bottom < map[nx][ny]) {
            d = d - 1 < 0 ? 3 : d - 1;
        }
    }

    public static int getCount(int x, int y) {
        visit = new boolean[n][m];
        visit[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int cnt = 1;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isOut(nx, ny) || visit[nx][ny] || map[x][y] != map[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                cnt++;
                queue.add(new Point(nx, ny));
            }
        }
        return cnt;
    }

    private static void addPoint(int x, int y) {
        point += map[x][y] * getCount(x, y);
    }

    private static void changeDiceNum() {
        int tmp;
        switch (d) {
            case 0: //위쪽
                tmp = top;
                top = south;
                south = bottom;
                bottom = north;
                north = tmp;
                break;
            case 1: //오른쪽
                tmp = east;
                east = top;
                top = west;
                west = bottom;
                bottom = tmp;
                break;
            case 2: //아래쪽
                tmp = bottom;
                bottom = south;
                south = top;
                top = north;
                north = tmp;
                break;
            case 3: //왼쪽
                tmp = west;
                west = top;
                top = east;
                east = bottom;
                bottom = tmp;
        }
    }

    private static void moveDice() {
        int x = 0, y = 0;
        while (k-- > 0) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (isOut(nx, ny)) {
                d = (d + 2) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            changeDiceNum();
            addPoint(nx, ny);
            setNextDirection(nx, ny);
            x = nx;
            y = ny;
        }
    }

    private static boolean isOut(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= n || ny >= m;
    }

    private static void solution() {
        moveDice();
    }
}
