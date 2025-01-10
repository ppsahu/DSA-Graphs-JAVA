import java.util.*;
public class No_Of_Enclaves {
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
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < y ; i++){
            //first row
            if(grid[0][i] == 1){
                vis[0][i] = 1;
                q.add(new int[]{0, i});
            }
            //last col
            if(grid[x - 1][i] == 1){
                vis[x - 1][i] = 1;
                q.add(new int[]{x - 1, i});
            }
        }
        for(int j = 0 ; j < x ; j++){
            //first col
            if(grid[j][0] == 1){
                vis[j][0] = 1;
                q.add(new int[]{j, 0});
            }
            if(grid[j][y - 1] == 1){
                vis[j][y - 1] = 1;
                q.add(new int[]{j, y - 1});
            }
        }

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!q.isEmpty()) {
            int ro = q.peek()[0];
            int co = q.peek()[1];
            q.remove();
            for(int i = 0 ; i < dir.length ; i++){
                int nrow = ro + dir[i][0];
                int ncol = co + dir[i][1];
                if(nrow >= 0 && ncol >= 0 && nrow < x && ncol < y && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }
        int lands = 0;
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    lands++;
                }
            }
        }
        System.out.print("No. of lands enclaved: " + lands);
    }
}
