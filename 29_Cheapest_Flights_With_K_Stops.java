import java.util.*;
public class Cheapest_Flights_With_K_Stops {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int src = sc.nextInt();
        int dst = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        int[][] flights = new int[x][3];
        for(int i = 0 ; i < x ; i++){
            flights[i][0] = sc.nextInt();
            flights[i][1] = sc.nextInt();
            flights[i][2] = sc.nextInt(); 
        }
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i  = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < x ; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(0, src, 0));
        int[] dist = new int[n];
        for(int i = 0 ; i < n ; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        while (!q.isEmpty()) {
            int stops = q.peek().first;
            int node = q.peek().second;
            int distance = q.peek().third;
            q.remove();
            if(stops > k) continue;
            for(Pair item : adj.get(node)){
                int edge = item.first;
                int wt = item.second;
                if(distance + wt < dist[edge] && stops <= k){
                    dist[edge] = distance + wt;
                    q.add(new Triplet(stops + 1, edge, distance + wt));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) System.out.print("Destination can't be reached");
        else System.out.print("Destination can be reached with distance: " + dist[dst]);
    }
}
class Triplet{
    int first;
    int second;
    int third;
    Triplet(int first, int second, int third){
        this.first =first;
        this.second = second;
        this.third = third;
    }
}
class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
