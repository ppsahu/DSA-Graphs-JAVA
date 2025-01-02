import java.util.*;

public class BFS{
    public static void main(String[] args){
        // [[2,3,1], [0], [0,4], [0], [2]]
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < v ; i++){
            ArrayList<Integer> edges = new ArrayList<>();
            int numb = sc.nextInt();
            for(int j = 0 ; j < numb ; j++){
                int temp = sc.nextInt();
                edges.add(temp);
            }
            adj.add(edges);
        }
        BFSvisit(adj);
    }
    public static void BFSvisit(ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();

        queue.add(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node);
            for(int nodes : adj.get(node)){
                if(!vis[nodes]){
                    vis[nodes] = true;
                    queue.add(nodes);
                }
            }
        }
        for(int i = 0 ; i < bfs.size() ; i++){
            System.out.print(bfs.get(i) + " ");
        }
    }
}