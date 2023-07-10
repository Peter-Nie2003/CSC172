public class longestCommonprefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        int length=strs[0].length();
        int count= strs.length;
        for(int i=0;i<length;i++){
            for(int j=1;j<count;j++){
                if( i+1>strs[j-1].length()|| i+1>strs[j].length()|| (strs[j-1].charAt(i)!=strs[j].charAt(i))){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
