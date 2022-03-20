import java.util.*;

class Solution{
    public int[] solution(String[] id_list,String[] report,int k){
        HashMap<String,Integer> s2i = new HashMap<>(); // 아이디를 0, 1, 2, ..의 인덱스로 변환
        int n = id_list.length;
        HashSet<Integer>[] s = new HashSet[n];
        for(int i = 0; i < n; i++)
            s[i] = new HashSet<>();

        int[] cnt = new int[n];

        for(int i = 0; i < n; i++)
            s2i.put(id_list[i], i);

        for(String rep : report){
            String[] idlist = rep.split(" ");
            int id1 = s2i.get(idlist[0]);
            int id2 = s2i.get(idlist[1]);
            s[id2].add(id1);
        }
        for(int i = 0; i < n; i++){
            if(s[i].size() < k) continue;
            for(int x : s[i]) cnt[x]++;
        }
        return cnt;
    }
}
class Solution2 {
    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = {};
        answer=new int[commands.length];
        for (int i = 0;i<commands.length;i++){
            ArrayList<Integer> tmpArr=new ArrayList<Integer>();
            int start=commands[i][0]-1;
            int end=commands[i][1]-1;
            int pointer=commands[i][2]-1;
            for (int j = start ;j<=end;j++){
                tmpArr.add(array[j]);
            }
            Collections.sort(tmpArr);
            answer[i]=tmpArr.get(pointer);
        }
        return answer;
    }
}


public class main {
    public static void main(String[] args) {
        Solution2 s2=new Solution2();
        int[] a={1,5,2,6,3,7,4};
        int[][] com={{2,5,3},{4,4,1},{1,7,3}};
        int[] ans=s2.solution2(a,com);
        for (int i = 0 ;i<ans.length;i++){
            System.out.println(ans[i]);
        }

    }
}
