import java.util.*;

public class Cycle_Detection_DFS {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;
        int v = sc.nextInt();
        for(int i = 0 ; i < v ; i++){
            int n = sc.nextInt();
            ArrayList<Integer> edges = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                edges.add(sc.nextInt());
            }
            list.add(edges);
        }
        boolean[] vis = new boolean[v];
        boolean ans = false;
        for(int i = 0 ; i < v ; i++){
            if(vis[i] == false){
                if(dfs(i, -1, vis, list)) ans = true;
            }
        }
        if(ans) System.out.print("Cycle Detected");
        else System.out.print("No Cycle Detected");
    }
    public static boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> list){
        vis[node] = true;
        for(int adjacent : list.get(node)){
            if(vis[adjacent] == false){
                if(dfs(adjacent, node, vis, list)) return true;
            }
            else if(adjacent != parent){
                return true;
            }
        }
        return false;
    }
}
