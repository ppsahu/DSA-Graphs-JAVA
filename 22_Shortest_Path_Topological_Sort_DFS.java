import java.util.*;
public class Shortest_Path_Topological_Sort_DFS {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] list = new int[y][3];
        for(int i = 0 ; i < y ; i++){
            list[i][0] = sc.nextInt();
            list[i][1] = sc.nextInt();
            list[i][2] = sc.nextInt();
        }
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < x ; i++){
            ArrayList<int[]> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i = 0 ; i < y ; i++){
            int u = list[i][0];
            int v = list[i][1];
            int wt = list[i][2];
            adj.get(u).add(new int[]{v, wt});
        }
        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[x];
        for(int i = 0 ; i < x ; i++){
            if(vis[i] == 0){
                topoDFS(i, x, vis, list, adj, stack);
            }
        }
        int[] dist = new int[x];
        for(int i = 0 ; i < x ; i++) dist[i] = Integer.MAX_VALUE;
        dist[0] = 0;
        while(!stack.isEmpty()){
            int node = stack.peek();
            stack.pop();
            for(int i = 0 ; i < adj.get(node).size() ; i++){
                int v = adj.get(node).get(i)[0];
                int wt = adj.get(node).get(i)[1];
                if(dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                }
            }
        }
        for(int i = 0 ; i < x ; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        for(int i = 0 ; i < x ; i++){
            System.out.print(dist[i] + " ");
        }
    }
    public static void topoDFS(int edge, int v, int[] vis, int[][] list, 
    ArrayList<ArrayList<int[]>> adj, Stack<Integer> stack){
        vis[edge] = 1;
        for(int i = 0 ; i < adj.get(edge).size() ; i++){
            int v1 = adj.get(edge).get(i)[0];
            topoDFS(v1, v, vis, list, adj, stack);
        }
        stack.add(edge);
    }
}
