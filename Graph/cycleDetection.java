import java.util.Iterator;
import java.util.LinkedList;

public class cycleDetection {

    private int V; // No. of vertices

    private LinkedList<Integer> adj[]; // Adjacency List

    @SuppressWarnings("unchecked")
    public cycleDetection(int v) {

        V = v;

        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i)

            adj[i] = new LinkedList();

    }

    public void addEdge(int v, int w) {

        adj[v].add(w);
        adj[w].add(v);
    }// Add w to v’s list.

    public boolean isCyclicUtil(int v, boolean visited[], int parent) {

        visited[v] = true;
        Integer i;

        Iterator<Integer> itr = adj[v].iterator();

        while(itr.hasNext()) {

            i = itr.next();

            if(!visited[v]) {

                if(isCyclicUtil(i, visited, v))
                    return true;
            }

            else if(i != parent)
                return true;
        }

        return false;
    }// isCyclicUtil

    public boolean isCyclic(int V) {

        boolean visited[] = new boolean[V];

        for(int i = 0; i < V; i++) {

            visited[V] = false;
        }
        for(int i=0; i < V; i++) {

            if(!visited[i]) {

                if(isCyclicUtil(i, visited, -1))
                    return true;
            }
        }// for(

        return false;
    }// isCyclic

    public static void main(String[] args) {

        int v1 = 5;
        cycleDetection g = new cycleDetection(v1);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        if(g.isCyclic(v1))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");

        int v2 = 3;
        cycleDetection g2 = new cycleDetection(v2);

        g2.addEdge(0, 1);
        g2.addEdge(1, 2);

        if(g2.isCyclic(v2))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
