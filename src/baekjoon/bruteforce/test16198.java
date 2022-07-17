package baekjoon.bruteforce;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test16198 {

    static int n, ans;
    static List<Integer> balls;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        balls = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            balls.add(parseInt(st.nextToken()));
        }
        dfs(0, n);
        System.out.println(ans);
    }

    private static void dfs(int point, int size) {
        ans = Math.max(ans, point);
        for (int i = 1; i < size - 1; i++) {
            int nowBall = balls.get(i);
            int leftBall = balls.get(i - 1);
            int rightBall = balls.get(i + 1);
            balls.remove(i);
            dfs(point + leftBall * rightBall, size - 1);
            balls.add(i, nowBall);
        }
    }
}
