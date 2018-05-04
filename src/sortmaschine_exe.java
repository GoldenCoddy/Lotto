public class sortmaschine_exe {
    public sortmaschine_exe(){
        
    }
    public int[] sortmyfoo(int[] unsorted) {
        int zwsp = 0;
        boolean performed = true;
        while (performed) {
            performed = false;
            for (int y = 1; y < unsorted.length; y++) {
                if (unsorted[y] < unsorted[y - 1]) {
                    zwsp = unsorted[y];
                    unsorted[y] = unsorted[y - 1];
                    unsorted[y - 1] = zwsp;
                    performed = true;
                }
            }

        }
        return unsorted;
    }
}
