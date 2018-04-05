import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total;
        int x = input.nextInt();
        int counter = 0;
        while (counter < x) {
            int y = input.nextInt();
            total = 0;
            for (int i = 0; i < y; i++) {
                total += input.nextInt();
            }
            System.out.println(total);
            counter ++;
        }
    }
}
