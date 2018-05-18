import java.util.concurrent.ThreadLocalRandom;
public class otto {
    int[] wuerfelergebnisse;
    int tmax;
    int tmin;
    int tcount;

    public otto(int count, int max, int min) {
        wuerfelergebnisse = new int[count];
        tmax = max;
        tmin = min;
        tcount = count;
    }

    public int[] wuerfel() {
        for (int i = 0; i < tcount ; i++) {
            wuerfelergebnisse[i] = ThreadLocalRandom.current().nextInt(tmin, tmax);
        }//Math.random();
            // wuerfelergebnisse[i] = Math.round(Math.random());
            return wuerfelergebnisse;
        }
    }
