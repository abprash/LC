package group.LC;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<10; i++){
            dfs(i,n,ans);
        }
        return ans;
    }
    
    public void dfs(int cur, int n, List<Integer> ans ){
        if(cur > n)
            return;
        else{
            ans.add(cur);
            for(int i=0; i<10; i++){
                if(10*cur+i > n)
                    return;
                else
                    dfs(10*cur+i,n,ans);
            }
        }
    }
}