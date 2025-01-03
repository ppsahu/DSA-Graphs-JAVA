import java.util.*;

public class No_Of_Islands {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        boolean vis[][] = new boolean[m][n];
        for(int  i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(vis[i][j] == false && grid[i][j] == 1){
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        System.out.print("No. of Islands: " + count);
    }
    public static void bfs(int ro, int co, boolean[][] vis, int[][] grid){
        vis[ro][co] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ro, co});
        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = grid.length;
        int n = grid[0].length;
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.remove();
            for(int del = 0 ; del < dir.length ; del++){
                int nrow = row + dir[del][0];
                int ncol = col + dir[del][1];

                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && vis[nrow][ncol] == false && grid[nrow][ncol] == 1){
                    vis[nrow][ncol]  = true;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }
    }
}
