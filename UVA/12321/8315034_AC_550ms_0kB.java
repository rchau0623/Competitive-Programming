import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals("0 0")) {
            String[] lg = s.split("\\s+");
            Interval[] interval = new Interval[Integer.parseInt(lg[1])];
            for (int i = 0; i < Integer.parseInt(lg[1]); i++) {
                String[] xr = br.readLine().split("\\s+");
                interval[i] = new Interval(Integer.parseInt(xr[0]) - Integer.parseInt(xr[1]), Integer.parseInt(xr[0]) + Integer.parseInt(xr[1]));
            }
            Arrays.sort(interval);
            int i = 0;
            int j = 0;
            int gs = 0;
            while (j < Integer.parseInt(lg[0])) {
                int x = -1;
                while (i < interval.length && interval[i].i <= j) {
                    if (interval[i].j >= j && (x == -1 || interval[i].j > interval[x].j)) x = i;
                    i++;
                }
                if (x == -1) break;
                j = interval[x].j;
                gs++;
            }
            if (j < Integer.parseInt(lg[0])) System.out.println("-1");
            else System.out.println((interval.length - gs));
        }
    }

    static class Interval implements Comparable<Interval> {
        int i, j;
        Interval(int i, int j) {
            this.i = i;
            this.j = j;
        }
        @Override
        public int compareTo(Interval x) {
            return i == x.i ? x.j - j : i - x.i;
        }
    }
}