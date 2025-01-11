import java.util.*;

public class Bipartite_Graph_DFS {
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


        int color[] = new int[v];
        for(int i = 0 ; i < v ; i++) color[i] = -1;
        boolean ans = false;
        for(int i = 0 ; i < v ; i++){
            if(color[i] == -1){
                if(checkWithDFS(i, 0, color, list)) ans = true;
            }
        }
        if(ans) System.out.print("It's not a Bipartite Graph");
        else System.out.print("It's a Bipartite Graph");
    }
    public static boolean checkWithDFS(int edge, int col, int[] color, ArrayList<ArrayList<Integer>> list){
        color[edge] = col;

        for(int it : list.get(edge)){
            if(color[it] == -1){
                if(checkWithDFS(it, 1 - col, color, list)) return true;
            }
            else if(color[it] == col){
                return true;
            }
        }
        return false;
    }
}
