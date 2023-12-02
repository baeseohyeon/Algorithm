package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Test14891 {

    static int[] touch = {-2, 2};
    static int[] idx = {0, 0, 0, 0};
    static int n = 4, m = 8;
    static int[][] arr = new int[n][m];
    static List<int[]> toMoveGears;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        int k = Integer.parseInt(br.readLine());
        while (k -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gear = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            toMoveGears = new ArrayList<>();
            findLeftGear(gear, d);
            findRightGear(gear, d);
            moveGear();
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += arr[i][idx[i]] == 1 ? Math.pow(2,i) : 0;
        }
        System.out.println(ans);
    }

    private static void moveGear() {
        Set<Integer> visit = new HashSet<>();
        for (int[] gears : toMoveGears) {
            if(visit.add(gears[0])) {
                idx[gears[0]] = (idx[gears[0]] + gears[1] * -1 + m) % m;
            }
        }
    }

    private static void findRightGear(int gear, int d) {
        toMoveGears.add(new int[]{gear, d});
        if (gear + 1 >= n) {
            return;
        }
        int nowPole = arr[gear][(idx[gear] + touch[1]) % m];
        int rightPole = arr[gear + 1][(idx[gear + 1] + m + touch[0]) % m];
        if (nowPole == rightPole) {
            return;
        }
        findRightGear(gear + 1, d * -1);
    }

    private static void findLeftGear(int gear, int d) {
        toMoveGears.add(new int[]{gear, d});
        if (gear - 1 < 0) {
            return;
        }
        int nowPole = arr[gear][(idx[gear] + m + touch[0]) % m];
        int leftPole = arr[gear - 1][(idx[gear - 1] + touch[1]) % m];
        if (leftPole == nowPole) {
            return;
        }
        findLeftGear(gear - 1, d * -1);
    }
}
