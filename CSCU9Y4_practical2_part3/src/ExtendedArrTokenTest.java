import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ExtendedArrTokenTest extends JFrame implements ActionListener {
    private JTextField txt1 = new JTextField(50);
    private JTextField expression = new JTextField(10);
    private JLabel labd = new JLabel("Regular Expression");
    private JButton reading = new JButton("Split");
    private JTextArea result = new JTextArea(20, 50);
    
   public static void main(String[] args) {
	   ExtendedArrTokenTest applic = new ExtendedArrTokenTest();
   } // main
    
   public ExtendedArrTokenTest() {        
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
       setSize(600,400);
       setVisible(true); 
   } // constructor
    
    public void actionPerformed(ActionEvent event) {    
        if (event.getSource() == reading) {
            String s = txt1.getText();
            String delims = expression.getText();            
            String[] anArray = s.split(delims);
            java.util.List<String> aList = mkList(anArray);
            s = removeEveryOtherToken(aList);
            result.setText("");
            printItList(aList, s);
        }           
    } // actionPerformed
    public String removeEveryOtherToken(java.util.List<String> sa)
    {
    	ListIterator<String> iter = sa.listIterator();
    	int i = 0;
        String temp = "*************************************************\n\nEvery other token removed: ";
        String temp_list = "";
        while (iter.hasNext())
        {
        	temp_list = iter.next();
        	i++;
        	if(i % 2 == 1)
        	{
        		temp += temp_list;
        	}
        }
        return temp;
    }

    public java.util.List<String> mkList(String[] sa) {
        LinkedList<String> st = new LinkedList<String>();
        for(int i = 0; i < sa.length && sa[i] != null; i++)
        {
        	st.add(sa[i]);
        }
        return st;
    } // mkList
    
     public void printItList(java.util.List<String> sa, String s) {
       ListIterator<String> iter = sa.listIterator();
       int tempSize = sa.size();
       result.append("*************************************************\nLength of list: " + Integer.toString(tempSize) + "\n\n*************************************************\nSeperated List:\n");   
       while (iter.hasNext())
       {
    	   String temp = iter.next();
    	   result.append(temp + "\n");
       }
       result.append("\n" + s);
      // Log the results to the terminal     
      System.out.println("Input: '" + txt1.getText() + "'");
      System.out.println("Regular Expression: '" + expression.getText() +"'");
      System.out.println("Output:" + result.getText());
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

