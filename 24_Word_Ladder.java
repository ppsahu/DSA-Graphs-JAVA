import java.util.*;

public class Word_Ladder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String beginWord = sc.nextLine();
        String endWord = sc.nextLine();
        int n = sc.nextInt();
        ArrayList<String> wordList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            wordList.add(str);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < wordList.size() ; i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        int ans = 0;
        while(!q.isEmpty()){
            String word = q.peek().first;
            
            int steps = q.peek().second;
            if(word.equals(endWord)){ 
                ans = steps;
                break;
            }
            q.remove();
            for(int i = 0 ; i < word.length() ; i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char[] replaceWord = word.toCharArray();
                    replaceWord[i] = ch;
                    String newWord = new String(replaceWord);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.add(new Pair(newWord, steps + 1));
                    }
                }
            }
        }
        //System.out.print("No. of steps to reach from beginWord to endWord: " + ans);
        System.out.print(ans);

    }
}
class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
