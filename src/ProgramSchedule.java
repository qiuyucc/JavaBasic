import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    public int x;
    public int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int compareTo(Pair o) {
        return o.y - y;
    }

}

public class ProgramSchedule {
    public static void main(String[]args){
        int [] x ={1,2,3,4};
        int [] y ={2,2,4,2};
        System.out.println("Returns:"+ schedule(x,y));
    }

    public static int schedule(int[] A, int[] B) {
        PriorityQueue<Pair> q = new PriorityQueue();
        for (int i=0; i < A.length; i++) {
            q.add(new Pair(A[i], B[i]));
        }
        int returns = 0;
        int start = 0;
        while (!q.isEmpty()) {
            Pair node = q.poll();
            start += node.x;
            returns = Math.max(returns, start+node.y);
        }
        return returns;
    }
}