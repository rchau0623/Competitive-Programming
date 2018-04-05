import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals("0")) {
            int n = Integer.parseInt(s);
            graph = new int[n][n];
            String t;
            while (!(t = br.readLine()).equals("0")) {
                String[] edge = t.split("\\s+");
                for (int i = 1; i < edge.length-1; i++) graph[Integer.parseInt(edge[0])-1][Integer.parseInt(edge[i])-1] = 1;
            }
            String[] lol = br.readLine().split("\\s+");
            for (int i = 1; i <= Integer.parseInt(lol[0]); i++) {
                boolean[] visit = new boolean[n];
                fuckdfs(Integer.parseInt(lol[i])-1, visit);
                int count =0;
                String loser = "";
                for (int j = 0; j < n; j++) {
                    if (!visit[j]) {
                        loser = loser + " " + (j + 1);
                        count++;
                    }
                }
                if (count == 0) System.out.println(count);
                else System.out.println(count + loser);
            }
        }
    }

    static void fuckdfs(int x, boolean[]visit) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[x][i] == 1) {
                dfs(i, visit);
            }
        }
    }

    static void dfs(int x, boolean[] visit) {
        visit[x]=true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[x][i] == 1 && !visit[i]) dfs(i, visit);
        }
    }
}

