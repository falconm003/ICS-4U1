import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.GridLayout;

public class GUI implements ActionListener {
    JFrame frame;
    JFrame optionsFrame;
    JTextArea textArea;
    JTextPane textPane;
    JLabel errorLabel;
    JPanel statusPanel;
    static JLabel statusLabel;
    JLabel optionLabel1;
    JLabel optionLabel2;
    JLabel optionLabel3;
    JTextField arraySizeBox;
    JButton button;
    JScrollPane scroll;
    JComboBox<String> sortTypes;
    JComboBox<Integer> timeDelays;
    JPanel sortPanel;
    SimpleAttributeSet attributeSet;
    SimpleAttributeSet pivotSet;
    SimpleAttributeSet trackerSet;
    SimpleAttributeSet finishSet;
    Document doc;
    String[] str;
    String[] sortLib;
    Integer[] times;
    boolean hasSelected;
    public JLabel authorName; // Putting my name (basically showing off)
    public static int arrayComp; // tracking # of comparisons made
    public static int arraySwap; // tracking # of swaps made
    public static int timeDelay; // Used to set the time delay via the drop-down box in the settings window
    public GUI() throws BadLocationException {
        // code for frame below:
        frame = new JFrame("VisualSort Beta 1.0");
        textPane = new JTextPane();
        textPane.setBackground(Color.black);
        textPane.setEditable(false); // if this is editable the window will basically be a notepad. I noticed that trying to edit the window as the sort was happening would crash the program sometimes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840,420); // 420 is a funny number
        frame.setLocationRelativeTo(null);
        doc = textPane.getStyledDocument();
        
        
       
        scroll = new JScrollPane(textPane);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scroll, BorderLayout.CENTER); 
        
       
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


    public void optionBox() throws InterruptedException {
        optionsFrame = new JFrame();
        optionsFrame.setTitle("Settings");
        optionsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        optionsFrame.setSize(500, 500);
        optionsFrame.setLocationRelativeTo(null);
        sortPanel = new JPanel(new GridLayout(6, 1, 1, 1));
        sortPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        sortPanel.setLayout(new BoxLayout(sortPanel, BoxLayout.Y_AXIS));
        optionsFrame.add(sortPanel);
        sortPanel.setBackground(Color.black);
        optionLabel1 = new JLabel("Set algo type");
        optionLabel1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        optionLabel1.setForeground(Color.RED);
        optionLabel2 = new JLabel("Set time delay (ms)");
        optionLabel2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        optionLabel2.setForeground(Color.RED);
        optionLabel3 = new JLabel("array size (enter an integer)");
        optionLabel3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        optionLabel3.setForeground(Color.RED);
        sortLib = new String[]{"QuickSort", "InsertionSort"};
        times = new Integer[]{1, 5, 10, 25, 50, 100, 200, 500, 1000};
        sortTypes = new JComboBox<String>(sortLib);
        timeDelays = new JComboBox<Integer>(times);
        sortTypes.addActionListener(this);
        timeDelays.addActionListener(this);
        button = new JButton("Run");
        button.addActionListener(this);
        arraySizeBox = new JTextField(1);
        arraySizeBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        arraySizeBox.setForeground(Color.BLACK);
        arraySizeBox.addActionListener(this);
        errorLabel = new JLabel("Error - enter an integer");
        errorLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        errorLabel.setForeground(Color.RED);

        sortPanel.add(optionLabel1);
        sortPanel.add(sortTypes);
        sortPanel.add(optionLabel2);
        sortPanel.add(timeDelays);
        sortPanel.add(optionLabel3);
        sortPanel.add(arraySizeBox);
        sortPanel.add(button);

        refreshWindow();

        hasSelected = false;
        while(!hasSelected) {
            Thread.sleep(1); // if this sleep command doesn't exist, the run button in the settings window won't work for some reason
        }
        optionsFrame.dispose(); // get rid of the window once run is clicked since it's not needed after that point
    }
    private void refreshWindow() {
        optionsFrame.dispose();
        optionsFrame.pack();
        optionsFrame.setVisible(true);
    }


    public String[] update(int[] array) throws InterruptedException, BadLocationException {
        Thread.sleep(timeDelay);
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
    public void finish(int[] array) throws BadLocationException, InterruptedException {
        str = update(array);
        doc.remove(0, doc.getLength());
        for(int ctr = 0; ctr < str.length; ctr++) {
            Thread.sleep(timeDelay);
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
    public void pivotUpdate(int[] array, int pivot, int tracker) throws InterruptedException, BadLocationException {
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
    public void insertionUpdate(int[] array, int sorted, int toSort, int newPlacement) throws InterruptedException, BadLocationException {
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
    public void trackerUpdate(int[] array, int counter, int tracker, int pivot) throws InterruptedException, BadLocationException {
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


    @Override
    public void actionPerformed(ActionEvent f) {
        if (f.getSource() == sortTypes) {
            if (sortTypes.getSelectedItem().equals("QuickSort")) {
                Main.algoSelection = 0;
            } else if (sortTypes.getSelectedItem().equals("InsertionSort")) {
                Main.algoSelection = 1;
            }
        } else if (f.getSource() == timeDelays) {
            timeDelay = times[timeDelays.getSelectedIndex()];
        }

        if (f.getSource() == button) {
            try {
                Main.arraySize = Integer.parseInt(arraySizeBox.getText()); 
                hasSelected = true;
            } catch (NumberFormatException e) {
                sortPanel.add(errorLabel);
                refreshWindow();
            }
        }
        
    }
}