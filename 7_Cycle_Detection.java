import java.util.*;
public class Cycle_Detection {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
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
        boolean vis[] = new boolean[v];
        boolean ans = false;
        for(int i = 0 ; i < v ; i++){
            if(vis[i] == false){
                if(cycleDetected(i, v, vis, list) == true) ans = true;
            }
        }
        if(ans) System.out.print("Cycle Detected");
        else System.out.print("No Cycle Detected");
    }
    public static boolean cycleDetected(int src, int v, boolean[] vis, ArrayList<ArrayList<Integer>> list){
        Queue<int[]> q = new LinkedList<>();
        vis[src] = true;
        q.add(new int[]{src, -1});
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int parent = q.peek()[1];
            q.remove();
            for(int adjacent: list.get(node)){
                if(vis[adjacent] == false){
                    vis[adjacent] = true;
                    q.add(new int[]{adjacent, node});
                }
                else if(parent != adjacent){
                    return true;
                }
            }
        }
        return false;
    }
}
