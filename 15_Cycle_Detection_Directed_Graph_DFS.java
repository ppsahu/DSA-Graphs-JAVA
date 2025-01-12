import java.util.*;

public class Cycle_Detection_Directed_Graph {
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
        boolean ans = false;
        for(int i = 0 ; i < v ; i++){
            if(checkDFS(i, v, vis, pathVis, list)) ans = true;
        }
        if(ans) System.out.print("Cycle Detected");
        else System.out.print("No cycle detected");
    }
    public static boolean checkDFS(int edge, int v, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> list){
        vis[edge] = 1;
        pathVis[edge] = 1;


        for(int it : list.get(edge)){
            if(vis[it] == 0){
                if(checkDFS(it, v, vis, pathVis, list)) return true;
            }
            else if(pathVis[it] == 1) return true;
        }

        pathVis[edge] = 0;
        return false;
    }
}
