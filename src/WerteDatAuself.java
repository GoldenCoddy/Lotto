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
            //puffi = asort[i];
            for (int j = 0; j < bsort.length; j++) {
                if (asort[i] == bsort[j]) {
                    puffi++;
                    /*System.out.println("Matching:");
                    System.out.println(i);
                    System.out.println(j);
                    System.out.println(asort[i]);
                    System.out.println(bsort[j]);*/
                }
            }
        }
        return puffi;
    }

}
