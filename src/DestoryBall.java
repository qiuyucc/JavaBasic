public class DestoryBall {

    public static void main(String[] args) {
        System.out.println(ballColor(1, 1, 3, 3));
        System.out.println(ballColor(3, 4, 5, 4));
        System.out.println(ballColor(7, 7, 1, 7));
        //System.out.println(ballColor(1000000000000, 1, 1, 1000000000002));
        System.out.println(ballColor(653,32,1230,556));
    }


    public static String ballColor(long r, long g, long b, long k) {

        //start from step 1
        long round3 = 0;
        long round2 = 0;
        //get biggest and smallest in current
        long min = Math.min(Math.min(r, g), b);
        long max = Math.max(Math.max(r, g), b);
        long mid = (r + g + b) - min - max;
        round3 = min * 3;
        round2 = min * 3 + (mid - min) * 2;
        if (k <= round3) {
            long kindex = k % 3;
            return color(kindex);
        } else if (k<=round2) {
            return colorRound2(k, r, g, min);
        } else {
            return colorByMax(r, g, max);
        }

    }

    public static String colorRound2(long k, long r, long g,  long min) {
        long r1 = r - min;
        long g1 = g - min;
        long k1 = k - min * 3;
        long kindex = k1 % 2;
        if (r1 == 0) {
            if (kindex == 1) {
                return "GREEN";
            } else {
                return "BLUE";
            }
        }else if (g1 == 0) {
            if (kindex == 1) {
                return "RED";
            } else {
                return "BLUE";
            }
        }else {
            if (kindex == 1) {
                return "RED";
            } else {
                return "GREEN";
            }
        }
    }

    public static String colorByMax(long r, long g, long max) {
        if (max == r) {
            return "RED";
        }else if (max == g) {
            return "GREEN";
        }else {
            return "BLUE";
        }
    }
  // get color code by number
    public static String color(long N) {
    switch ((int)N) {
        case 0:
            return "BLUE";
        case 1:
            return "RED";
        case 2:
            return "GREEN";
        default:
            break;
    }
    return "ERROR";
}
}