/**
 * Created by rchau on 2/3/2017.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        for (int i = 0; i < x; i ++) {
            String num = s.next();
            if (num.length() == 3) {
                if(num.substring(0,1).equals("o") || num.substring(1,2).equals("n")) {
                    System.out.println("1");
                } else if (num.substring(0,1).equals("t") || num.substring(1,2).equals("w")) {
                    System.out.println("2");
                } else {
                    System.out.println("6");
                }
            } else if (num.length() == 4) {
                // four five nine zero
                if(num.substring(0,1).equals("z") || num.substring(3,4).equals("o")) {
                    System.out.println("0");
                } else if (num.substring(2,3).equals("u") || num.substring(3,4).equals("r")) {
                    System.out.println("4");
                } else if (num.substring(0,1).equals("n") || num.substring(2,3).equals("n")) {
                    System.out.println("9");
                } else {
                    System.out.println("5");
                }
            } else if (num.length() == 5) {
                // three seven eight
                if(num.substring(0,1).equals("t") || num.substring(1,2).equals("h")) {
                    System.out.println("3");
                } else if (num.substring(0,1).equals("s") || num.substring(1,2).equals("e")) {
                    System.out.println("7");
                } else {
                    System.out.println("8");
                }
            }
        }
    }
}