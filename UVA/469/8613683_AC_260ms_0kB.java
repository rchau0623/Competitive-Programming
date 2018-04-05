import java.util.Scanner;

public class Main {
    private static char[][] grid = new char[100][];
    private static int cos[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int sin[] = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        while (n-- > 0) {
            int length = 0;
            while (true) {
                grid[length] = sc.nextLine().toCharArray();
                if (grid[length][0] != 'L' && grid[length][0] != 'W') break;
                length++;
            }
            String s = new String(grid[length]);
            while (true) {
                String[] split = s.split("\\s+");
                int x = Integer.parseInt(split[0])-1;
                int y = Integer.parseInt(split[1])-1;
                System.out.println(count(x, y, 'W', ' ', length));
                count(x, y, ' ', 'W', length);
                if (sc.hasNext()) s = sc.nextLine();
                else break;
                if (s.length() == 0) break;
            }
            if (n > 0) System.out.println();
        }
    }

    private static int count(int x, int y, char f, char t, int length) {
        if (x < 0 || x >= length || y < 0 || y >= grid[0].length) return 0;
        if (grid[x][y] != f) return 0;
        grid[x][y] = t;
        int area = 1;
        for (int i = 0; i < 8; i++) area += count(x + cos[i], y + sin[i], f, t, length);
        return area;
    }
}