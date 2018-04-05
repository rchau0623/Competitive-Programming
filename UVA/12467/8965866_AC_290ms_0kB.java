import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String s;
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            s = br.readLine();
            sb.append(new StringBuffer(s.substring(0,kmp(s.toCharArray()))).reverse().toString() +"\n");
        }
        out.print(sb);
        out.flush();
        out.close();
    }

    static int kmp(char[] s) {
        int[] p = new int[s.length * 2 + 1];
        char[] t = new char[s.length * 2 + 1];
        for (int i = 0; i < s.length; i++)
            t[i] = t[s.length * 2 + 1 - i - 1] = s[i];
        for (int i = 1, j = 0; i < s.length * 2 + 1; i++) {
            while (j > 0 && t[i] != t[j]) j = p[j - 1];
            if (t[i] == t[j]) j++;  
            p[i] = j;
        }
        int x = -1;
        for (int i = s.length + 1; i < s.length * 2 + 1; i++)
            x = Math.max(x, p[i]);
        return x;
    }
}
