//import java.io.IOException;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { // throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt(); // Integer.parseInt(br.readLine());
        for (int i = 0; i < b; i++) {
            int r = sc.nextInt(); //I nteger.parseInt(br.readLine());
            int[] lol = new int[r-1];
            for (int j = 0; j < lol.length; j++) lol[j] = sc.nextInt(); //Integer.parseInt(br.readLine());
            int m = 0, s = 0;
            for (int j = 0; j < lol.length; j++) {
                s += lol[j];
                m = Math.max(s, m);
                if (s < 0) s = 0;
            }
            int x = 0;
            int y = 0;
            int min = 0;
            s = 0;
            for (int j = 0; j < lol.length; j++) {
                s += lol[j];
                if (s == m) {
                    if (j - min > y - x || (x == 0 && y == 0)) {
                        x = min + 1;
                        y = j + 2;
                    }
                }
                if (s < 0) {
                    s = 0;
                    min = j+1;
                }
            }
            if (m > 0) System.out.println("The nicest part of route " + (i+1) + " is between stops " + x + " and " + y);
            else System.out.println("Route "+ (i+1) +" has no nice parts");
        }
    }
}