package programmers.level2;

public class 혼자서하는틱택토 {

    static int n = 3;
    static int[] arr;
    static int FIRST = 14;
    static int SECOND = 23;

    public int solution(String[] board) {
        arr = new int[26];
        for (int i = 0; i < n * n; i++) {
            char c = board[i / 3].charAt(i % 3);
            if (c == '.') {
                continue;
            }
            arr[c - 'A']++;
        }

        boolean isFirstWin = isWin(board, 'O');
        boolean isSecondWin = isWin(board, 'X');
        if (arr[SECOND] > arr[FIRST]) {
            return 0;
        }
        if (arr[FIRST] > arr[SECOND] + 1) {
            return 0;
        }
        if (isFirstWin && isSecondWin) {
            return 0;
        }
        if (isFirstWin && (arr[SECOND] >= arr[FIRST] || arr[FIRST] != arr[SECOND] + 1)) {
            return 0;
        }
        if (isSecondWin && (arr[FIRST] > arr[SECOND] || arr[SECOND] != arr[FIRST])) {
            return 0;
        }
        return 1;
    }

    public boolean isWin(String[] board, char c) {
        for (int i = 0; i < n; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(0) == board[i].charAt(1)
                && board[i].charAt(1) == board[i].charAt(2)) {
                return true;
            }
            if (board[0].charAt(i) == c && board[0].charAt(i) == board[1].charAt(i)
                && board[1].charAt(i) == board[2].charAt(i)) {
                return true;
            }
        }
        if (board[0].charAt(0) == c && board[0].charAt(0) == board[1].charAt(1)
            && board[1].charAt(1) == board[2].charAt(2)) {
            return true;
        }
        if (board[0].charAt(2) == c && board[0].charAt(2) == board[1].charAt(1)
            && board[1].charAt(1) == board[2].charAt(0)) {
            return true;
        }
        return false;
    }
}
