import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total;
        while (input.hasNext()) {
            total = 0;
            int x = input.nextInt();
            if (x == 0) {
                break;
            }
            for (int i = 0; i < x; i++) {
                total += input.nextInt();
            }
            System.out.println(total);
        }
    }
}
