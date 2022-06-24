package baekjoon.tree;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2263 { //https://pangsblog.tistory.com/47

    static int n;
    static int[] inOrder;
    static int[] postOrder;
    static int[] inOrderPosition;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        inOrder = new int[n + 1];
        postOrder = new int[n + 1];
        inOrderPosition = new int[n + 1];
        sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inOrder[i] = parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            postOrder[i] = parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            inOrderPosition[inOrder[i]] = i;
        }
        solve(1, n, 1, n);
        System.out.println(sb);
    }

    public static void solve(int iLeft, int iRight, int pLeft, int pRight) {
        if (iLeft > iRight || pLeft > pRight) {
            return;
        }
        int root = postOrder[pRight];
        sb.append(root + " ");
        int rootIdx = inOrderPosition[root];
        int leftSize = rootIdx - iLeft;
        solve(iLeft, rootIdx - 1, pLeft, pLeft + leftSize - 1);
        solve(rootIdx + 1, iRight, pLeft + leftSize, pRight - 1);
    }
}
