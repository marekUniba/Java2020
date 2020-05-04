import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Kantina {
    final int D = 100;
    final int L = 30;
    final int T = 30;
    int najedeneDieti = 0;
    Semaphore lyzice = new Semaphore(L);
    Semaphore taniere = new Semaphore(T);

    class Dieta extends Thread {
        Random rnd = new Random();
        int ID;
        public Dieta(int ID) {
            this.ID = ID;
        }

        @Override
        public void run() {
            System.out.println("dieta " +ID);
            try {
                sleep(rnd.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ID + " prislo na obed ");
            boolean pravdep = rnd.nextBoolean();
            if (pravdep) {
                try {
                    lyzice.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(ID + " ziskalo lyzicu");
                try {
                    taniere.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(ID + " ziskalo lyzicu");
                //  ....
            } else {

            }
            taniere.release();
            lyzice.release();
            najedeneDieti++;
        }
    }

    public static void main(String[] args) {
        //List<Dieta> al = new ArrayList<>();
        Kantina k = new Kantina();
        for(int i = 0; i <k.D; i++) {
            Dieta d = k.new Dieta(i);
            d.start();
            //al.addAll(d);
        }
    }
}
