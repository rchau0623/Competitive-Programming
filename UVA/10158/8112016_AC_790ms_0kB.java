import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tot = sc.nextInt();
        int[] f = new int[20020];
        for(int i = 0; i < f.length; i++) {
            f[i] = i;
        }
        while(sc.hasNext()) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(op + x + y == 0) {
                break;
            }
            int a;
            int b;
            int c;
            int d;
            if(op == 1)	{
                a = fx(x, f);
                b = fx(y, f);
                c = fx(x + tot, f);
                d = fx(y + tot, f);
                if(a == d || b == c) {
                    System.out.println("-1");
                } else {
                    f[b] = a;
                    f[d] = c;
                }
            }
            if(op == 2)	{
                a = fx(x, f);
                b = fx(y, f);
                c = fx(x + tot, f);
                d = fx(y + tot, f);

                if(a == b)	{
                    System.out.println("-1");
                } else {
                    f[c] = b;
                    f[d] = a;
                }
            }
            if(op == 3)	{
                System.out.println(fx(x, f) == fx(y, f) ? "1" : "0");
            }
            if(op== 4)	{
                a = fx(x, f);
                b = fx(y, f);
                c = fx(x +  tot, f);
                d = fx(y + tot, f);

                System.out.println((a == d || b == c) ? "1" : "0");
            }

        }

    }
    public static int fx(int i, int[] f){
        return f[i] == i ? i : (f[i] = fx(f[i], f));
    }

}