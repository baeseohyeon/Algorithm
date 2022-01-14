package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test21608 {

    static int n, max;
    static int[][] map;
    static List<Pair> pairs;
    static List<Integer>[] list;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {

        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        list = new ArrayList[n * n + 1];
        for (int i = 1; i <= n * n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                list[number].add(parseInt(st.nextToken()));
            }
            Pair pair = getPair(number);
            map[pair.x][pair.y] = number;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int number = map[i][j];
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 1 || ny < 1 || nx > n || ny > n) {
                        continue;
                    }
                    if (list[number].contains(map[nx][ny])) {
                        cnt++;
                    }
                }
                int num = 0;
                if (cnt > 0) {
                    num = (int) Math.pow(10, cnt - 1);
                }
                ans += num;
            }
        }
        System.out.println(ans);
    }

    private static Pair getPair(int now) {
        max = 0;
        pairs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 0) {
                    setPairs(i, j, now);
                }
            }
        }

        if (pairs.size() == 1) {
            return pairs.get(0);
        }

        List<Pair> subPairs = new ArrayList<>(pairs);
        pairs.clear();
        max = 0;
        for (Pair subPair : subPairs) {
            setPairs(subPair.x, subPair.y, 0);
        }
        return pairs.get(0);
    }

    public static void setPairs(int x, int y, int now) {
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                continue;
            }
            if (now > 0) {
                if (list[now].contains(map[nx][ny])) { //좋아하는학생이 인접한칸에 있으면
                    cnt++;
                }
            } else {
                if (map[nx][ny] == 0) {
                    cnt++;
                }
            }
        }
        if (cnt > max) {
            pairs.clear();
            max = cnt;
        }
        if (cnt == max) {
            pairs.add(new Pair(x, y));
        }
    }

}
