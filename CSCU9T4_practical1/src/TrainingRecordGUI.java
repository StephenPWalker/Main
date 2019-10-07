// GUI and main program for the Training Record

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {
    private JTextField name = new JTextField(38);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    
    private JLabel labRun = new JLabel(" Run:");
    private JLabel labSprint = new JLabel(" Sprint:");
    private JLabel labCycle = new JLabel(" Cycle:");
    private JLabel labSwim = new JLabel(" Swim:");
    
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    
    private JButton addR = new JButton("Add");
    private JButton lookupR = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find by Date");
    
    private String exercise[] = {"Running", "Sprinting", "Cycling", "Swimming"};
    private JComboBox<String> dropBox = new JComboBox(exercise);
            
    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5,50);
    
   public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
   } // main
 
   // set up the GUI 
   public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout()); 

        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labdist);
        add(dist);
        dropBox.setBounds(50,50,90,20);
        add(dropBox);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        //********
        
        dist.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookupR);
        lookupR.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);

        add(outputArea);
        outputArea.setEditable(false); 
        setSize(500,256);
        setVisible(true); 
        blankDisplay();
        
        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        Entry a = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        Entry b = new Entry("Bob", 1, 2, 2003, 0, 14, 15, 3);
        Entry c1 = new Entry("Claire",7,3,2010, 0, 26, 20, 7);        
        Entry c2 = new Entry("Claire",11,3,2010, 0, 24, 55, 7);        
        myAthletes.addEntry(a);
        myAthletes.addEntry(b);
        myAthletes.addEntry(c1);        
        myAthletes.addEntry(c2);        
   } // constructor
   
  
   // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) 
    {    
        if (event.getSource() == addR) 
        {
           String n = name.getText();
           if(isInteger(month.getText()) && isInteger(day.getText()) && isInteger(year.getText()))
           {
               int m = Integer.parseInt(month.getText()); 
               int d = Integer.parseInt(day.getText()); 
               int y = Integer.parseInt(year.getText());
               float km = java.lang.Float.parseFloat(dist.getText());
               int h = Integer.parseInt(hours.getText());
               int mm = Integer.parseInt(mins.getText());
               int s = Integer.parseInt(secs.getText());
               Entry e = new Entry(n, d, m, y, h, mm, s, km);
               boolean hasEntry = myAthletes.addEntry(e);  
               if(hasEntry)
            	   outputArea.setText("Entry already exists.");
               else
            	   outputArea.setText("Entry added.");
           }
           else
           {
        	   outputArea.setText("Dates must be integers.");
           }
        }
        if (event.getSource() == lookupR) 
        {
        	if(isInteger(month.getText()) && isInteger(day.getText()) && isInteger(year.getText()))
        	{
	           int m = Integer.parseInt(month.getText()); 
	           int d = Integer.parseInt(day.getText()); 
	           int y = Integer.parseInt(year.getText()); 
	           outputArea.setText("looking up record ...");
	           String result = myAthletes.lookupEntry(d, m, y);
	           outputArea.setText(result);
        	}
        	else
        	{
        		outputArea.setText("Dates must be integers.");
        	}
        }
        if (event.getSource() == findAllByDate) 
        {
        	if(isInteger(month.getText()) && isInteger(day.getText()) && isInteger(year.getText()))
        	{
	            int m = Integer.parseInt(month.getText()); 
	            int d = Integer.parseInt(day.getText()); 
	            int y = Integer.parseInt(year.getText()); 
	            outputArea.setText("looking up record ...");
	            String result = myAthletes.findAllDates(d, m, y);
	            outputArea.setText(result);
        	}
        	else
        	{
        		outputArea.setText("Dates must be integers.");
        	}
         }
       blankDisplay();
    } // actionPerformed
    public static boolean isInteger(String s)
    {
        try 
        { 
            Integer.parseInt(s); 
        } 
        catch(NumberFormatException e) 
        { 
            return false; 
        }
        // if exception isn't thrown, then it is an integer
        return true;
    }
   public void blankDisplay(){
       name.setText("");
       day.setText("");
       month.setText("");
       year.setText("");
       hours.setText("");
       mins.setText("");
       secs.setText("");
       dist.setText("");   
       
    }// blankDisplay
    
} // TrainingRecordGUI

