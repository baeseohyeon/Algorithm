package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.lang.Integer.*;

public class test16235 {

    static class Pair {

        int x, y, age;

        Pair(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static int n, m, k;
    static int[][] food;
    static int[][] map;
    static PriorityQueue<Pair> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = parseInt(s[0]);
        m = parseInt(s[1]);
        k = parseInt(s[2]);
        food = new int[n + 1][n + 1];
        map = new int[n + 1][n + 1];
        pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.age - p2.age;
            }
        });
        for (int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = 5;
                food[i][j] = parseInt(s[j - 1]);
            }
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int x = parseInt(s[0]);
            int y = parseInt(s[1]);
            int age = parseInt(s[2]);
            pq.add(new Pair(x, y, age));
        }
        int year = 0;
        while (year++ < k) {
            Queue<Pair> breeding = new LinkedList<>();
            Queue<Pair> dead = new LinkedList<>();
            while (!pq.isEmpty()) { //Spring
                Pair now = pq.poll();
                int x = now.x;
                int y = now.y;
                int age = now.age;
                if (map[x][y] >= age) {
                    map[x][y] -= age;
                    breeding.add(new Pair(x, y, age + 1));
                } else {
                    dead.add(new Pair(x, y, age));
                }
            }
            while (!dead.isEmpty()) { //Summer
                Pair now = dead.poll();
                map[now.x][now.y] += now.age / 2;
            }
            while (!breeding.isEmpty()) { //fall
                Pair now = breeding.poll();
                int x = now.x;
                int y = now.y;
                int age = now.age;
                pq.add(new Pair(x, y, age));
                if (age % 5 != 0 || age == 0) {
                    continue;
                }
                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 1 || ny < 1 || nx > n || ny > n) {
                        continue;
                    }
                    pq.add(new Pair(nx, ny, 1));
                }
            }
            for (int i = 1; i <= n; i++) { //winter;
                for (int j = 1; j <= n; j++) {
                    map[i][j] += food[i][j];
                }
            }
        }
        System.out.println(pq.size());
    }
}
