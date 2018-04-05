
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        String[] url = new String[10];
        int[] hit = new int[10];
        int index=0;
        for (int i = 0; i < x; i++) {
            int max = -100000;
            System.out.println("Case #" + (i+1) + ":");
            for (int j = 0; j < 10; j++) {
                url[j] = input.next();
                hit[j] = input.nextInt();
                if (hit[j] > max) {
                    max = hit[j];
                    index = j;
                }
            }
            for (int k = 0; k < 10; k++) {
                if (hit[k] == max) {
                    System.out.println(url[k]);
                }
            }
            hit[index]++;
        }

    }
}