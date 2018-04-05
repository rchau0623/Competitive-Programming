import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int x[] = new int[100005];
        while((s = br.readLine()) != null) {
            String p = new StringBuffer(s.substring(0, s.length() - kmp(new StringBuffer(s).reverse().toString(),s,x))).reverse().toString();
            System.out.println(s + p);
        }
    }

    static int kmp(String r, String s, int[] x) {
        int i,j;
        i = 1;
        j = 0;
        x[0] = x[1] = 0;
        while (i < r.length()) {
            if (r.charAt(i) == r.charAt(j)) x[++i] = ++j;
            else if (j == 0) x[++i] = 0;
            else j = x[j];
        }
        i = j = 0;
        while (i < s.length()) {
            while (j < r.length()) {
                if ((i < s.length() && j < r.length() && s.charAt(i) == r.charAt(j)) || (i < s.length() && j >= r.length() && s.charAt(i) == 0) || (j < r.length() && i >= s.length() && r.charAt(j) == 0) || (j >= r.length() && i >= s.length())) {
                    i++;
                    j++;
                } else break;
            }
            if (j == 0) i++;
            if (i == s.length()) return j;
            j = x[j];
        } return 0;
    }
}
