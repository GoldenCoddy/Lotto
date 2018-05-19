import java.util.concurrent.ThreadLocalRandom;
public class otto {
    int[] wuerfelergebnisse;
    int tmax;
    int tmin;
    int tcount;
    sortmaschine_exe sortmatschine = new sortmaschine_exe();
    boolean sucessfull;
    boolean osucessfull;

    public otto(int count, int max, int min, boolean duplicates) {
        wuerfelergebnisse = new int[count];
        tmax = max;
        tmin = min;
        tcount = count;
        osucessfull = duplicates;
    }

    public int[] wuerfel() {
        for (int i = 0; i < tcount ; i++) {
            wuerfelergebnisse[i] = ThreadLocalRandom.current().nextInt(tmin, tmax);
        }
        sucessfull = osucessfull;
        while (!sucessfull) {
            wuerfelergebnisse = sortmatschine.sortmyfoo(wuerfelergebnisse);
            sucessfull = true;
            for (int i = 0; i < wuerfelergebnisse.length - 1; i++) {
                if (wuerfelergebnisse[i] == wuerfelergebnisse[i + 1]) {
                    sucessfull = false;
                    wuerfelergebnisse[i] = ThreadLocalRandom.current().nextInt(tmin, tmax);
                }
            }
        }
            return wuerfelergebnisse;
        }
    }
