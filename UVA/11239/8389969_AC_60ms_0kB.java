import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean cont = true;
        while (true) {
            HashMap<String,String> st = new HashMap<>();
            HashMap<String,Integer> pr = new  HashMap<>();
            LinkedList<String> oj = new LinkedList<>();
            String prev = "";
            while (true) {
                String s = br.readLine();
                if (s.equals("1")){
                    break;
                }
                if (s.equals("0")){
                    cont = false;
                    break;
                }
                if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z'){
                    if (!st.containsKey(s)){
                        st.put(s, prev);
                        int x = pr.get(prev) + 1;
                        pr.put(prev, x);
                    } else {
                        String a = st.get(s);
                        if (a.equals(prev) || a.equals("Banned")) continue;
                        int b = pr.get(a)-1;
                        pr.put(a, b);
                        st.put(s,"Banned");
                    }
                }
                if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
                    if (!pr.containsKey(s)){
                        pr.put(s, 0);
                        oj.add(s);
                    } prev = s;
                }
            }
            if (!cont) break;
            LinkedList<Project> out = new LinkedList<>();
            while(!oj.isEmpty()){
                String c = oj.remove();
                int x = pr.get(c);
                out.add(new Project(c, x));
            }
            Collections.sort(out);
            while (!out.isEmpty()){
                Project p = out.removeLast();
                System.out.println(p.getName() + " " + p.getCounter());
            }
        }
    }
}

class Project implements Comparable<Project> {
    private String name;
    private int counter;

    public Project(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Project o) {
        if (this.counter > o.getCounter()) return 1;
        if (this.counter < o.getCounter()) return -1;
        else {
            if (this.name.compareTo(o.getName()) > -1) return -1;
            else return 1;
        }
    }
}