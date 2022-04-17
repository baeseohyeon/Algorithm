package baekjoon.simulation;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class test8972 {

    static int r, c, turn;
    static char[][] map;
    static int[][] dp;
    static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    static Point arduino;
    static List<Point> mad;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = parseInt(st.nextToken());
        c = parseInt(st.nextToken());
        map = new char[r][c];
        mad = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'I') {
                    arduino = new Point(i, j);
                }
                if (map[i][j] == 'R') {
                    mad.add(new Point(i, j));
                }
            }
        }
        String order = br.readLine();
        playRobots(order);
        if (turn == 0) {
            printMap();
        } else {
            System.out.println("kraj " + turn);
        }
    }

    private static void playRobots(String order) {
        for (int i = 0; i < order.length(); i++) {
            int d = order.charAt(i) - '0';
            int nx = arduino.x + dx[d];
            int ny = arduino.y + dy[d];
            if (map[nx][ny] == 'R') {
                turn = i + 1;
                return;
            }
            map[arduino.x][arduino.y] = '.';
            map[nx][ny] = 'I';
            arduino.x = nx;
            arduino.y = ny;
            dp = new int[r][c];
            for (Point now : mad) {
                int x = now.x;
                int y = now.y;
                Point next = findPointCloseToArduino(x, y);
                if (map[next.x][next.y] == 'I') {
                    turn = i + 1;
                    return;
                }
                dp[next.x][next.y]++;
            }
            setMad();
            setMap();
        }
    }

    private static void setMap() {
        for (int i = 0; i < r; i++) {
            Arrays.fill(map[i], '.');
        }
        map[arduino.x][arduino.y] = 'I';
        for (Point point : mad) {
            map[point.x][point.y] = 'R';
        }
    }

    private static void setMad() {
        mad.clear();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dp[i][j] == 1) {
                    mad.add(new Point(i, j));
                }
            }
        }
    }

    private static Point findPointCloseToArduino(int x, int y) {
        Point next = new Point(0, 0);
        int minLen = MAX_VALUE;
        int ax = arduino.x;
        int ay = arduino.y;
        for (int i = 1; i <= 9; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int len = getLen(ax, ay, nx, ny);
            if (minLen > len) {
                minLen = len;
                next.x = nx;
                next.y = ny;
            }
        }
        return next;
    }

    private static int getLen(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static void printMap() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
