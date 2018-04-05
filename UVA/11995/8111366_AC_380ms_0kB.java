import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue p = new PriorityQueue(Collections.reverseOrder());
        Queue q = new LinkedList();
        Stack s = new Stack();
        String str;
        while ((str = br.readLine()) != null && !str.equals("")) {
            int x = Integer.parseInt(str);
            boolean pPos = true;
            boolean qPos = true;
            boolean sPos = true;
            for (int i = 0; i < x; i++) {
                String[] op = br.readLine().split(" ");
                if (Integer.parseInt(op[0]) == 1) {
                    s.push(Integer.parseInt(op[1]));
                    q.add(Integer.parseInt(op[1]));
                    p.add(Integer.parseInt(op[1]));
                } else {
                    if (pPos) {
                        if (p.isEmpty() || (int) p.poll() != Integer.parseInt(op[1])) {
                            pPos = false;
                        }
                    } if (qPos) {
                        if (q.isEmpty() || (int) q.poll() != Integer.parseInt(op[1])) {
                            qPos = false;
                        }
                    } if (sPos) {
                        if (s.isEmpty() || (int) s.pop() != Integer.parseInt(op[1])) {
                            sPos = false;
                        }
                    }
                }
            }
            if (!qPos && !sPos && !pPos) {
                System.out.println("impossible");
            } else if (pPos && !sPos && !qPos) {
                System.out.println("priority queue");
            } else if (qPos && !sPos && !pPos) {
                System.out.println("queue");
            } else if (sPos && !qPos && !pPos) {
                System.out.println("stack");
            } else {
                System.out.println("not sure");
            }
            p.clear();
            q.clear();
            s.clear();
        }br.close();
    }
}