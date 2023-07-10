import java.util.LinkedList;

public class isValid {
    public static boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        LinkedList<Character> stack=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='{') stack.push('}');
            else if (c=='(') stack.push(')');
            else if(c=='[') stack.push(']');
            else if(stack.isEmpty()||c!=stack.pop()) return false;

        }
        if(!stack.isEmpty()) return false;
        return true;
    }
    public static void main(String[] args) {
        isValid.isValid("()");
        System.out.println();
    }
}
