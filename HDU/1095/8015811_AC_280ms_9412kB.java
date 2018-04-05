import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total;
        while (input.hasNext()) {
            total = 0;
            for (int i = 0; i < 2; i++) {
                total += input.nextInt();
            }
            System.out.println(total);
            System.out.println("");
        }
    }
}
