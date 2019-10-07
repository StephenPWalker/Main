
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;

public class CastTest extends JFrame implements ActionListener {
    private JButton reading = new JButton("Do it");
    private JTextArea result = new JTextArea(20, 50);
    private boolean ok = false;
    
   public static void main(String[] args) 
   {
        CastTest applic = new CastTest();
   } // main
    
   public CastTest() 
   {        
      super("Playing with Lists and Casts");     
      setLayout(new FlowLayout()); 
      add(reading);
      reading.addActionListener(this);
      add(result);
      setSize(600,500);
      setVisible(true);        
   } // constructor
    
    public void actionPerformed(ActionEvent event) {    
        if (event.getSource() == reading) {
            LinkedList a = new LinkedList();
            a.add("Bill");
            a.add("Ben");
            String s = (String)a.get(1);            
            a.add(42);
            Integer i = (Integer) a.get(2);
            a.set(2, (Integer) a.get(2)+1);
            result.append("First element " + (String) a.get(0) + "\n");
            result.append("Second element " + (String) a.get(1) + "\n");
            result.append("Third element " + (Integer) a.get(2) + "\n");
            a.set(2,"George");
            //Integer j = (Integer) a.get(0);
            String t = (String) a.get(2);

        }           
    } // actionPerformed
    
} // CastTest

