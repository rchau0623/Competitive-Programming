import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s = br.readLine()).equals("0 0")) {
            String[] num = s.split("\\s+");
            int g = 0;
            int x = 0;
            int[] drg = new int[Integer.parseInt(num[0])];
            int[] kgt = new int[Integer.parseInt(num[1])];
            if (Integer.parseInt(num[0]) > Integer.parseInt(num[1])) {
                System.out.println("Loowater is doomed!");
                for (int i = 0; i < Integer.parseInt(num[0]) + Integer.parseInt(num[1]); i++) br.readLine();
            }
            else {
                for (int i = 0; i < Integer.parseInt(num[0]); i++) drg[i] = Integer.parseInt(br.readLine());
                for (int i = 0; i < Integer.parseInt(num[1]); i++) kgt[i] = Integer.parseInt(br.readLine());
                Arrays.sort(drg); Arrays.sort(kgt);
                for (int i = 0; i < Integer.parseInt(num[1]) && x < Integer.parseInt(num[0]); i++) {
                    if (drg[x] <= kgt[i]) {
                        g = g + kgt[i];
                        x++;
                    }
                } if (x != Integer.parseInt(num[0])) System.out.println("Loowater is doomed!");
                else System.out.println(g);
            }
        }
    }
}