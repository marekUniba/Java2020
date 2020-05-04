import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Jedalen {
    final int D = 100;
    final int L = 20;
    final int T = 20;
    int najedloSa = 0;
    Random rnd = new Random();
    Semaphore lyzice = new Semaphore(L);
    Semaphore taniere = new Semaphore(T);

    class Dieta extends Thread {
        int ID;
        public Dieta(int ID) {
            this.ID = ID;
            start();
        }
        @Override
        public void run() {
            try {
                sleep(rnd.nextInt(300));
            } catch (InterruptedException e) {
                return;
            }
            System.out.println(ID + " sa dosuchtalo na obed");
            boolean lyzicaSkor = rnd.nextBoolean();
            if (lyzicaSkor) {
                long time1 = System.currentTimeMillis();
                try {
                    lyzice.acquire();
                    System.out.println(ID + " ziskalo lyzicu po " + (System.currentTimeMillis() - time1));
                } catch (InterruptedException e) {
                    return;
                }
            } else {
                long time2 = System.currentTimeMillis();
                try {
                    taniere.acquire();
                    System.out.println(ID + " ziskalo tanier " + (System.currentTimeMillis()-time2));
                } catch (InterruptedException e) {
                    return;
                }
            }
            try {
                sleep(rnd.nextInt(200));
            } catch (InterruptedException e) {
                return;
            }
            if (!lyzicaSkor) {
                long time1 = System.currentTimeMillis();
                try {
                    lyzice.acquire();
                    System.out.println(ID + " ziskalo lyzicu po " + (System.currentTimeMillis() - time1));
                } catch (InterruptedException e) {
                    return;
                }
            } else {
                long time2 = System.currentTimeMillis();
                try {
                    taniere.acquire();
                    System.out.println(ID + " ziskalo tanier " + (System.currentTimeMillis()-time2));
                } catch (InterruptedException e) {
                    return;
                }
            }
            System.out.println(ID + " je polievku");
            try {
                sleep(rnd.nextInt(300));
            } catch (InterruptedException e) {
                return;
            }
            lyzice.release();
            taniere.release();
            najedloSa++;
            System.out.println(ID + " najedlo sa");
        }
    }
    class Deadlocker extends Thread {
        @Override
        public void run() {
            int prevState = najedloSa;
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (najedloSa == prevState) { // asi deadlock
                    break;
                } else
                    prevState = najedloSa;
            }
        }
    }
    public static void main(String[] args) {
        Jedalen J = new Jedalen();
        List<Dieta> al = new ArrayList<>();
        for (int i = 0; i < J.D; i++) {
            al.add(J.new Dieta(i));
        }
        Deadlocker dl = J.new Deadlocker();
        dl.start();
        try {
            dl.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (J.najedloSa != J.D)
            System.out.println("--------deadlock");
            for(Dieta d : al) {
                d.interrupt();
            }
    }
}
