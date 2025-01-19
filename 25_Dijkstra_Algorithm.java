import java.util.*;

public class Dijkstra_Algorithm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        int v = sc.nextInt();
        for(int i = 0 ; i < v ; i++){
            int n = sc.nextInt();
            ArrayList<int[]> edges = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                int[] edgeWt = new int[2];
                edgeWt[0] = sc.nextInt();
                edgeWt[1] = sc.nextInt();
                edges.add(edgeWt);
            }
            list.add(edges);
        }
        int src = sc.nextInt();
        ArrayList<Integer> dist = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for(int i = 0 ; i < list.size() ; i++){
            dist.add(Integer.MAX_VALUE);
        }
        dist.set(src, 0);
        pq.add(new int[]{src, 0});
        while(!pq.isEmpty()){
            int edge = pq.peek()[0];
            int distance = pq.peek()[1];
            pq.remove();
            for(int i = 0 ; i < list.get(edge).size() ; i++){
                int node = list.get(edge).get(i)[0];
                int wt = list.get(edge).get(i)[1];
                if(dist.get(node) > distance + wt){
                    dist.set(node, distance + wt);
                    pq.add(new int[]{node, dist.get(node)});
                }
            }
        }
        for(int i = 0 ; i < dist.size() ; i++){
            System.out.print(dist.get(i) + " ");
        }
    }
}
