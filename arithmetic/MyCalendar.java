package Zeus.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    private List<int[]> list = new ArrayList<>();

    public boolean book(int start, int end) {
        end--;
        for (int[] info : list) {
            if (start > info[1] || end < info[0]) continue;
            return false;
        }
        list.add(new int[]{start, end});
        return true;
    }
}
