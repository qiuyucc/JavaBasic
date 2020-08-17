public class ClockRepairs{

    //main method
    public static void main(String[]args) {
        int [] arr1 = {10,0,0,4,20};
        int npd =8;
//        int [] arr1 = {0,0,0};
//        int npd =10;
//        int [] arr1 = {100,100};
//        int npd =10 ;
//        int [] arr1 = { 27, 0, 0, 0, 0, 9};
//        int npd =9;
        System.out.println("Returns:"+days(arr1,npd));
    }

    public static int days(int[] arr1, int npd) {
        //inital 3 valuables
        int count=0;
        int before = 0;
        int after = 0;
        //loop the array
        for(int i=0; i<arr1.length;i++) {
            before = after+arr1[i];

            if(before>0) {
                after = before -npd;
                count ++;
            }
            //reset after value to 0
            if(after<0) {
                after=0;
            }
        }
        //generate output
        while(after>0) {
            after = after-npd;
            count++;
        }

        return count;
    }



}