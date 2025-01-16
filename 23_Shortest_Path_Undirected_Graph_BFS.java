import java.util.*;

public class Shortest_Path_Undirected_Graph {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = sc.nextInt();
        for(int i = 0 ; i < v ; i++){
            int n = sc.nextInt();
            ArrayList<Integer> edges = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                edges.add(sc.nextInt());
            }
            adj.add(edges);
        }
        int src = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int[] dist = new int[v];
        for(int i = 0 ; i< dist.length ; i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        while(!q.isEmpty()){
            int edge = q.peek();
            q.remove();
            for(int it : adj.get(edge)){
                if(dist[edge] + 1 < dist[it]){
                    dist[it] = dist[edge] + 1;
                    q.add(it);
                }
            }
        }
        for(int i = 0 ; i < v ; i++){
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        for(int i = 0 ; i < v ; i++){
            System.out.print(dist[i] + " ");
        }
    }
}
