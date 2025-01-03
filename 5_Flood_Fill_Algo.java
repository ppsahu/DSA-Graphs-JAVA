import java.util.*;

public class Flood_Fill_Algo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] image = new int[x][y];
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                image[i][j] = sc.nextInt();
            }
        }
        int srow = sc.nextInt();
        int scol = sc.nextInt();
        int newColor = sc.nextInt();

        int[][] ans = image;
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        int ini = image[srow][scol];
        dfs(ans, image, srow, scol, ini, dir, newColor);

        for(int i = 0 ; i < ans.length ; i++){
            for(int j = 0 ; j < ans[0].length ; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void dfs(int[][] ans, int[][] image, int ro, int co, int ini, int[][] dir, int newColor){
        ans[ro][co] = newColor;

        int m = image.length;
        int n = image[0].length;

        for(int i = 0 ; i < dir.length ; i++){
            int nrow = ro + dir[i][0];
            int ncol = co + dir[i][1];
            if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && image[nrow][ncol] == ini && ans[nrow][ncol] != newColor){
                dfs(ans, image, nrow, ncol, ini, dir, newColor);
            }
        }
    }
}
