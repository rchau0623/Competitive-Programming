import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < x; i++) {
            int y = Integer.parseInt(br.readLine());
            String[] str = new String[y];
            String[] end = new String[y];
            for (int j = 0; j < y*2; j++) {
                if (j < y) str[j]= br.readLine();
                else end[j-y] = br.readLine();
            }
            int z = -1;
            for (int j = 0; j < y; j++) {
                if (str[y-1-j].equals(end[y-2-z])) z++;
            }
            for (z++; z < y; z++) System.out.println(end[y-1-z]);
            System.out.println("");
        }
    }
}