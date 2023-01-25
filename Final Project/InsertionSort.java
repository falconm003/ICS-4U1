import javax.swing.text.BadLocationException;
class InsertionSort {
    GUI myObj;
    public InsertionSort(GUI temp) {
        myObj = temp;
    }
    public void insertionSort(int numList[]) throws InterruptedException, BadLocationException { // bog-standard insertionsort
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
                GUI.swap();
                myObj.insertionUpdate(numList, ctr-1, ctr, temp);
            }
            numList[ptr] = hold;
            myObj.insertionUpdate(numList, ctr-1, ctr, temp);
        } 
    }
}