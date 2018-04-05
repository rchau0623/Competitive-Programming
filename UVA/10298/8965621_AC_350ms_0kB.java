import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int x,j,k;
        while (!(s = br.readLine()).equals(".")) {
            for (int i = 1; i <= s.length(); i++) {
                if (s.length()%i == 0) {
                    String t = s.substring(0,i);
                    x = 1;
                    j = t.length();
                    k = 2 * t.length();
                    while (k <= s.length()) {
                        if (t.equals(s.substring(j,k))) {
                            j += t.length();
                            k += t.length();
                            x++;
                        } else break;
                    }
                    if (k >= s.length() && t.equals(s.substring(s.length()-t.length()))) {
                        System.out.println(x);
                        break;
                    }
                }
            }
        }
    }
}