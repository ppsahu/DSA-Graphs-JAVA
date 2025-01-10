import java.util.*; 

public class Surrounded_Regions {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] region = new char[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                region[i][j] = sc.next().charAt(0);
            }
        }
        int[][] vis = new int[m][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i = 0 ; i < n ; i++){
            //first row
            if(region[0][i] == 'O' && vis[0][i] == 0){
                dfs(0, i, vis, region, dir);
            }
            //last row
            if(region[m - 1][i] == 'O' && vis[m - 1][i] ==0){
                dfs(m - 1, i, vis, region, dir);
            }
        }
        for(int i = 0 ; i < m ; i++){
            //first col
            if(region[i][0] == 'O' && vis[i][0] == 0){
                dfs(i, 0, vis, region, dir);
            }
            //last col
            if(region[i][n - 1] == 'O' && vis[i][n - 1] == 0){
                dfs(i, n - 1, vis, region, dir);
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(vis[i][j] == 0 && region[i][j] == 'O'){
                    region[i][j] = 'X';
                }
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(region[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void dfs(int ro, int co, int[][] vis, char[][] region, int[][] dir){
        vis[ro][co] = 1;
        int m = region.length;
        int n = region[0].length;
        for(int i = 0 ; i < dir.length ; i++){
            int nrow = ro + dir[i][0];
            int ncol = co + dir[i][1];
            if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && vis[nrow][ncol] == 0 && region[nrow][ncol] == 'O'){
                dfs(nrow, ncol, vis, region, dir);
            }
        }
    }
}
