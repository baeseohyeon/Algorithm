package baekjoon.bruteforce;

import static java.lang.Integer.*;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test10655 { // https://kwangkyun-world.tistory.com/127

    static int n, ans;
    static Point[] checkPoints;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        checkPoints = new Point[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = parseInt(st.nextToken());
        int y1 = parseInt(st.nextToken());
        checkPoints[1] = new Point(x1, y1);
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x2 = parseInt(st.nextToken());
            int y2 = parseInt(st.nextToken());
            ans += getLen(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
            checkPoints[i] = new Point(x1, y1);
        }
        int total = ans;
        for (int i = 2; i <= n - 1; i++) {
            Point prev = checkPoints[i - 1];
            Point now = checkPoints[i];
            Point next = checkPoints[i + 1];
            int jump = getLen(prev.x, prev.y, next.x, next.y);
            int straight = getLen(prev.x, prev.y, now.x, now.y) + getLen(now.x, now.y, next.x, next.y);
            ans = Math.min(ans, total - straight + jump);
        }
        System.out.println(ans);
    }

    private static int getLen(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
