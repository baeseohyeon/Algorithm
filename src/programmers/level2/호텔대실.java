package programmers.level2;

import static java.lang.Integer.parseInt;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 호텔대실 {

    class BookTime {

        int start;
        int end;

        BookTime(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solution(String[][] book_time) {
        int answer = 1;
        PriorityQueue<BookTime> wait = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
        PriorityQueue<BookTime> use = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        for (String[] strings : book_time) {
            String[] split = strings[0].split(":");
            int start = parseInt(split[0]) * 60 + parseInt(split[1]);
            split = strings[1].split(":");
            int end = parseInt(split[0]) * 60 + parseInt(split[1]);
            wait.add(new BookTime(start,end));
        }

        while(!wait.isEmpty()) {
            BookTime bookTime = wait.poll();

            if(use.isEmpty()) {
                use.add(bookTime);
                continue;
            }

            if(hasRoom(use, bookTime)) {
                use.poll();
                use.add(bookTime);
                continue;
            }

            answer++;
            use.add(bookTime);
        }
        return answer;
    }

    private boolean hasRoom(PriorityQueue<BookTime> use, BookTime bookTime) {
        return use.peek().end + 10 <= bookTime.start;
    }
}
