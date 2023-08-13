import java.util.LinkedList;
import java.util.Iterator;

public class BFS {

    private int V; // No. of vertices

    private LinkedList<Integer> adj[]; // Adjacency List

    @SuppressWarnings("unchecked")
    public BFS(int v) {

        V = v;

        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i)

            adj[i] = new LinkedList();

    }

    public void addEdge(int v, int w) {

        adj[v].add(w);
    }// Add w to v’s list.

    public void bfsTraversal(int v) {

        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[v] = true;
        queue.add(v);

        while(queue.size() != 0) {
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> i = adj[v].listIterator();

            while(i.hasNext()) {
                int n = i.next();

                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }// bfsTraversal

    public static void main(String[] args) {
        int v = 4;
        BFS g = new BFS(v);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(3, 3);
        g.addEdge(2, 3);

        System.out.println("BFS from vertex 0: ");
        g.bfsTraversal(0);
        System.out.println();

        System.out.println("BFS from vertex 1: ");
        g.bfsTraversal(1);
        System.out.println();

        System.out.println("BFS from vertex 2: ");
        g.bfsTraversal(2);
    }
}