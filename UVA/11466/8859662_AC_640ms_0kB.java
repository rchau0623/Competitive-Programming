import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> primes = seive(40000000);
        String s;
        while (!(s=br.readLine()).equals("0")) {
            long x = Math.abs(Long.parseLong(s));
            int count = 0;
            long max = -1;
            for (int i = 0; i < primes.size(); i++) {
                int prime = primes.get(i);
                if (x < (long) prime*prime) break;
                if (x%prime == 0) {
                    while (x%prime == 0) x /= prime;
                    max = prime;
                    count++;
                }
            }
            if (x != 1) {
                max = x;
                count++;
            }
            if (count > 1) {
                System.out.println(max);
            } else {
                System.out.println(-1);
            }
        }
    }

    public static ArrayList<Integer> seive(int x) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[x];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i < x; i++) {
            if (!isPrime[i]) {
                primes.add(i);
                if (x > (long) i*i) {
                    for (int j = i+i; j < x; j += i) isPrime[j] = true;
                }
            }
        } return primes;
    }
}