import java.util.*;

public class Bipartite_Graph {
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
        int[] color = new int[v];
        for(int i = 0 ; i < v ; i++) color[i] = -1;
        boolean ans = false;
        for(int i = 0 ; i < v ; i++){
            if(color[i] == -1){
                if(checkWithBFS(i, v, color, list)){
                    ans = true;
                }
            }
        }
        if(ans) System.out.print("It's not a Bipartite Graph");
        else System.out.print("Its a Bipartite Graph");
    }
    public static boolean checkWithBFS(int edge, int v, int[] color, ArrayList<ArrayList<Integer>> list){
        Queue<Integer> q = new LinkedList<>();
        q.add(edge);
        color[edge] = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int it : list.get(node)){
                if(color[it] == -1){
                    color[it] = 1 - color[it];
                    q.add(it);
                }
                else if(color[it] == color[node]){
                    return true;
                }
            }
        }
        return false;
    }
}
