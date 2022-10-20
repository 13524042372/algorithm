public class SYN {
    private int a = 0;

    public synchronized int addAndGeta(){
        return a++;
    }
    public synchronized int subAndGeta(){
        return a--;
    }

    public static void main(String[] args) {
        SYN syn = new SYN();

    }

}
