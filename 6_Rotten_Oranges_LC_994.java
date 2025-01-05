import java.util.*;

class Triplet{
    int ro;
    int co;
    int time;
    Triplet(int ro, int co, int time){
        this.ro = ro;
        this.co = co;
        this.time = time;
    }
}
public class Rotten_Oranges {
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
        int count = 0;
        int cntFresh = 0;
        Queue<Triplet> q = new LinkedList<Triplet>();
        int[][] vis = new int[x][y];
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Triplet(i, j, 0));
                }
                else if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int tm = 0;
        while(!q.isEmpty()){
            int row = q.peek().ro;
            int col = q.peek().co;
            int t = q.peek().time;
            tm = Math.max(tm, t);
            q.remove();
            for(int i = 0 ; i < dir.length ; i++){
                int nrow = row + dir[i][0];
                int ncol = col + dir[i][1];
                if(nrow >= 0 && ncol >= 0 && nrow < x && ncol < y && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 2;
                    q.add(new Triplet(nrow, ncol, t + 1));
                    count++;
                }
            }
        }
        if(count != cntFresh) System.out.print("Not possible");
        else System.out.print("Time taken: " + tm + " secs");
    }
}
