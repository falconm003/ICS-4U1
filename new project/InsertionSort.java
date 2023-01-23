import javax.swing.text.BadLocationException;
class InsertionSort {
    public void insertionSort(int numList[]) throws InterruptedException, BadLocationException {
        int hold;
        int ptr; 
        int temp = 0;
        for (int ctr = 1; ctr < numList.length; ctr++) {
            hold = numList[ctr];
            ptr = 0; 
            GUI.comp();
            while(hold > numList[ptr]) {
                GUI.comp();
                ptr++;
            }
            for (int count = ctr; count > ptr; count--) {
                numList[count] = numList[count-1];
                temp = (count-1);
            }
            numList[ptr] = hold;
            GUI.swap();
            GUI.insertionUpdate(numList, ctr-1, ctr, temp);
        } 
    }
}