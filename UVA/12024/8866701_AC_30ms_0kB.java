import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String[] solutions = {"1/2", "2/6", "9/24", "44/120", "265/720", "1854/5040", "14833/40320", "133496/362880", "1334961/3628800", "14684570/39916800", "176214841/479001600"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            //int f = 1;
            int x =  Integer.parseInt(br.readLine());
            //for (int j = 2; j <= x; j++) f *= j;
            System.out.println(solutions[x-2]);
        }
    }
}


