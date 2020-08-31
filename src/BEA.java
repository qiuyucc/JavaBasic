import java.io.*;
import java.util.*;

public class BEA {
    //****************************************************************
    private static int[][] attribute;
    private static int[][] clustering;
    private static int n;

    private static StringTokenizer st;
    private int index;
    private int[] array;
//******************************************************************

    //******************************************************************
    public static void main(String[] args) throws Exception{

        System.out.println("Please input the size of the matrix: ");

        int i=0;

        BufferedReader bra = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bra.readLine());

        attribute = new int[n][n];

        clustering = new int[n][n];

        while(i<n) {

            System.out.println("Please enter the row "+ (i+1) +" of the AA:");

            bra = new BufferedReader(new InputStreamReader(System.in));

            st = new StringTokenizer(bra.readLine());

            for(int j=0;j<n;j++) {

                attribute[i][j] = Integer.parseInt(st.nextToken());
            }

            i++;
        }

        BEA bea = new BEA();
        bea.run();
        for (;i<n;i++) {

            for (int j=0;j<n;j++) {

                System.out.print(clustering[i][j] + " ");
            }

            System.out.println();
        }

    }
    //*********************************************************************
    public void run() {

        array = new int[n];

        int loc = 0;

        Vector v = new Vector();

        int result = 0;

        for (int i=0;i<n;i++) {

            this.clustering[i][0] = this.attribute[i][0];

            this.clustering[i][1] = this.attribute[i][1];
        }

        index = 2;

        int[] s = new int[3];

        while(index<=n-1) {

            array = this.attribute[index];

            for (int i=0;i<=index-1;i++) {

                result = this.cont(i-1,index,i);

                System.out.println("index: "+ index +" result: "+cont(2,3,4));

                //s = i - 1 + " " + index + " " + i;

                s[0] = i-1;s[1] = index;s[2] = i;

                Union u = new Union(result, s);

                v.addElement(u);
            }

            result = this.cont(index-1, index, index+1);

            System.out.println("Result-->"+cont(1,2,3));

            //s = index - 1 + " " + index + " " + (index + 1);

            s = new int[3];

            s[0] = index-1;s[1] = index;s[2] = index+1;

            Union u = new Union(result, s);

            v.addElement(u);

            u = this.maxCont(v);

            s = u.getOrder();



            System.out.println("-----------------------");

            for (int i=0;i<v.size();i++) {

                System.out.println(((Union)v.elementAt(i)).getValue()+":"+((Union)v.elementAt(i)).getOrder());
            }

            int firstPos = Integer.parseInt(st.nextToken());

            System.out.println("FFFF "+s);

            loc = s[0]+1;

            int[] temp = new int[n];

            for (int i=0;i<n;i++) {

                temp[i] = this.attribute[i][firstPos];
            }

            for (int i=0;i<temp.length;i++) {
                System.out.println(temp[i]);
            }

            // loc = this.checkPos(temp) + 1;

            System.out.println(loc);

            loc = Integer.parseInt(st.nextToken()) + 1;

            System.out.println(u.getOrder());

            for (int j=index;j>=loc;j--) {

                for (int m=0;m<n;m++) {

                    if(j-1<0){
                        this.clustering[m][j] = 0;
                    }else

                        this.clustering[m][j] = this.clustering[m][j-1];
                }

            }



            for (int i=0;i<this.clustering.length;i++) {

                this.clustering[i][loc] = this.attribute[i][index];
            }

            //printCA();

            index++;

            v.removeAllElements();

            break;
        }

        int[] temp = new int[n];

        int[] tempPos = new int[n];

        int[][] tempC = new int[n][n];

        int[] original = new int[n];

        for (int i=0;i<n;i++) {

            for (int j=0;j<n;j++) {

                tempC[i][j] = this.clustering[i][j];
            }
        }

        for (int i=0;i<n;i++) {

            for (int j=0;j<n;j++) {

                temp[j] = this.clustering[j][i];

            }

            tempPos[i] = this.checkPosV(temp);


        }


        for (int i=0;i<n;i++) {

            original[i] = i;
        }

        for (int i=0;i<n;i++) {

            if (tempPos[i]!=original[i]) {

                int pos1 = this.checkPosH(tempC[tempPos[i]]);

                int pos2 = this.checkPosH(tempC[original[i]]);

                System.out.println(pos1);
                System.out.println(pos2);

                for (int j=0;j<n;j++) {

                    this.clustering[pos1][j] = tempC[original[i]][j];

                    this.clustering[pos2][j] = tempC[tempPos[i]][j];
                }

                //this.printCA();

                int t = original[pos1];

                original[pos1] = original[pos2];

                original[pos2] = t;

                for(int j=0;j<n;j++){
                    System.out.print(original[j]+" ");
                }
                System.out.println();
            }
        }


    }
    //**************************************************************

    //****************************************************************

    //****************************************************************

    //******************************************************************
    public int cont(int ai, int ak, int aj) {

        return 2 * bond(ai,ak) + 2 * bond(ak,aj) - 2 * bond(ai,aj);
    }
    //********************************************************************
    public int bond(int ax, int ay) {

        if (ax<0||ay<0||ax>n-1||ay>n-1) {

            return 0;
        }

        int result = 0;

        if (ax==index) {

            for (int i=0;i<n;i++) {

                result += array[i] * this.clustering[i][ay];

            }

            return result;
        }

        if (ay==index) {

            for (int i=0;i<n;i++) {

                result += this.clustering[i][ax] * array[i];

            }
        }

        for (int i=0;i<n;i++) {

            result += this.clustering[i][ax] * this.clustering[i][ay];

        }


        return result;
    }
    //*****************************************************************
    public Union maxCont(Vector v) {

        int max = ((Union)v.elementAt(0)).getValue();

        for (int i=1;i<v.size();i++) {

            if (max < ((Union)v.elementAt(i)).getValue()) {

                max = ((Union)v.elementAt(i)).getValue();
            }
        }

        for (int i=0;i<v.size();i++) {

            if (max == ((Union)v.elementAt(i)).getValue()) {

                return (Union)v.elementAt(i);
            }
        }

        return null;
    }
    //**************************************************************
    public int checkPosV(int[] array) {


        boolean same = false;

        int[] temp = new int[n];

        for (int i=0;i<n;i++) {

            for (int j=0;j<n;j++) {

                temp[j] = this.attribute[j][i];

            }


            for (int k=0;k<n;k++) {

                if (array[k]==temp[k]) {

                    same = true;

                    continue;

                }else{

                    same = false;

                    break;
                }
            }

            if (same == true) return i;

        }



        return -1;
    }
    //**************************************************************
    public int checkPosH(int[] array) {

        boolean same = false;

        for (int i=0;i<n;i++) {

            for (int j=0;j<n;j++) {

                if (array[j] == this.clustering[i][j]) {

                    same = true;

                    continue;

                }else{

                    same = false;

                    break;
                }
            }

            if (same == true) return i;
        }

        return -1;
    }
//******************************************************************

    //****************************************************************
    class Union {

        private int contValue;
        private int[] ordering;

        public Union(int v, int[] s) {

            this.contValue = v;

            this.ordering = s;
        }

        public int[] getOrder() {

            return this.ordering;
        }

        public int getValue() {

            return this.contValue;
        }
    }
}