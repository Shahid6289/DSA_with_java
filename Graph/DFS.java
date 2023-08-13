import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    private int V; // No. of vertices

    private LinkedList<Integer> adj[]; // Adjacency List

    @SuppressWarnings("unchecked")
    public DFS(int v) {

        V = v;

        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i)

            adj[i] = new LinkedList();

    }

    public void addEdge(int v, int w) {

        adj[v].add(w);
    }// Add w to v’s list.

    public void dfsTraversal(int v, boolean visited[]) {

        visited[v] = true;

        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].listIterator();

        while (i.hasNext()) {

            int n = i.next();

            if (!visited[n])
                
                dfsTraversal(n, visited);

        }

    }// dfsTraversal

    public static void main(String[] args) {

        int v = 4;
        // boolean[] visited = new boolean[v];
        DFS g = new DFS(v);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(3, 3);
        g.addEdge(2, 3);

        System.out.println("DFS from vertex 0: ");
        g.dfsTraversal(0, new boolean[v]);
        System.out.println();

        System.out.println("DFS from vertex 1: ");
        g.dfsTraversal(1, new boolean[v]);
        System.out.println();

        System.out.println("DFS from vertex 2: ");
        g.dfsTraversal(2, new boolean[v]);

    }
}