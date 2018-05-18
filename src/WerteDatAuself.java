public class WerteDatAuself {
    boolean wasihacked = false;
    int[] asort;
    int[] bsort;
    sortmaschine_exe sortdafoo;
    public WerteDatAuself(boolean hacktmode) {
        wasihacked = hacktmode;
    }

    public int richtige(int[] a, int[] b) {
        int y = 0;
        int puffi = 0;
        sortdafoo = new sortmaschine_exe();
        asort = sortdafoo.sortmyfoo(a);
        bsort = sortdafoo.sortmyfoo(b);
        for (int i = 0; i < asort.length; i++ ) {
            for (int j = 0; j < bsort.length; j++) {
                if (asort[i] == bsort[j]) {
                    puffi++;
                }
            }
        }
        if (wasihacked) {
            puffi = 10;
        }
        return puffi;
    }

}
