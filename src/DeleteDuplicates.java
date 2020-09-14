import java.util.Arrays;

public class DeleteDuplicates {

    static int index;

    public static void main(String[] args) {

        int[] sequence={100,100,100,99,99,99,100,100,100};
        System.out.println(Arrays.toString(eliminate(sequence)));
    }
    public static int[] eliminate(int[] sequence){
        int[] numberArrary = new int[sequence.length];
        index = 0;
        int count=0;
        for(int i=0;i<sequence.length;i++)
            if(!validate(sequence[i],numberArrary)){
                numberArrary[index]=sequence[i];
                index++;
            }
        //create a array as temp storage
        int[] result = new int[index];
        for(int i=sequence.length-1;i>=0;i--)
            if(validate(sequence[i],numberArrary)&&!validate(sequence[i],result)){
                result[count]=sequence[i];
                count++;
                index--;
                if(index==0)break;
            }
        int [] result1= new int[result.length];
        for(int i=0;i<result1.length;i++)
            result1[i]=result[result.length-i-1];
        return result1;
    }

    static boolean validate(int n, int[] numberArrary){
        if(index==0)return false;
        for(int i=0;i<numberArrary.length;i++)
            if(numberArrary[i]==n) return true;
        return false;
    }
}