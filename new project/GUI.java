import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class GUI {
    static JFrame frame;
    static JTextArea textArea;
    static JTextPane textPane;
    static JPanel statusPanel;
    static JLabel statusLabel;
    static SimpleAttributeSet attributeSet;
    static SimpleAttributeSet pivotSet;
    static SimpleAttributeSet trackerSet;
    static SimpleAttributeSet finishSet;
    static Document doc;
    static String[] str;
    public static JLabel authorName; // Putting my name (basically showing off)
    public static int arrayComp; // tracking # of comparisons made
    public static int arraySwap; // tracking # of swaps made
    public GUI() throws BadLocationException {
        // code for frame below:
        frame = new JFrame("VisualSort Beta 1.0");
        textPane = new JTextPane();
        textPane.setBackground(Color.black);
        textPane.setEditable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840,420); // 420 is a funny number
        frame.setLocationRelativeTo(null);
        doc = textPane.getStyledDocument();
        frame.add(textPane, BorderLayout.CENTER); 
        // code for status panel below:
        authorName = new JLabel("ICS-4U1 - Matthew Falcone");
        statusLabel = new JLabel("status");
        authorName.setBorder(BorderFactory.createLineBorder(Color.black));
        statusPanel = new JPanel(new BorderLayout()); 
        statusPanel.setBackground(Color.black);
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 40));
        statusPanel.add(statusLabel, BorderLayout.WEST);
        statusPanel.add(authorName, BorderLayout.EAST);
        frame.add(statusPanel, BorderLayout.SOUTH);

        authorName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        authorName.setForeground(Color.RED);
        statusLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        statusLabel.setForeground(Color.RED);
        // making it all visible
        frame.setVisible(true); 
        frame.toFront();

        attributeSet = new SimpleAttributeSet();
        StyleConstants.setForeground(attributeSet, Color.lightGray);
        StyleConstants.setFontFamily(attributeSet, "Comic Sans MS");
        StyleConstants.setFontSize(attributeSet, 30);
        
        pivotSet = new SimpleAttributeSet();
        StyleConstants.setForeground(pivotSet, Color.red); // red color indicates the number is a pivot
        StyleConstants.setFontFamily(pivotSet, "Comic Sans MS");
        StyleConstants.setFontSize(pivotSet, 30);

        trackerSet = new SimpleAttributeSet();
        StyleConstants.setForeground(trackerSet, Color.blue); // blue color indicates the number is being swapped with pivot
        StyleConstants.setFontFamily(trackerSet, "Comic Sans MS");
        StyleConstants.setFontSize(trackerSet, 30);
        
        finishSet = new SimpleAttributeSet();
        StyleConstants.setForeground(finishSet, new Color(112, 162, 61)); // green color indicates the array has been sorted fully. 
        StyleConstants.setFontFamily(finishSet, "Comic Sans MS");
        StyleConstants.setFontSize(finishSet, 30);
    }
    public static String[] update(int[] array) throws InterruptedException, BadLocationException {
        Thread.sleep(Main.timeDelay);
        str = new String[array.length];
        for(int ctr = 0; ctr < array.length; ctr++) {
            str[ctr] = Integer.toString(array[ctr]);
        }
        return str;
    }
    public static void comp() {
        arrayComp++;
        statusLabel.setText("# of comparisons: " + Integer.toString(arrayComp) + "   # of swaps: " + Integer.toString(arraySwap));

    }
    public static void swap() {
        arraySwap++;
        statusLabel.setText("# of comparisons: " + Integer.toString(arrayComp) + "   # of swaps: " + Integer.toString(arraySwap));
    }
    public static void finish(int[] array) throws BadLocationException, InterruptedException {
        str = update(array);
        doc.remove(0, doc.getLength());
        for(int ctr = 0; ctr < str.length; ctr++) {
            Thread.sleep(10);
            doc.remove(0, doc.getLength());
            for(int ctr2 = 0; ctr2 < str.length; ctr2++) {
                if (ctr2 <= ctr) {
                    doc.insertString(doc.getLength(), str[ctr2].concat(" "), pivotSet);
                } else if (ctr2 > ctr) {                                                                // this block of code is just for the cool effect at the end of the sort
                    doc.insertString(doc.getLength(), str[ctr2].concat(" "), attributeSet);
                }
                
            }
        }
        doc.remove(0, doc.getLength());
        for(int ctr = 0; ctr < str.length; ctr++) {
            doc.insertString(doc.getLength(), str[ctr].concat(" "), finishSet);
        }
    }
    public static void pivotUpdate(int[] array, int pivot, int tracker) throws InterruptedException, BadLocationException {
        str = update(array);
        doc.remove(0, doc.getLength());
        for(int ctr = 0; ctr < str.length; ctr++) {
            if (ctr == pivot) {
                doc.insertString(doc.getLength(), str[pivot].concat(" "), pivotSet);
            } else if (ctr == tracker) {
                doc.insertString(doc.getLength(), str[tracker].concat(" "), trackerSet);
            } else if (ctr != pivot && ctr != tracker) {
                doc.insertString(doc.getLength(), str[ctr].concat(" "), attributeSet);
            }
        }
    }
    public static void insertionUpdate(int[] array, int sorted, int toSort, int newPlacement) throws InterruptedException, BadLocationException {
        str = update(array);
        doc.remove(0, doc.getLength());
        for(int ctr = 0; ctr < str.length; ctr++) {
            if(ctr <= sorted) {
                if (ctr == newPlacement) {
                    doc.insertString(doc.getLength(), str[ctr].concat(" "), finishSet);
                } else {
                    doc.insertString(doc.getLength(), str[ctr].concat(" "), pivotSet);
                }
            } else if (ctr == toSort){
                doc.insertString(doc.getLength(), str[ctr].concat(" "), trackerSet);
            } else {
                doc.insertString(doc.getLength(), str[ctr].concat(" "), attributeSet);
            }
        }
    }
    public static void trackerUpdate(int[] array, int counter, int tracker, int pivot) throws InterruptedException, BadLocationException {
        str = update(array);
        doc.remove(0, doc.getLength());
        for(int ctr = 0; ctr < str.length; ctr++) {
            if (ctr == counter) {
                doc.insertString(doc.getLength(), str[counter].concat(" "), trackerSet);
            } else if (ctr == tracker) {
                doc.insertString(doc.getLength(), str[tracker].concat(" "), trackerSet);
            } else if (ctr == pivot) {
                doc.insertString(doc.getLength(), str[pivot].concat(" "), pivotSet);
            } else if (ctr != tracker && ctr != counter) {
                doc.insertString(doc.getLength(), str[ctr].concat(" "), attributeSet);
            }
        }
    }
}
