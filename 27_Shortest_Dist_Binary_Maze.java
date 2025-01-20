import java.util.*;
public class Shortest_Dist_Binary_Maze {
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
        int[] source = new int[2];
        int[] destination = new int[2];
        source[0] = sc.nextInt();
        source[1] = sc.nextInt();
        destination[0] = sc.nextInt();
        destination[1] = sc.nextInt();

        if(source[0] == destination[0] && source[1] == destination[1]){
            System.out.print(0);
        }
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(0, source[0], source[1]));
        int[][] dist = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        dist[source[0]][source[1]] = 0;
        while(!q.isEmpty()){
            int curr = q.peek().first;
            int ro = q.peek().second;
            int co = q.peek().third;
            q.remove();
            for(int i = 0 ; i < dir.length ; i++){
                int nrow = ro + dir[i][0];
                int ncol = co + dir[i][1];
                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n &&
                grid[nrow][ncol] == 1 && curr + 1 < dist[nrow][ncol]){
                    if(nrow == destination[0] && ncol == destination[1]){
                        System.out.print(curr + 1);
                    }
                    dist[nrow][ncol] = curr + 1;
                    q.add(new Triplet(dist[nrow][ncol], nrow, ncol));
                }
            }
        }
        if(dist[destination[0]][destination[1]] == Integer.MAX_VALUE){
            System.out.print("Destination Cannot Be Reached!");
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
