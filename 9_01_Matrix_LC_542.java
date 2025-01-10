import java.util.*;

public class _01_Matrix {
    
    // distance from 0
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
        sc.close();
        int[][] vis = new int[x][y];
        int[][] dist = new int[x][y];
        Queue<Triplet> q = new LinkedList<Triplet>();
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                if(grid[i][j] == 0){
                    vis[i][j] = 1;
                    q.add(new Triplet(i, j, 0));
                }
                else vis[i][j] = 0;
            }
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!q.isEmpty()){
            int ro = q.peek().first;
            int co = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[ro][co] = steps;
            for(int i = 0 ; i < dist.length ; i++){
                int nrow = ro + dir[i][0];
                int ncol = co + dir[i][1];
                if(nrow >= 0 && ncol >= 0 && nrow < x && ncol < y && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Triplet(nrow, ncol, steps + 1));
                }
            }
        }
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Triplet{
    int first;
    int second;
    int third;
    Triplet(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
