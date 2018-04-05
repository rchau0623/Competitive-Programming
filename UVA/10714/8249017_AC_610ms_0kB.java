//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//
//public class Main {
//    public static void main (String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int x = Integer.parseInt(br.readLine());
//        for (int i = 0; i < x; i++) {
//            int mid = 0;
//            int edge = 0;
//            String[] y = br.readLine().split("\\s+");
//            String[] z = br.readLine().split("\\s+");
//            for (int j = 0; j < Integer.parseInt(y[1]); j++) {
//                mid = Math.max(mid, Math.min(Integer.parseInt(y[0])-Integer.parseInt(z[j]), Integer.parseInt(z[j])));
//                edge = Math.max(edge, Math.max(Integer.parseInt(z[j]), Integer.parseInt(y[0]) - Integer.parseInt(z[j])));
//            } System.out.println(mid + " " + edge);
//        }
//    }
//}

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner br = new Scanner(System.in);
        int x = br.nextInt();
        for (int i = 0; i < x; i++) {
            int mid = 0;
            int edge = 0;
            int a = br.nextInt();
            int b = br.nextInt();
            for (int j = 0; j < b; j++) {
                int c = br.nextInt();
                mid = Math.max(mid, Math.min(a - c, c));
                edge = Math.max(edge, Math.max(c, a - c));
            } System.out.println(mid + " " + edge);
        }
    }
}