import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ArrTokenTest extends JFrame implements ActionListener {
    private JTextField txt1 = new JTextField(50);
    private JTextField expression = new JTextField(10);
    private JLabel labd = new JLabel("Regular Expression");
    private JButton reading = new JButton("Split");
    private JTextArea result = new JTextArea(20, 50);
    
   public static void main(String[] args) {
       ArrTokenTest applic = new ArrTokenTest();
   } // main
    
   public ArrTokenTest() {        
       super("Tokens");     
       setLayout(new FlowLayout()); 
       add(txt1);
       txt1.setEditable(true);
       add(labd);
       add(expression);
       expression.setEditable(true);
       add(reading);
       reading.addActionListener(this);
       add(result); 
       setSize(600,500);
       setVisible(true); 
   } // constructor
    
    public void actionPerformed(ActionEvent event) {    
        if (event.getSource() == reading) {
            String s = txt1.getText();
            String delims = expression.getText(); 
            String[] anArray = s.split(delims);
            java.util.List<String> aList = mkList(anArray);
            result.setText("");
            print(anArray);
            printItList(aList);
        }           
    } // actionPerformed

    public java.util.List<String> mkList(String[] sa) {
        LinkedList<String> st = new LinkedList<String>();
        for(int i = 0; i < sa.length && sa[i] != null; i++)
        {
        	st.add(sa[i]);
        }
        return st;
    } // mkList
    
     public void printItList(java.util.List<String> sa) {
       ListIterator<String> iter = sa.listIterator();
       while (iter.hasNext())
       {
         String temp = iter.next();
         result.append(temp + "\n");
       }

      // Log the results to the terminal
      System.out.println("Input: '" + txt1.getText() + "'");
      System.out.println("Regular Expression: '" + expression.getText() +"'");
      System.out.println("Output:\n" + result.getText());

     } // printItList


    public void print(String[] sa) {
      
      for (int i = 0; i < sa.length && sa[i] != null; i++)
        result.append(sa[i] + "\n");
        
      // Log the results to the terminal
      System.out.println("Input: '" + txt1.getText() + "'");
      System.out.println("Regular Expression: '" + expression.getText() +"'");
      System.out.println("Output:\n" + result.getText());
    } // print
  
} // TokenTest

