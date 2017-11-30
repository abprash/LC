package group.LC;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[][] ans = new int[0][0];
        if(people == null || people.length == 0)
            return ans;
        //now start sorting them
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0])
                    return a[1]-b[1];
                else
                    return b[0]-a[0];
            }
        });
       
        // for(int[] person : people)
        // System.out.println(Arrays.toString(person));
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] person : people){
            list.add(person[1], new int[]{person[0],person[1]});
        }
        //System.out.println();
        // for(int[] person : list)
        //     System.out.println(Arrays.toString(person));
        ans = new int[people.length][2];
        for(int i=0; i<list.size();i++){
            int[] person = list.get(i);
            ans[i][0] = person[0];
            ans[i][1] = person[1];
        }
        return ans;
    }
}