import java.util.*;
public class No_of_Distinct_Island {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] grid = new int[x][y];
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int[][] vis = new int[x][y];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, vec, vis, set, grid, i, j);
                    set.add(vec);
                }
            }
        }
        System.out.print("No. of Distinct Islands: " + set.size());
    }
    public static String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    public static void dfs(int ro, int co, ArrayList<String> vec, int[][] vis, 
    HashSet<ArrayList<String>> set, int[][] grid, int row0, int col0){
        vis[ro][co] = 1;
        vec.add(toString(ro - row0, co - col0));
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0 ; i < dir.length ; i++){
            int nrow = ro + dir[i][0];
            int ncol = co + dir[i][1];
            if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, vec, vis, set, grid, row0, col0);
            }
        }
    }
}
