public class LOR {

    public static void main(String[] args) {
        System.out.println(maxDistance("LLLRLRRR"));
        System.out.println(maxDistance("R???L"));
        System.out.println(maxDistance("??????"));
        System.out.println(maxDistance("LL???RRRRRRR???") );
        System.out.println(maxDistance("L?L?") );
        System.out.println(maxDistance("??L?L?") );
    }
    public static int maxDistance(String input){
        //Split the input and return an array
        String[] splits = input.split("(?<=(.))(?!\\1)");
        if(splits.length==1&&splits[0].charAt(0)=='?')
        {
            return splits[0].length();
        }

        int index=0;
        int distanceMax=0;
        int preIndex;
        char preChar;
        char currentChar=' ';
        for(int i=0;i<splits.length;i++)
        {
            preIndex=index;
            index=0;
            preChar=currentChar;
            //Identify the sigle string
            String string=splits[i];
            
            if(string.charAt(0)=='L')
            {
                currentChar='L';
                index=index+string.length();
            }
            if(string.charAt(0)=='R')
            {
                currentChar='R';
                index=index-string.length();
            }
            if(string.charAt(0)=='?')
            {
                int count=string.length();
                String matchedChar="";
                if(i==0)
                {
                    matchedChar=splits[i+1];
                }
                else if (i==splits.length-1)
                {

                    matchedChar=splits[i-1];
                }
                else
                {
                    matchedChar= splits[i+1].length()>splits[i-1].length()? splits[i+1]:splits[i-1];
                }
                if(matchedChar.charAt(0)=='L')
                {
                    currentChar='L';
                    index=index+count;
                }
                else if(matchedChar.charAt(0)=='R')
                {
                    currentChar='R';
                    index=index-count;
                }
            }
            index=index+preIndex;
            //compare the distance
            if(distanceMax<Math.abs(index))
            {
                distanceMax=Math.abs(index);
            }
        }
        return distanceMax;
    }
  
}