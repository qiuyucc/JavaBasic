public class PouringWater {


    public static void main(String[] args) {

        System.out.println(new PouringWater().getMinBottles(13, 2));
        System.out.println(new PouringWater().getMinBottles(9,5));
        System.out.println(new PouringWater().getMinBottles(3, 1));
        System.out.println(new PouringWater().getMinBottles(1000000, 5));


    }
        public int getMinBottles(int N, int K) {
            int result = 0;
            //loop to find the next number
            while (getNext(N) > K) {
                int v = N & (-N);
                result += v;
                N += v;
            }

            return result;
        }

        public int getNext(int n) {
            int getNext = 0;
            int h = n;
            while (h != 0) {
                if ((h & 0x01) == 0x01) {
                    getNext++;
                }
                h >>= 1;
            }
            return getNext;
        }


    }
