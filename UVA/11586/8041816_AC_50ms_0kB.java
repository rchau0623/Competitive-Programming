import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int[][] friend = new int[n][n];
//        int c, x, y;
//        for (int i = 0; i < n; i++) {
//            friend[i][i] = 1;
//        }
//        do {
//            c = input.nextInt();
//            x = input.nextInt();
//            y = input.nextInt();
//            if (c == 1) {
//                if (friend[x][y] == 0) {
//                    for (int j = 0; j < n; j++) {
//                        if (friend[y][j] + friend[x][j] == 1) {
//                            friend[x][j] = 1;
//                            friend[y][j] = 1;
//                            friend[j][y] = 1;
//                            friend[j][x] = 1;
//                        } else if (friend[y][j] + friend[x][j] == -1) {
//                            friend[x][j] = -1;
//                            friend[y][j] = -1;
//                            friend[j][y] = -1;
//                            friend[j][x] = -1;
//                        }
//                    }
//                } else {
//                    System.out.println("-1");
//                }
//            } else if (c == 2) {
//                if (friend[x][y] == 0) {
//                    for (int j = 0; j < n; j++) {
//                        if (friend[y][j] == 1) {
//                            friend[x][j] = -1;
//                            friend[j][x] = -1;
//                        }
//                        if (friend[x][j] == 1) {
//                            friend[y][j] = -1;
//                            friend[j][y] = -1;
//                        }
//                        if (friend[y][j] == -1) {
//                            friend[x][j] = 1;
//                            friend[j][x] = 1;
//                        }
//                        if (friend[x][j] == -1) {
//                            friend[y][j] = 1;
//                            friend[j][y] = 1;
//                        }
//                    }
//                } else {
//                    System.out.println("-1");
//                }
//            } else if (c == 3) {
//                if (friend[x][y] == 1) {
//                    System.out.println("1");
//                } else {
//                    System.out.println("0");
//                }
//            } else if (c == 4) {
//                if (friend[x][y] == -1) {
//                    System.out.println("1");
//                } else {
//                    System.out.println("0");
//                }
//            }
//        }while ((c + x + y) != 0);
//        long endTime   = System.currentTimeMillis();
//        long totalTime = endTime - startTime;
//        System.out.println(totalTime);
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        input.nextLine();
        int m, f;
        for (int i = 0; i < x; i ++) {
            f = 0;
            m = 0;
            String inst = input.nextLine();
            String[] s = inst.split(" ");
            for (int j = 0; j < s.length; j++) {
                if (s[j].equals("MF") || s[j].equals("FM")) {
                    m++;
                    f++;
                } else if (s[j].equals("MM")) {
                    m += 2;
                } else if (s[j].equals("FF")) {
                    f += 2;
                }
            }
            if (m == f && m > 1 && f > 1) {
                System.out.println("LOOP");
            } else {
                System.out.println("NO LOOP");
            }
        }

    }
}