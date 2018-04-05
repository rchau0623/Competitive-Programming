import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int [] count = new int[100000 + 5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk, sq, cmd;
        String s;
        while((s = br.readLine()) != null){
            for (int i = 0; i < count.length; i++) count[i] = 0;
            nk = s.split(" ");
            sq = br.readLine().split(" ");
            for (int i = 1; i <= Integer.parseInt(nk[0]); i++){
                if(Integer.parseInt(sq[i-1]) == 0) change(i, -1000000, Integer.parseInt(nk[0]));
                else if(Integer.parseInt(sq[i-1]) < 0) change(i, 1, Integer.parseInt(nk[0]));
            }
            for (int i = 0; i < Integer.parseInt(nk[1]); i++) {
                cmd = br.readLine().split(" ");
                if(cmd[0].matches("C")) {
                    change(Integer.parseInt(cmd[1]), -(find(Integer.parseInt(cmd[1])) - find(Integer.parseInt(cmd[1]) - 1)), Integer.parseInt(nk[0]));
                    if(Integer.parseInt(cmd[2]) < 0) change(Integer.parseInt(cmd[1]), 1, Integer.parseInt(nk[0]));
                    else if(Integer.parseInt(cmd[2]) == 0) change(Integer.parseInt(cmd[1]), -1000000, Integer.parseInt(nk[0]));
                } else {
                    int neg = find(Integer.parseInt(cmd[2])) - find(Integer.parseInt(cmd[1]) - 1);
                    if(neg >= 0) System.out.print((neg % 2 == 0 ? "+" : "-"));
                    else System.out.print("0");
                }
            } System.out.println("");
        }
    }

    static int find(int x){
        int neg = 0;
        while(x > 0){
            neg += count[x];
            x -= (x & -x);
        } return neg;
    }

    static void change(int i, long x, int n){
        while(i <= n){
            count[i] += x;
            i += (i & -i);
        }
    }
}