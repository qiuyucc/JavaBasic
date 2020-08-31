public class MakingChange {

    public static void main(String[] args){
        System.out.print("Returns: "+ smallestChange(47));
    }

    public  static int smallestChange(long x) {
        int number = (int)x;
        int coins []={1, 10, 25, 100, 1000, 2500, 10000, 100000, 250000, 1000000,25000000};

        int m = coins.length;

        int table[] = new int[number+1];
        //if i given is 0
        table[0] =0;

        //initialize all table value
        for (int i = 1; i <= m; i++)
            table[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= m; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
                if (coins[j] <= i)
                {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;


                }

        }
        return table[m];

    }
}