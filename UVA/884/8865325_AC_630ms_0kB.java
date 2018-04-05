import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] factors = findFactors(1000001);
        for (int i = 3; i < factors.length; i++) factors[i] += factors[i-1];
        String s;
        while ((s = br.readLine()) != null) {
            int x = Integer.parseInt(s);
            System.out.println(factors[x]);
        }
    }

    public static int[] findFactors(int x) {
        int[] factors = new int[x];
        Arrays.fill(factors, 1);
        for (int i = 2; i < factors.length; i++) {
            for (int j = 2; j <= i; j++) {
                if (i*j < factors.length) {
                    factors[i*j] = factors[i] + factors[j];
                } else break;
            }
        } return factors;
    }
}