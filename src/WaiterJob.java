import java.util.Arrays;

public class WaiterJob {

    public static void main(String []args){
        int [] tables = {4};
        int [] groupSizes =  {4,8,4,2,2,4};
        int [] arrivals={0,10,12,16,18,26};
        int [] departures = {10,20,18,26,36,28};
        System.out.println("Returns:"+ allocateTables(tables,groupSizes,arrivals,departures));

    }

    public static int allocateTables(int[] tables, int[] groupSizes, int[] arrivals,
                              int[] departures) {
        Arrays.sort(tables);
        int tableTimes[] = new int[tables.length];
        int turnAway = 0;
        for (int i = 0; i < groupSizes.length; i++) {
            boolean allocated = false;
            for (int j = 0; j < tables.length; j++) {
                if (tables[j] >= groupSizes[i] && arrivals[i] >= tableTimes[j]) {
                    tableTimes[j] = departures[i];
                    allocated = true;
                    break;
                }
            }
            if (!allocated) {
                turnAway += groupSizes[i];
            }
        }
        return turnAway;
    }

}
