import java.util.Random;

public class Rieky {
   final int POCET = 10;
   Rieka[] rieky = new Rieka[POCET];
   Random rnd = new Random();

    public Rieky() {
        for(int i = 0; i<POCET; i++) {
            rieky[i] = new Rieka();
            rieky[i].start();
        }
        Printer pr = new Printer();
        pr.start();
    }
    public void control(Rieka r) {
        for (Rieka x : rieky) {
            if (x != r && x != null && x.isAlive) {
                if (x.koryto == r.koryto)
                    r.isAlive = false;
            }
        }
    }
    class Rieka extends Thread {
        int koryto;
        boolean isAlive;
        public Rieka() {
            koryto = rnd.nextInt(80);
            isAlive = true;
        }
        @Override
        public void run() {
            System.out.println("run");
            while (isAlive) {
                update();
                control(this);
                try {
                    sleep(300+rnd.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        private void update() {
            System.out.println("update");
            int delta = rnd.nextInt(3)-1; // -1, 0, 1
            koryto += delta;
            if (koryto < 0) koryto =0;
            if (koryto > 79) koryto =79;
        }
    }
    class Printer extends  Thread {
        @Override
        public void run() {
            while(true) {
                //System.out.println("line");
                for(Rieka r : rieky) {
                    if (r.isAlive) {
                        System.out.print(r.koryto + ", ");
                    }
                }
                System.out.println();
                try {
                    sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Rieky r = new Rieky();
    }
}
