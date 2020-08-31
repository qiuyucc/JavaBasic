
import java.util.*;

public class UnwindData {
    public static void main (String[]args){
        System.out.print(unwind("AAAAAAAAAAAAAAAAAAAAA"));
    }

    private static String unwind(String s) {

        //use stack to pop and push for []
        Stack<Integer> container = new Stack<Integer>();
         //make sure [ wont exit at 0 index
        for (int m = 0; s.indexOf('[') >= 0; ) {
            for (int j = m; j < s.length(); j++) {
                if (s.charAt(j) == '[')
                    container.push(j);
                else if (s.charAt(j) == ']') {
                    int i = container.pop();
                    StringBuilder sb = new StringBuilder();
                    //string builder the first section of string
                    sb.append(s.substring(0, i));
                    for (int k = 0; k < s.charAt(i + 1) - '0'; k++)
                        sb.append(s.substring(i + 2, j));
                    m = sb.length();
                    sb.append(s.substring(j + 1));
                    s = sb.toString();
                    break;
                }
            }
        }
        return s;
    }

}
