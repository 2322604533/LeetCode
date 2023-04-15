package zeus.arithmetic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RestoreIpAddress {

    public static List<String> restoreIpAddress(String s) {

        int len = s.length();

        List<String> res = new ArrayList<>();

        if (len < 4 || len > 12) return res;

        Deque<String> path = new ArrayDeque<>(4);

        int splitTimes = 0;

        dfs(s, len, splitTimes, 0, path, res);

        return res;
    }

    private static void dfs(String s, int len, int split, int begin, Deque<String> path, List<String> res) {
        if (begin == len && split == 4) {
            res.add(String.join(".", path));
            return;
        }

        // 看到剩下的不够了,就推出剪枝,len - begin 表示剩余的还没有分割的字符串位数
        if ((len - begin < 4 - split) || (len - begin) > 3 * (4 - split))
            return ;

        for (int i = 0; i < 3; i++) {
            if (begin + i >= len)
                break;

            int ipSegment = judgeIfIpSegment(s, begin, begin + i);

            if (ipSegment != -1) {
                // 在判断是 ip 的情况下才截取
                path.addLast(ipSegment+"");
                dfs(s, len, split+1,begin+i+1, path, res);
                path.removeLast();
            }
        }
    }

    private static int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(left) == '0') return -1;

        // 转换成 int 型
        int res = 0;
        for (int i = left; i <= right; i++)
            res = res * 10 + s.charAt(i) - '0';

        if (res > 255)
            return -1;

        return res;
    }

    public static void main(String[] args) {
        String str = "101023";
        List<String> list = restoreIpAddress(str);

        for (String ip : list)
            System.out.println("ip:"+ip);
    }
}
