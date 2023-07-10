public class romanTOint {
    /*public int romanToInt(String s) {
        int prenum=getVaule(s.charAt(0)),currnum=0,sum=0;
        for(int i=1;i<s.length();i++){
            currnum=getVaule(s.charAt(i));
            if(prenum<currnum) sum-=prenum;
            else sum+=prenum;
            prenum=currnum;
        }
        sum+=prenum;
        return sum;
    }
    public int getVaule(char a){
        switch(a){
            case'I':return 1;
            case'V':return 5;
            case'X':return 10;
            case'L':return 50;
            case'C':return 100;
            case'D':return 500;
            case'M':return 1000;
            default:return 0;
        }
    }*/
    public int romanToInt(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int result = 0;
        for (int i=0; i<s.length(); i++) {
            result += which(s.charAt(i));
        }
        return result;
    }

    public int which(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }
}
