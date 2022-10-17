import java.util.*;
class SortLib {
    public void makeData(int numList[]) {
        Random r = new Random(); 
        for (int ctr = 0; ctr < numList.length; ctr++) {
            numList[ctr] = r.nextInt(1000) + 1;
        }
    }
    //public int seqSearch(int numList[], int searchItem) {
    //
    //}
}