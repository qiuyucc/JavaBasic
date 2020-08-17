public class VerticalFall {

    public static void main(String [] args){
        int x = 15;
        int y = 12;
       // String [] obstacles = {"005 010 020"};
        String [] obstacles = {"010 010 020","015 010 020","005 020 050"};
        System.out.println(dropTime(x, y,obstacles));
    }

    public static int dropTime(int x, int y, String[] obstacles){
         int nowx = x;
         int nowy = y;

        int[] oy = new int[obstacles.length];
        int[] ox1 = new int[obstacles.length];
        int[] ox2 = new int[obstacles.length];
        for (int i = 0; i< obstacles.length; i++) {
            oy[i]=Integer.parseInt(obstacles[i].split(" ")[0]);
            ox1[i]=Integer.parseInt(obstacles[i].split(" ")[1]);
            ox2[i]=Integer.parseInt(obstacles[i].split(" ")[2]);
        }

        for (int i = 0; i <obstacles.length-1; i++) {
            for (int j = i+1; j < obstacles.length; j++) {
                if (oy[i]<oy[j]) {
                    int buff = oy[i];
                    oy[i]=oy[j];
                    oy[j]=buff;
                    buff = ox1[i];
                    ox1[i]=ox1[j];
                    ox1[j]=buff;
                    buff = ox2[i];
                    ox2[i]=ox2[j];
                    ox2[j]=buff;
                }
            }
        }

        int count=0;
        for (int i = 0; i<obstacles.length; i++) {
            if (oy[i]<=nowy && ox1[i]<=nowx && nowx<=ox2[i]) {
                count+=(nowy-oy[i]+5);
                nowy=oy[i];
                nowx=ox2[i];
            }
        }
        count+=(nowy);
        nowy=0;
        return count;
    }

}
