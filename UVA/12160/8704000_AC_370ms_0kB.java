import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int i = 1;
        while (!(s = br.readLine()).equals("0 0 0")) {
            String[] lur = s.split("\\s+");
            int L = Integer.parseInt(lur[0]);
            int U = Integer.parseInt(lur[1]);
            int R = Integer.parseInt(lur[2]);
            if (L == 0 && U == 0 && R == 0) break;
            String[] rv = br.readLine().split("\\s+");
            int[] min = new int[10000];
            Arrays.fill(min, Integer.MAX_VALUE);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(L);
            min[L] = 0;
            while (queue.size() > 0) {
                int current = queue.poll();
                for (int j = 0; j < R; j++) {
                    if (min[current] + 1 < min[(current + Integer.parseInt(rv[j])) % 10000]) {
                        queue.add((current + Integer.parseInt(rv[j])) % 10000);
                        min[(current + Integer.parseInt(rv[j])) % 10000] = min[current] + 1;
                    }
                }
            }
            System.out.print("Case " + i + ": ");
            i++;
            if (min[U] == Integer.MAX_VALUE) System.out.println("Permanently Locked");
            else System.out.println(min[U]);
        }
    }
}