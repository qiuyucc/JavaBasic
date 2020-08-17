public class WordScramble {

    public static void main(String[]args){
            String a = "XYz";
            String b = "aeioOa";
           System.out.print("Returns: "+'\u0022' + translate(b) + '\u0022');
    }


    public static String translate(String a){

        String first = "";
        String last  = "";

        //go through the list
        if(a.length()>50){
            return  null;
        }else {
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                String s = String.valueOf(c);
                if (s.equals("a") || s.equals("A") || s.equals("E") || s.equals("e") || s.equals("i") || s.equals("I") || s.equals("O") || s.equals("o") || s.equals("U") || s.equals("u")) {
                    last = last + s;
                } else {
                    first = first + s;
                }
            }
            String result = first.concat(last);

            return result;
        }
    }

}
