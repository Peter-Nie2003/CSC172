public class maximunWealth {
    public int maximumWealth(int[][] accounts) {
        int people=accounts.length;
        int wealth=accounts[0].length;
        int max=0,temp=0;
        for(int i=0;i<people;i++){
            for(int j=0;j<wealth;j++){
                temp+=accounts[i][j];
            }
            if(temp>max) max=temp;
            temp=0;
        }
        return max;
    }
}
