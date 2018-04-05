import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            String[] nm = s.split("\\s+");
            String[] c = br.readLine().split("\\s+");
            int low = 0;
            int high = Integer.MAX_VALUE;
            for (int i = 0; i < 60; i++) {
                int mid = (low+high)/2;
                if (f(mid, Integer.parseInt(nm[1]), c)) high = mid;
                else low = mid;
            }
            System.out.println(high);
        }
    }

    public static boolean f(int mid, int m, String[] c) {
        int max = Integer.MIN_VALUE;
        int x = 1;
        int tot = 0;
        for (int i = 0; i < c.length; i++) {
            max = Math.max(max, Integer.parseInt(c[i]));
            tot += Integer.parseInt(c[i]);
            if (tot > mid) {
                tot = Integer.parseInt(c[i]);
                x++;
            }
        }
        if (max > mid) return false;
        else return x <= m;
    }
}