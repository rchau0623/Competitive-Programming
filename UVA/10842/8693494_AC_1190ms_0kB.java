import java.util.*;

class Main
{
    static int MAXV = 1000;
    static int MAXDEGREE = 500;
    static int parent[] = new int [MAXV];
    static class graph
    {
        class edge
        {
            int v,weight;
        }
        edge edges[][];
        int degree[];
        int nvertices;
        int nedges;
        graph()
        {
            edges = new edge[MAXV+1][MAXDEGREE];
            degree = new int[MAXV+1];
            nvertices=nedges=0;
            for(int i=0;i<MAXV+1;i++)
                for(int j=0;j<MAXDEGREE;j++)
                    edges[i][j] = new edge();
        }
        void read_graph(boolean directed, Scanner sc)
        {
            nvertices = sc.nextInt();
            for(int i=1;i<=nvertices;i++)
                degree[i] = 0;
            int m = sc.nextInt();
            for(int i=0;i<m;i++)
            {
                int x = sc.nextInt()+1;
                int y = sc.nextInt()+1;
                int weight = -1 * sc.nextInt();
                edges[x][degree[x]].v = y;
                edges[x][degree[x]].weight = weight;
                if(!directed) edges[y][degree[y]].v = x;
                if(!directed) edges[y][degree[y]].weight = weight;
                degree[x]++;
                if(!directed) degree[y]++;
            }
        }
    }
    static void prim(graph g, int start)
    {
        int i,j;
        boolean intree[] = new boolean[MAXV];
        int distance[] = new int[MAXV];
        int v,w,weight,dist;
        int out = -1 * 2147383647;
        for(i=1;i<=g.nvertices;i++)
        {
            intree[i]=false;
            distance[i]=2147483647;
            parent[i]=-1;
        }
        distance[start]=0;
        v=start;
        while(!intree[v])
        {
            intree[v]=true;
            for(i=g.degree[v]-1;i>=0;i--)
            {
                w=g.edges[v][i].v;
                weight=g.edges[v][i].weight;
                if(distance[w]>weight&&!intree[w])
                {
                    distance[w]=weight;
                    parent[w]=v;
                }
            }
            v=1;
            dist=-1;
            for(i=2;i<=g.nvertices;i++)
            {
                if(!intree[i]&&dist>distance[i])
                {
                    dist=distance[i];
                    v=i;
                }
            }
            if (out < dist && dist != -1) {
                out = dist;
            }
        } System.out.println(-1*out);
    }
    static public void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int i = 1; i <= x; i++) {
            System.out.printf("Case #%d: ", i);
            graph g=new graph();
            int j;
            g.read_graph(false, sc);
            prim(g,1);
        }
    }
}