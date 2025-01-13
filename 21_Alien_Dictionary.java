import java.util.*;

public class Alien_Dictionary {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int x = sc.nextInt();
        String[] dict = new String[x];
        for(int i = 0 ; i < x ; i++){
            dict[i] = sc.next();
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < k ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < dict.length - 1; i++){
            String str1 = dict[i];
            String str2 = dict[i + 1];
            int len = Math.min(str1.length(), str2.length());
            for(int j = 0 ; j < len ; j++){
                if(str1.charAt(j) != str2.charAt(j)){
                    list.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
                    break;
                }
            }
        }
        ArrayList<Integer> topo = topoSort(k, list);
        String ans = "";
        for(int it : topo){
            ans = ans + (char)(it + (int)('a'));
        }
        System.out.print(ans);
    }
    public static ArrayList<Integer> topoSort(int k, ArrayList<ArrayList<Integer>> list){
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[k];
        for(int i = 0 ; i < k ; i++){
            for(int it : list.get(i)){
                inDegree[it]++;
            }
        }
        
        for(int i = 0 ; i < k ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            topo.add(node);
            q.remove();
            for(int it : list.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(topo.size() == k) return topo;
        return new ArrayList<>();
    }
}
