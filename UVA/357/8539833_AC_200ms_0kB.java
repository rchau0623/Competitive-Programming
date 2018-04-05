import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] m = new long[30001];
        int[] c = {50,25,10,5,1}; 
        m[0] = 1;
        for(int i = 0; i < c.length; i++){
            for(int j = c[i]; j <= 30000; j++){
                m[j] += m[j - c[i]];
            }
        }
        String s;
        while((s = br.readLine()) != null){
            int n = Integer.parseInt(s);
            if(m[n] == 1) System.out.println("There is only 1 way to produce " + n + " cents change.");
            else System.out.println("There are " + m[n] + " ways to produce " + n + " cents change.");
        }
    }
}
