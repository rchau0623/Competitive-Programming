import java.util.*;

public class Main
{
    static final int MAXV=500;
    static final int MAXDEGREE=200;
    static boolean discovered[] = new boolean[MAXV+1];
    static int parent[] = new int[MAXV+1];
    static boolean processed[] = new boolean[MAXV+1];
    static Scanner sc;
    static int[][] map;
    static class edge
    {
        int v,capacity,flow,residual;
    }
    static class flow_graph
    {
        edge edges[][];
        int degree[];
        int nvertices;
        int nedges;
        flow_graph()
        {
            edges=new edge[MAXV+1][MAXDEGREE];
            degree=new int[MAXV+1];
            nvertices=nedges=0;
            for(int i=1;i<=MAXV;i++)
                degree[i]=0;
            for(int i=0;i<=MAXV;i++)
                for(int j=0;j<MAXDEGREE;j++)
                    edges[i][j]=new edge();
        }

        void read_flow_graph(boolean directed)
        {
            int m;
            nvertices = sc.nextInt()*2+2;
            map = new int[nvertices][3];
            for (int i = 2 ; i < (nvertices/2)+1 ; i++) {
                map[i][0] = sc.nextInt();
                map[i][1] = 2*(i-1);
                map[i][2] = 2*(i-1)+1;
                insert_flow_edge(map[i][1],map[i][2],directed,map[i][0]);
            }
            m=sc.nextInt();
            for(int i=0;i<m;i++)
            {
                insert_flow_edge(map[sc.nextInt()+1][2],map[sc.nextInt()+1][1],directed,sc.nextInt());
            }
            int start = sc.nextInt();
            int end = sc.nextInt();
            for (int i = 0; i < start; i++) {
                insert_flow_edge(1,map[sc.nextInt()+1][1],directed,Integer.MAX_VALUE);
            }
            for (int i = 0; i < end; i++) {
                insert_flow_edge(map[sc.nextInt()+1][2],nvertices,directed,Integer.MAX_VALUE);
            }
        }

        void insert_flow_edge(int x,int y, boolean directed, int w)
        {
            edges[x][degree[x]].v=y;
            edges[x][degree[x]].capacity=w;
            edges[x][degree[x]].flow=0;
            edges[x][degree[x]].residual=w;
            degree[x]++;
            if(!directed)
                insert_flow_edge(y,x,true,w);
            else
                nedges++;
        }

        void netflow(int source,int sink)
        {
            int volume;
            add_residual_edges();
            initialize_search();
            bfs(source);
            volume=path_volume(source,sink,parent);
            while(volume>0)
            {
                augment_path(source,sink,parent,volume);
                initialize_search();
                bfs(source);
                volume=path_volume(source,sink,parent);
            }
        }

        void add_residual_edges()
        {
            for(int i=1;i<=nvertices;i++)
            {
                int deg=0;
                for(int j=degree[i]-1;j>=0;j--)
                {
                    if(find_edge(edges[i][j].v,i)==null)
                        insert_flow_edge(edges[i][j].v,i,true,0);
                }
            }
        }

        class pair
        {
            int x,y;
        }

        pair find_edge(int x,int y)
        {
            pair ret = new pair();
            for(int i=degree[x]-1;i>=0;i--)
                if(edges[x][i].v==y)
                {
                    ret.x=x;
                    ret.y=i;
                    return ret;
                }
            return null;
        }

        void initialize_search()
        {
            for(int i=1;i<=nvertices;i++)
            {
                processed[i]=false;
                discovered[i]=false;
                parent[i]=-1;
            }
        }

        void bfs(int start)
        {
            Queue<Integer> q = new ArrayDeque<>();
            int v,y;
            q.add(start);
            discovered[start]=true;
            while(!q.isEmpty())
            {
                v=q.poll();
                processed[v]=true;
                for(int i=degree[v]-1;i>=0;i--)
                {
                    y=edges[v][i].v;
                    if(valid_edge(edges[v][i]))
                    {
                        if(!discovered[y])
                        {
                            q.add(y);
                            discovered[y]=true;
                            parent[y]=v;
                        }
                    }
                }
            }
        }

        boolean valid_edge(edge e)
        {
            return e.residual>0;
        }

        int path_volume(int start, int end, int parents[])
        {
            if(parents[end]==-1) return 0;
            pair e= find_edge(parents[end],end);
            if(start==parents[end]) return edges[e.x][e.y].residual;
            else return Math.min(path_volume(start,parents[end],parents),edges[e.x][e.y].residual);
        }

        void augment_path(int start, int end, int parents[], int volume)
        {
            if(start==end) return;
            pair e = find_edge(parents[end],end);
            edges[e.x][e.y].flow += volume;
            edges[e.x][e.y].residual -= volume;

            e = find_edge(end,parents[end]);
            edges[e.x][e.y].residual += volume;

            augment_path(start,parents[end],parents,volume);
        }

        void print_flow_graph()
        {
            for(int i=1;i<=nvertices;i++)
            {
                System.out.printf("%d: ",i);
                for(int j=degree[i]-1;j>=0;j--)
                    System.out.printf(" %d(%d,%d,%d)",edges[i][j].v,edges[i][j].capacity,edges[i][j].flow,edges[i][j].residual);
                System.out.printf("\n");
            }
        }
    }
    static public void main(String[] args)
    {
        sc = new Scanner(System.in);
        while (sc.hasNext()) {
            flow_graph g = new flow_graph();
            g.read_flow_graph(true);
            g.netflow(1, g.nvertices);
            int sum = 0;
            for(int i = 0; i < g.degree[1]; i++) {
                if (g.edges[1][i].flow > 0) sum += g.edges[1][i].flow;
            }
            System.out.println(sum);
        }
    }
}
