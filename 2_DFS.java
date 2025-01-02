import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
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
        boolean[] vis = new boolean[v];
        ArrayList<Integer> dfs = new ArrayList<>();
        DFSvisit(v, 0, adj, vis, dfs);

        for(int i = 0 ; i < dfs.size() ; i++){
            System.out.print(dfs.get(i) + " ");
        }
    }
    public static void DFSvisit(int v, int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> dfs){
        vis[node] = true;
        dfs.add(node);

        for(int it : adj.get(node)){
            if(!vis[it]){
                DFSvisit(v, it, adj, vis, dfs);
            }
        }
    }
}
