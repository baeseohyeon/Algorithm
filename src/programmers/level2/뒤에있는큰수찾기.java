package programmers.level2;

import java.util.Stack;

class 뒤에있는큰수찾기 {

    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && numbers[st.peek()] <= numbers[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                answer[i] = numbers[st.peek()];
            } else {
                answer[i] = -1;
            }
            st.push(i);
        }
        return answer;
    }
}