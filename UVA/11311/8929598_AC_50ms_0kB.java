import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] mnrc = br.readLine().split("\\s+");
            System.out.printf("%s\n", ((Integer.parseInt(mnrc[2])) ^ (Integer.parseInt(mnrc[3])) ^ (Integer.parseInt(mnrc[0]) - Integer.parseInt(mnrc[2]) - 1) ^ (Integer.parseInt(mnrc[1]) - Integer.parseInt(mnrc[3]) - 1)) == 0? "Hansel" : "Gretel");
        }
    }
}