// GUI and main program for the Training Record

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener 
{
    private JTextField name = new JTextField(23);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    
    private JTextField recovery = new JTextField(2);
    private JTextField tempo = new JTextField(2);
    private JTextField howManyTimes = new JTextField(2);
    
    
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    
    private JCheckBox swimIsIndoor = new JCheckBox("Indoors: ");
    
    
    private JLabel sprintRec = new JLabel(" Recovery:");
    private JLabel sprintHMT = new JLabel(" How many times:");
    private JLabel cycleTempo = new JLabel(" Tempo:");
    private String terrains[] = {"rocky", "flat", "grassy", "uphill", "downhill"};
    private JComboBox<String> dropBoxTerrain = new JComboBox(terrains);
    
    private JButton addR = new JButton("Add");
    private JButton lookupR = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find by Date");
    private JButton removeEntry = new JButton("Remove");
    
    private String exercise[] = {"Running", "Sprinting", "Cycling", "Swimming"};
    private JComboBox<String> dropBox = new JComboBox(exercise);
            
    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5,50);
    
    private int previousIndex = 0;
    private int selectedIndex = 0;
    
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
        add(lookupR);
        lookupR.addActionListener(this);
        lookupR.setEnabled(false);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        findAllByDate.setEnabled(false);
        dropBox.setBounds(50,50,90,20);
        add(dropBox);
        dropBox.addActionListener(this);
        add(addR);
        addR.addActionListener(this);
        add(removeEntry);
        removeEntry.addActionListener(this);
        removeEntry.setEnabled(false);
        /*
        add(outputArea);
        outputArea.setEditable(false); 
        setSize(600,256);
        setVisible(true); 
        blankDisplay();  
        */     
        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        /*
        Entry a = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        Entry b = new Entry("Bob", 1, 2, 2003, 0, 14, 15, 3);
        Entry c1 = new Entry("Claire",7,3,2010, 0, 26, 20, 7);        
        Entry c2 = new Entry("Claire",11,3,2010, 0, 24, 55, 7);     
           
        myAthletes.addEntry(a);
        myAthletes.addEntry(b);
        myAthletes.addEntry(c1);        
        myAthletes.addEntry(c2);  
        */
        running();
   } // constructor
   public void textBox()
   {
       add(outputArea);
       outputArea.setEditable(false); 
       setSize(650,300);
       setVisible(true);     
   }
   public void removeTextBox()
   {
       remove(outputArea);   
   }
   public void basic()
   {
       setLayout(new FlowLayout()); 
       add(labdist);
       add(dist);
       dist.setEditable(true);
       add(labh);
       add(hours);
       hours.setEditable(true);
       add(labmm);
       add(mins);
       mins.setEditable(true);
       add(labs);
       add(secs);
       secs.setEditable(true);
   }
   public void running()
   {
       basic();
       dropBoxTerrain.setBounds(50,50,90,20);
       add(dropBoxTerrain);
       textBox();
   }
   public void swimming()
   {
       basic();
       add(swimIsIndoor);
       swimIsIndoor.setFocusable(true);
       textBox();
   }
   public void sprinting()
   {
       basic();
       add(sprintRec);
       add(recovery);
       recovery.setEditable(true);
       add(sprintHMT);
       add(howManyTimes);
       howManyTimes.setEditable(true); 
       textBox();
   }
   public void cycling()
   {
       basic();
       add(cycleTempo);
       add(tempo);
       tempo.setEditable(true);
       dropBoxTerrain.setBounds(50,50,90,20);
       add(dropBoxTerrain);
       textBox();
   }
   public void clearAll()
   {
       remove(labdist);
       remove(dist);
       remove(labh);
       remove(hours);
       remove(labmm);
       remove(mins);
       remove(labs);
       remove(secs);
       remove(sprintRec);
       remove(recovery);
       remove(sprintHMT);
       remove(howManyTimes);
       remove(cycleTempo);
       remove(tempo);
       remove(dropBoxTerrain);
       remove(swimIsIndoor);  
       outputArea.setText("");
       removeTextBox();
   }
   	public void setEnabled()
   	{
        lookupR.setEnabled(true);
        findAllByDate.setEnabled(true);
        removeEntry.setEnabled(true);
   	}
   	public void setDisbled()
   	{
        lookupR.setEnabled(false);
        findAllByDate.setEnabled(false);
        removeEntry.setEnabled(false);
   	}
  
   // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) 
    {    
        selectedIndex = dropBox.getSelectedIndex();
        if(previousIndex != selectedIndex)
        {   
            clearAll();
        }
        if(selectedIndex == 0)
        {
            running();
            previousIndex = 0;
        }
        else if(selectedIndex == 1)
        {
            sprinting();
            previousIndex = 1;
        }
        else if(selectedIndex == 2)
        {
            cycling();
            previousIndex = 2;
        }
        else if(selectedIndex == 3)
        {
            swimming();
            previousIndex = 3;
        }
        
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
                   
                   //Entry e = new Entry(n, d, m, y, h, mm, s, km);
                   Entry e = new Entry(n, d, m, y, h, mm, s, km);
                   
                   if(selectedIndex == 0)
                   {
                       String te = dropBoxTerrain.getItemAt(dropBoxTerrain.getSelectedIndex());
                       e = new Running(n, d, m, y, h, mm, s, km, te);
                   }
                   if(selectedIndex == 1)
                   {
                       int rec = Integer.parseInt(recovery.getText());
                       int hm = Integer.parseInt(howManyTimes.getText());
                       e = new Sprinting(n, d, m, y, h, mm, s, km, rec, hm);
                   }
                   if(selectedIndex == 2)
                   {
                       int t = Integer.parseInt(tempo.getText());
                       String te = dropBoxTerrain.getItemAt(dropBoxTerrain.getSelectedIndex());
                       e = new Cycling(n, d, m, y, h, mm, s, km, te, t);

                   }
                   if(selectedIndex == 3)
                   {
                       boolean i = swimIsIndoor.isSelected();
                       e = new Swimming(n, d, m, y, h, mm, s, km, i);
                   }
                   
                   
                   boolean hasEntry = myAthletes.addEntry(e);
                   setEnabled();
                   
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
         
         if(event.getSource() == removeEntry)
         {
            String n = name.getText();
            if(isInteger(month.getText()) && isInteger(day.getText()) && isInteger(year.getText()))
            {
                   int m = Integer.parseInt(month.getText()); 
                   int d = Integer.parseInt(day.getText()); 
                   int y = Integer.parseInt(year.getText());                   
                   outputArea.setText("looking up record ...");
                   String result = myAthletes.removeEntry(n, d, m, y);
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
   public void blankDisplay()
   {
       name.setText("");
       day.setText("");
       month.setText("");
       year.setText("");
       hours.setText("");
       mins.setText("");
       secs.setText("");
       dist.setText("");   
       tempo.setText("");;
       recovery.setText("");
    }// blankDisplay
    
} // TrainingRecordGUI

