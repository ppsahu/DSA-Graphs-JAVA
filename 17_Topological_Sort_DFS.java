import java.util.*;

public class Topological_Sort {
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
        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[v];
        for(int i = 0 ; i < v ; i++){
            if(vis[i] == 0){
                dfs(i, v, vis, stack, list);
            }
        }
        int[] ans = new int[v];
        int c = 0;
        while(!stack.isEmpty()){
            ans[c++] = stack.peek();
            stack.pop();
        }
        for(int i = 0 ; i < ans.length ; i++){
            System.out.print(ans[i] + " ");
        }
    }
    public static void dfs(int edge, int v, int[] vis, Stack<Integer> stack, 
    ArrayList<ArrayList<Integer>> list){
        vis[edge] = 1;
        for(int it : list.get(edge)){
            if(vis[it] == 0){
                dfs(it, v, vis, stack, list);
            }
        }
        stack.add(edge);
    }
}
