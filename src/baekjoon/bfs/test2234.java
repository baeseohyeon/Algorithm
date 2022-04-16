package baekjoon.bfs;

import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test2234 {

    static int WEST = 1, NORTH = 2, EAST = 4, SOUTH = 8;
    static int n, m, roomNumber, maxArea;
    static int[] roomCountInRoomNumber;
    static int[][] map;
    static int[][] roomNumbers;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = parseInt(st.nextToken());
        n = parseInt(st.nextToken());
        roomCountInRoomNumber = new int[n * m + 1];
        map = new int[n][m];
        roomNumbers = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        checkRoomCntAndMaxRoom();
        System.out.println(roomNumber);
        System.out.println(maxArea);
        breakWall();
        System.out.println(maxArea);
    }

    private static void breakWall() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (isOut(nx, ny)) {
                        continue;
                    }
                    if (isBlocked(k, i, j)) { //벽을 뚫을수 있을때
                        if (roomNumbers[i][j] == roomNumbers[nx][ny]) { //같은 방 번호면 제외
                            continue;
                        }
                        int nowRoomCount = roomCountInRoomNumber[roomNumbers[i][j]];
                        int nextRoomCount = roomCountInRoomNumber[roomNumbers[nx][ny]];
                        maxArea = Math.max(maxArea, nowRoomCount + nextRoomCount);
                    }
                }
            }
        }
    }

    private static void checkRoomCntAndMaxRoom() {
        visit = new boolean[n][m];
        maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    roomNumber++;
                    bfs(i, j);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            x = now.x;
            y = now.y;
            cnt++;
            roomNumbers[x][y] = roomNumber;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isBlocked(i, x, y) || isOut(nx, ny) || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
        maxArea = Math.max(maxArea, cnt);
        roomCountInRoomNumber[roomNumber] = cnt;
    }

    private static boolean isBlocked(int i, int x, int y) { //남 동 북 서
        if (i == 0 && (map[x][y] & NORTH) == NORTH) {
            return true;
        }
        if (i == 1 && (map[x][y] & EAST) == EAST) {
            return true;
        }
        if (i == 2 && (map[x][y] & SOUTH) == SOUTH) {
            return true;
        }
        if (i == 3 && (map[x][y] & WEST) == WEST) {
            return true;
        }
        return false;
    }

    private static boolean isOut(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return true;
        }
        return false;
    }
}