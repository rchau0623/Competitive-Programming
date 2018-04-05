import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total;
        int x;
        while (input.hasNext()) {
            total = 0;
            x = input.nextInt();
            for (int i = 0; i < x; i++) {
                total += input.nextInt();
            }
            System.out.println(total);
        }
    }
}
