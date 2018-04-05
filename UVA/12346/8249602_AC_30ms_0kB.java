import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] F = new int[x];
        int[] C = new int[x];
        for (int i = 0; i < x; ++i) {
            String[] FC = br.readLine().split("\\s+");
            F[i] = Integer.parseInt(FC[0]);
            C[i] = Integer.parseInt(FC[1]);
        }
        int y = Integer.parseInt(br.readLine());
        for (int i = 1; i <= y; ++i) {
            String[] VT = br.readLine().split("\\s+");
            long tot = f(0, Integer.parseInt(VT[0]) / Integer.parseInt(VT[1]), F, C, x);
            if (tot == Integer.MAX_VALUE) System.out.println("Case " + i + ": IMPOSSIBLE");
            else System.out.println("Case " + i + ": " + tot);
        }
    }

    static long f(int i, double rate, int[] F, int[] C, int x) {
        if (i == x)
            return rate < Double.MIN_VALUE ? 0 : Integer.MAX_VALUE;
        return Math.min(f(i + 1, rate, F, C, x), C[i] + f(i + 1, rate - F[i], F, C, x));
    }
}

