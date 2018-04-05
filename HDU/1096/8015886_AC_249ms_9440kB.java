import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total;
        int x = input.nextInt();
        int counter = 0;
        while (counter < x) {
            total = 0;
            int y = input.nextInt();
            for (int i = 0; i < y; i++) {
                total += input.nextInt();
            }
            System.out.println(total);
            if (counter < x-1) {
                System.out.println("");
            }
            counter ++;
        }
    }
}
