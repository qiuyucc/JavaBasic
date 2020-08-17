public class StringSegment {
   //go through every digitals in string
    public static void main(String [] args){
       // String a = "aaabbaaac";
        String a = "aabbccdd";
        //String a = "abba";
        System.out.print("Returns:"+averageLenth(a));
    }
    //output is double number
    public static double averageLenth(String a){
        double count = 1;

        for(int i=1;i<a.length();i++){
            //if digitals are unmatched, count ++1;
            if(a.charAt(i-1)!=a.charAt(i)){
                count++;
            }
        }

        int sum = a.length();
        double  res = sum/count;
        return res;

    }

}
