package baekjoon.divideconquer;

import java.io.*;

public class test1992 {

    static String[] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static boolean check(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[x].charAt(y) != map[i].charAt(j))
                    return false;
            }
        }
        return true;
    }

    public static void solve(int x, int y, int size) throws IOException {
        if (check(x, y, size)) {
            bw.write(map[x].charAt(y));
        } else if (size >= 2) {
            bw.write("(");
            int nextSize = size / 2;
            solve(x, y, nextSize);
            solve(x, y + nextSize, nextSize);
            solve(x + nextSize, y, nextSize);
            solve(x + nextSize, y + nextSize, nextSize);
            bw.write(")");
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        map = new String[n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }
        solve(0, 0, n);
        bw.flush();
    }
}
