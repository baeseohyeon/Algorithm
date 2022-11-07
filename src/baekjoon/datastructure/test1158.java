package baekjoon.datastructure;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class test1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = parseInt(s[0]);
        int k = parseInt(s[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int size = list.size();
            int num = list.remove((idx + k - 1) % size);
            sb.append(num);
            sb.append(", ");
            idx = (idx + k - 1) % size;
        }
        System.out.println(sb.substring(0, sb.length() - 2) + ">");
    }
}
