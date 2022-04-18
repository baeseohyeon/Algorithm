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

public class test11967 {

    static int n, m, cnt = 1;
    static boolean[][] visit;
    static boolean[][] isLightOn;
    static List<Point>[][] map;
    static List<Point> rooms;
    static Queue<Point> q;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        isLightOn = new boolean[n + 1][n + 1];
        map = new ArrayList[n + 1][n + 1];
        q = new LinkedList<>();
        rooms = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = parseInt(st.nextToken());
            int y1 = parseInt(st.nextToken());
            int x2 = parseInt(st.nextToken());
            int y2 = parseInt(st.nextToken());
            map[x1][y1].add(new Point(x2, y2));
        }
        isLightOn[1][1] = true;
        rooms.add(new Point(1, 1));
        findLightOnRoom();
        System.out.println(cnt);
    }

    private static void findLightOnRoom() {
        while (!rooms.isEmpty()) {
            lightOn();
            bfs();
        }
    }

    private static void bfs() {
        visit = new boolean[n + 1][n + 1];
        visit[1][1] = true;
        q.add(new Point(1, 1));
        while (!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || ny < 1 || nx > n || ny > n || visit[nx][ny] || !isLightOn[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                q.add(new Point(nx, ny));
                if (!map[nx][ny].isEmpty()) {
                    rooms.add(new Point(nx, ny));
                }
            }
        }
    }

    private static void lightOn() {
        for (Point room : rooms) { //갈수있는 방에 가서
            for (Point next : map[room.x][room.y]) { //스위치 키기
                if (!isLightOn[next.x][next.y]) {
                    isLightOn[next.x][next.y] = true;
                    cnt++;
                }
            }
            map[room.x][room.y].clear();
        }
        rooms.clear();
    }
}
