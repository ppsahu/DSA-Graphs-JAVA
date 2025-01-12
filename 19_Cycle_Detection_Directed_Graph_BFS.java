import java.util.*;

public class Cycle_Detection_Directed_Graph_BFS {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = sc.nextInt();
        for(int i = 0 ; i < v ; i++){
            int n = sc.nextInt();
            ArrayList<Integer> edges = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                edges.add(sc.nextInt());
            }
            list.add(edges);
        }

        int[] inDegree = new int[v];
        for(int i = 0 ; i < v ; i++){
            for(int it : list.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < v ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            cnt++;
            q.remove();
            for(int it : list.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(cnt == v) System.out.print("No Cycle Detected");
        else System.out.print("Cycle Detected");
    }
}
