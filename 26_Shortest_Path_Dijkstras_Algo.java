import java.util.*;

public class Shortest_Path_Dijkstras_Algo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        for(int i = 0 ; i < m ; i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        int src = 1;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        pq.add(new int[]{0, src});
        while(!pq.isEmpty()){
            int wt = pq.peek()[0];
            int node = pq.peek()[1];
            pq.remove();
            //System.out.print(adj.get(node).size());
            for(int i = 0 ; i < adj.get(node).size() ; i++){
                int distance = adj.get(node).get(i)[1];
                int edge = adj.get(node).get(i)[0];
                if(distance + wt < dist[edge]){
                    dist[edge] = distance + wt;
                    pq.add(new int[]{dist[edge], edge});
                    parent[edge] = node;
                }
            }
        }
        boolean check = false;
        List<Integer> path = new ArrayList<>();
        if(dist[n] == Integer.MAX_VALUE){
            dist[n] = -1;
            check = true;
        }
        if(!check){
            int node = n;
            while(parent[node] != node){
                path.add(node);
                node = parent[node];
            }
            path.add(1);
            Collections.reverse(path);
            for(int i : path){
                System.out.print(i + " ");
            }
        }
        else{
            for(int i : path){
                System.out.print(i + " ");
            }
        }
    }
}
