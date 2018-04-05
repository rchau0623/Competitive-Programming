import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] fr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        for (int i = 0; i < Integer.parseInt(x); i++) {
            String[] s = br.readLine().split(" ");
            fr = new int[Integer.parseInt(s[0])];
            for (int j= 0; j < fr.length; j++) fr[j] = -1;
            for (int j = 0; j < Integer.parseInt(s[1]); j++) {
                String[] p = br.readLine().split(" ");
                fr = union(Integer.parseInt(p[0])-1, Integer.parseInt(p[1])-1);
            }
            int max = 0;
            for (int j = 0; j < fr.length; j++) {
                if (-fr[j] > max) max = -fr[j];
            } System.out.println(max);
        }
    }

    public static int[] union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return fr;
        if (fr[x] > fr[y]) {
            fr[y] = fr[y] + fr[x];
            fr[x] = y;
        } else {
            fr[x] = fr[x] + fr[y];
            fr[y] = x;
        } return fr;
    }

    public static int find(int x) {
        if(fr[x] < 0) return x;
        else return fr[x] = find(fr[x]);
    }
}