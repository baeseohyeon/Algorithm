package baekjoon.simulation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test20055 { //https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-20055-%EC%BB%A8%EB%B2%A0%EC%9D%B4%EC%96%B4-%EB%B2%A8%ED%8A%B8-%EC%9C%84%EC%9D%98-%EB%A1%9C%EB%B4%87-java

    static int n, k, level, N;
    static int[] belts;
    static boolean[] robots;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        N = 2 * n;
        belts = new int[n * 2 + 1];
        robots = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            belts[i] = parseInt(st.nextToken());
        }
        while (k > 0) {
            level++;
            levelOne();
            levelTwo();
            levelThree();
        }
        System.out.println(level);
    }

    private static void levelThree() {
        if (belts[1] != 0) {
            robots[1] = true;
            belts[1]--;
            if (belts[1] == 0) {
                k--;
            }
        }
    }

    private static void levelTwo() {
        for (int i = n - 1; i >= 1; i--) {
            if (belts[i + 1] > 0 && robots[i] && !robots[i + 1]) {
                robots[i + 1] = robots[i];
                robots[i] = false;
                belts[i + 1]--;
                if (belts[i + 1] == 0) {
                    k--;
                }
            }
        }
    }

    private static void levelOne() {
        int belt1 = belts[N];
        for (int j = N; j > 1; j--) {
            belts[j] = belts[j - 1];
        }
        belts[1] = belt1;

        for (int i = n; i > 1; i--) {
            robots[i] = robots[i - 1];
        }
        robots[1] = false;
        robots[n] = false;
    }
}
