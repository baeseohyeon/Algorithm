package baekjoon.datastructure;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class test17299 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[1000001];
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = parseInt(st.nextToken());
            arr[numbers[i]]++;
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        stack.add(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int num = numbers[i];
            while (!stack.isEmpty() && arr[numbers[stack.peek()]] <= arr[num]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = numbers[stack.peek()];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
