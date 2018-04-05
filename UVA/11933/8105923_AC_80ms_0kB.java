import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] x;
        int counter = 0;
        do {
            x = Integer.toBinaryString(Integer.parseInt(br.readLine())).toCharArray();
            if (x[0] == '0') {
                System.exit(0);
            }
            char[] y = new char[x.length];
            char[] z = new char[x.length];
            for (int i = x.length-1; i >= 0; i--) {
                if (x[i] == '0') {
                    y[i] = '0';
                    z[i] = '0';
                } else if (x[i] == '1') {
                    if (counter%2 == 0) {
                        y[i] = '1';
                        z[i] = '0';
                    } else {
                        y[i] = '0';
                        z[i] = '1';
                    }
                    counter++;
                }
            } counter = 0;
            System.out.println( Integer.parseInt(String.valueOf(y), 2) + " " + Integer.parseInt(String.valueOf(z), 2));
        } while (!x.equals("0"));
    }
}