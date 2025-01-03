import java.util.*;
public class No_Of_Provinces {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[][] adj = new int[x][x];
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < x ; j++){
                adj[i][j] = sc.nextInt();
            }
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < x ; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < x ; j++){
                if(adj[i][j] == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        // for(ArrayList<Integer> list : adjList){
        //     for(int node : list){
        //         System.out.print(node + " ");
        //     }
        //     System.out.println();
        // }
        int count = 0;
        boolean[] vis = new boolean[x];
        for(int i = 0 ; i < vis.length ; i++){
            if(vis[i] == false){
                count++;
                dfs(i, vis, adjList);
            }
        }
        System.out.print("No. of Provinces: " + count);
    }
    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjList){
        vis[node] = true;
        for(int it : adjList.get(node)){
            if(!vis[it]){
                dfs(it, vis, adjList);
            }
        }
    }
}
