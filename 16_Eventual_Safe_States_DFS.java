import java.util.*;

public class Eventual_Safe_States {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = sc.nextInt();
        for(int i = 0 ; i < v ; i++){
            int n = sc.nextInt();
            ArrayList<Integer> edges = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                edges.add(sc.nextInt());
            }
            list.add(edges);
        }
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        int[] check = new int[v];
        for(int i = 0 ; i < v ; i++){
            if(vis[i] == 0){
                dfs(i, v, vis, pathVis, check, list);
            }
        }
        ArrayList<Integer> safeNodes = new ArrayList<>();
        for(int i = 0 ; i < v ; i++){
            if(check[i] == 1){
                safeNodes.add(i);
            }
        }
        System.out.println("Safe Nodes are: ");
        for(int k : safeNodes){
            System.out.println(k);
        }
    }
    public static boolean dfs(int edge, int v, int[] vis, int[] pathVis, 
    int[] check, ArrayList<ArrayList<Integer>> list){
        vis[edge] = 1;
        pathVis[edge] = 1;

        for(int it : list.get(edge)){
            if(vis[it] == 0){
                if(dfs(it, v, vis, pathVis, check, list)) return true;
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        pathVis[edge] = 0;
        check[edge] = 1;
        return false;
    }
}
