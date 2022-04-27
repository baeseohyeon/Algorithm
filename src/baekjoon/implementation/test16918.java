package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test16918 {

    static int r, c, n;
    static char[][] map;
    static Queue<Point> q;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = parseInt(st.nextToken());
        c = parseInt(st.nextToken());
        n = parseInt(st.nextToken());
        map = new char[r][c];
        q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'O') {
                    q.add(new Point(i, j));
                }
            }
        }
        int cnt = 1;
        while (cnt++ < n) {
            if (cnt % 2 == 0) {
                setBomb();
            } else {
                explode();
                addBomb();
            }
        }
        printMap();
    }

    private static void addBomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'O') {
                    q.add(new Point(i, j));
                }
            }
        }
    }

    private static void setBomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = 'O';
            }
        }
    }

    private static void explode() {
        while (!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            map[x][y] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }
                map[nx][ny] = '.';
            }
        }
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
