import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static ArrayList<Integer>[] edge;
    public static ArrayList<Integer> out;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            String[] nm = s.split("\\s+");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            if (n == 0 && m == 0) break;
            edge = new ArrayList[n+1];
            int[] count = new int[n+1];
            HashSet<String> hold = new HashSet<>();
            for (int i = 0;i<m;i++) {
                String[] ab = br.readLine().split("\\s+");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);
                String key = a + "_" + b;
                if (a != b && !hold.contains(key)) {
                    if (edge[a] == null) edge[a] = new ArrayList<>();
                    edge[a].add(b);
                    count[b]++;
                    hold.add(key);
                }
            }
            boolean start = false;
            for (int i = 1; i <= n && !start; i++) start = (count[i]==0);
            if (start) {
                out = new ArrayList<>();
                boolean[] v = new boolean[n+1];
                for (int i = 1; i <= n; i++) {
                    if (count[i] == 0) tp(i, v);
                }
                for (int i = out.size()-1; i >= 0; i--) System.out.println(out.get(i));
            } else System.out.println("IMPOSSIBLE");
        }
    }

    public static void tp(int i, boolean[] v) {
        if (!v[i]) {
            v[i] = true;
            if (edge[i] != null) {
                for (int j = 0; j < edge[i].size(); j++) tp(edge[i].get(j), v);
            }
            out.add(i);
        }
    }
}