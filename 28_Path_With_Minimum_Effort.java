import java.util.*;

public class Path_With_Minimum_Effort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] heights = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                heights[i][j] = sc.nextInt();
            }
        }        
        int[][] dist = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Triplet> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        dist[0][0] = 0;
        pq.add(new Triplet(0, 0, 0));
        int ans = 0;
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while(!pq.isEmpty()){
            int effort = pq.peek().distance;
            int ro = pq.peek().row;
            int co = pq.peek().col;
            pq.remove();
            if(ro == m - 1 && co == n - 1){
                ans = effort;
                break;
            }
            for(int i = 0 ; i < dir.length ; i++){
                int nrow = ro + dir[i][0];
                int ncol = co + dir[i][1];
                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n){
                    int newEffort = Math.max(effort, Math.abs(heights[ro][co] - heights[nrow][ncol]));
                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Triplet(newEffort, nrow, ncol));
                    }
                }
            }
        }
        System.out.print("The minimum effort to reach the end: "+ ans);
    }
}
class Triplet{
    int distance;
    int row;
    int col;
    Triplet(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
