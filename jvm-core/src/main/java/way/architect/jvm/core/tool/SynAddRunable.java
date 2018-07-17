package way.architect.jvm.core.tool;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SynAddRunable implements Runnable {

    int a,b;

    public SynAddRunable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        for (int i=0; i<1000000; i++) {
            new Thread(new SynAddRunable(1,2), "thread"+i).start();
            new Thread(new SynAddRunable(2,1), "thread"+i).start();
        }
    }

}
