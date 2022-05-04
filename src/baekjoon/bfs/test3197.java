package baekjoon.bfs;

import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test3197 {

    static int r, c, day;
    static int[][] dp;
    static int[][] meltDay;
    static char[][] map;
    static boolean[][] visit;
    static Point[] swans;
    static Queue<Point> iceQ;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = parseInt(st.nextToken());
        c = parseInt(st.nextToken());
        dp = new int[r][c];
        meltDay = new int[r][c];
        map = new char[r][c];
        visit = new boolean[r][c];
        swans = new Point[2];
        iceQ = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'L') {
                    swans[idx++] = new Point(i, j);
                }
            }
        }
        setMeltDay();
        moveSwan();
    }

    private static void moveSwan() {
        Queue<Point> q = new LinkedList<>();
        q.add(swans[0]);
        visit[swans[0].x][swans[0].y] = true;
        while (true) {
            Queue<Point> nextQ = new LinkedList<>();
            while (!q.isEmpty()) {
                Point now = q.poll();
                int x = now.x;
                int y = now.y;
                if (x == swans[1].x && y == swans[1].y) {
                    System.out.println(day);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c || visit[nx][ny]) {
                        continue;
                    }
                    visit[nx][ny] = true;
                    if (meltDay[nx][ny] <= day) {
                        q.add(new Point(nx, ny));
                    } else if (meltDay[nx][ny] == day + 1) {
                        nextQ.add(new Point(nx, ny));
                    }
                }
            }
            while (!nextQ.isEmpty()) {
                q.add(nextQ.poll());
            }
            day++;
        }
    }

    private static void setMeltDay() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '.' || map[i][j] == 'L') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                            continue;
                        }
                        if (map[nx][ny] == 'X') {
                            iceQ.add(new Point(nx, ny));
                            meltDay[nx][ny] = 1;
                        }
                    }
                }
            }
        }
        while (!iceQ.isEmpty()) {
            Point now = iceQ.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == '.') {
                    continue;
                }
                if (meltDay[nx][ny] == 0) {
                    meltDay[nx][ny] = meltDay[x][y] + 1;
                    iceQ.add(new Point(nx, ny));
                }
            }
        }
    }
}

