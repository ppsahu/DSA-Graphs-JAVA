import java.util.*;

public class Eventual_Safe_States_BFS {
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

        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for(int i = 0 ; i < v ; i++){
            adjRev.add(new ArrayList<>());
        }
        int[] inDegree = new int[v];
        for(int i = 0 ; i < v ; i++){
            for(int it : list.get(i)){
                adjRev.get(it).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < v ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            safeNodes.add(node);
            q.remove();
            for(int it : adjRev.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        Collections.sort(safeNodes);
        System.out.println("the safe nodes for the given graph are: ");
        for(int it : safeNodes){
            System.out.print(it + " ");
        }
    }
}
