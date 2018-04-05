import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        for (int i = 1; i <= x; i++) {
            int y = Integer.parseInt(br.readLine());
            String f = br.readLine();
            int ind = 0;
            int count=0;
            for (int j = 0; j < y; j++) {
                if (j - ind == 1) {
                    ind = j + 2;
                    count++;
                    j++;
                } else {
                    if (f.charAt(j) == '#') ind = j + 1;
                }
            }
            if (ind == y - 1) count++;
            System.out.println("Case " + i + ": " + count);
        }
    }
}