import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] ap = { 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97, 113, 131, 199, 311, 337, 373, 733, 919, 991 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals("0")) {
            int x = Integer.parseInt(s);
            int out = -1;
            for (int i = 0; i < ap.length; i++) {
                if (ap[i] > x && ap[i] < Math.pow(10, s.length())) {
                    out = ap[i];
                    break;
                }
            }
            if (out != -1) System.out.println(out);
            else System.out.println(0);
        }
    }
}