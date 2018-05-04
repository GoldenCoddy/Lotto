import java.util.concurrent.ThreadLocalRandom;
public class otto {
    int[] wuerfelergebnisse;
    int tmax;
    int tcount;

    public otto(int count, int max) {
        wuerfelergebnisse = new int[count];
        tmax = max;
        tcount = count;
    }

    public int[] wuerfel() {
        for (int i = 0; i < tcount + 1; i++) {
            wuerfelergebnisse[i] = ThreadLocalRandom.current().nextInt(1, tmax);
        }//Math.random();
            // wuerfelergebnisse[i] = Math.round(Math.random());
            return wuerfelergebnisse;
        }
    }
