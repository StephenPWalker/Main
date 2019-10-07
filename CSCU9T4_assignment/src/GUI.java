// GUI code created and submitted by spw00004

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class GUI extends JFrame implements ActionListener 
{
	private JTextField importText = new JTextField(20);
	private JTextField name = new JTextField(40);
	private JTextField name2 = new JTextField(40);
	private JTextField number = new JTextField(3);
	private JTextField number2 = new JTextField(3);
	private JTextField id = new JTextField(3);
	private JTextField id2 = new JTextField(3);
	private JTextField day = new JTextField(10);
	private JTextField day2 = new JTextField(10);
	private JTextField weekPattern = new JTextField(12);
	private JTextField weekPattern2 = new JTextField(12);
	private JTextField location = new JTextField(10);
	private JTextField roomSize = new JTextField(4);
	private JTextField classSize = new JTextField(4);
	private JTextField staff = new JTextField(40);
	private JTextField department = new JTextField(20);
	
	private JLabel labImportText = new JLabel(" Text File Name:");
    private JLabel labName = new JLabel(" Name:");
    private JLabel labName2 = new JLabel(" Name:");
    private JLabel labNumber = new JLabel(" No#:");
    private JLabel labNumber2 = new JLabel(" No#:");
    private JLabel labId = new JLabel(" ID:");
    private JLabel labId2 = new JLabel(" ID:");
    private JLabel labDay = new JLabel(" Day:");
    private JLabel labStartTime = new JLabel(" Start Time:");
    private JLabel labEndTime = new JLabel(" End Time:");
    private JLabel labWeekPattern = new JLabel(" Week Pattern:");
    private JLabel labLocation = new JLabel(" Location:"); 
    private JLabel labDay2 = new JLabel(" Day:");
    private JLabel labStartTime2 = new JLabel(" Start Time:");
    private JLabel labEndTime2 = new JLabel(" End Time:");
    private JLabel labWeekPattern2 = new JLabel(" Week Pattern:");
    private JLabel labRoomSize = new JLabel(" Room Size:"); 
    private JLabel labClassSize = new JLabel(" Class Size:"); 
    private JLabel labStaff = new JLabel(" Staff:"); 
    private JLabel labDepartment = new JLabel(" Department:"); 
    private JLabel labLimit = new JLabel(" HTML export limit:");
    
    private JButton importF = new JButton("Import");
    private JButton searchPartial = new JButton("Partial Search by Name");
    private JButton searchPartial2 = new JButton("Partial Search by Name");
    private JButton searchByName = new JButton("Exact Search by Name");
    private JButton searchExact = new JButton("Exact Search");
    private JButton searchExact2 = new JButton("Exact Search");
    private JButton add = new JButton("Add");
    private JButton remove = new JButton("Remove");
    private JButton removeAll = new JButton("Remove all");
    private JButton exportF = new JButton("Export file");
    private JButton exportHTML = new JButton("Export html");
    private JButton clear = new JButton("Clear");
    private JButton clear2 = new JButton("Clear");
    
    private String classType[] = {"Computer Lab", "Lectures", "Seminar"};
    private JComboBox<String> dropBox = new JComboBox<String>(classType);
    private String classType2[] = {"Computer Lab", "Lectures", "Seminar"};
    private JComboBox<String> dropBox2 = new JComboBox<String>(classType2);
    
    JSpinner startHours = new JSpinner(new SpinnerNumberModel(1, 0, 23, 1));
    JSpinner startMins = new JSpinner(new SpinnerNumberModel(1, 0, 59, 1));
    JSpinner endHours = new JSpinner(new SpinnerNumberModel(1, 0, 23, 1));
    JSpinner endMins = new JSpinner(new SpinnerNumberModel(1, 0, 59, 1));
    JSpinner startHours2 = new JSpinner(new SpinnerNumberModel(1, 0, 23, 1));
    JSpinner startMins2 = new JSpinner(new SpinnerNumberModel(1, 0, 59, 1));
    JSpinner endHours2 = new JSpinner(new SpinnerNumberModel(1, 0, 23, 1));
    JSpinner endMins2 = new JSpinner(new SpinnerNumberModel(1, 0, 59, 1));
    JSpinner recordsLimit = new JSpinner(new SpinnerNumberModel(20, 0, 100, 1));
    
    private JTextArea outputArea = new JTextArea(22,100);
    private JTextArea outputArea2 = new JTextArea(20,100);
    private JTextArea outputArea3 = new JTextArea(17,100);  
    private JScrollPane scroller = new JScrollPane();
    private JScrollPane scroller2 = new JScrollPane();
    private JScrollPane scroller3 = new JScrollPane();
    private Record myRecords = new Record();
    
    private String importedFileName = ""; 
	
	public static void main(String[] args) 
	{
		GUI application = new GUI(); //create new instance of application
		try
		{
			application.getImport(args[0]); //with complex.txt set up in run config this should automatically import when loaded
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			application.getImport("Complex.txt");
		}
	} // main

	public GUI()
	{
		setTitle("University timetable program");
		JTabbedPane tabbedPane = new JTabbedPane();

		JComponent panel1 = makeTextPanel("Import (.txt will be added to filename automatically)");
		tabbedPane.addTab("Import", null, panel1,
		                  "Allows import of text files");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		panel1.add(labImportText);
		panel1.add(importText);
		importText.setEditable(true);
		panel1.add(importF);
		importF.addActionListener(this);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		outputArea.setBorder(new LineBorder(Color.BLACK));
		scroller.getViewport().setBackground(Color.WHITE);
		scroller.getViewport().add(outputArea);
		panel1.add(scroller);
		outputArea.setEditable(false); //set the GUI for import settings
		
		JComponent panel2 = makeTextPanel("");
		tabbedPane.addTab("Search/Export", null, panel2,
		                  "Search and export");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		dropBox.setBounds(50,50,90,20);
        panel2.add(dropBox);
        dropBox.addActionListener(this);
		panel2.add(labName);
		panel2.add(name);
        name.setEditable(true);
        panel2.add(labId);
		panel2.add(id);
        id.setEditable(true);
        panel2.add(labNumber);
		panel2.add(number);
		number.setEditable(true);
        panel2.add(labDay);
        panel2.add(day);
        day.setEditable(true);
        panel2.add(Box.createRigidArea(new Dimension(240,0)));
        panel2.add(labStartTime);
        panel2.add(startHours);
        panel2.add(startMins);
        panel2.add(labEndTime);
        panel2.add(endHours);
        panel2.add(endMins);
        panel2.add(labWeekPattern);
        panel2.add(weekPattern);
        weekPattern.setEditable(true);
        panel2.add(labLimit);
        panel2.add(recordsLimit);
        panel2.add(Box.createRigidArea(new Dimension(300,0)));
        panel2.add(searchByName);
        searchByName.addActionListener(this);
        panel2.add(searchPartial);
        searchPartial.addActionListener(this);
        panel2.add(searchExact);
        searchExact.addActionListener(this);
        panel2.add(exportF);
        exportF.addActionListener(this);
        panel2.add(exportHTML);
        exportHTML.addActionListener(this);
        panel2.add(clear);
        clear.addActionListener(this);
		scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		outputArea2.setBorder(new LineBorder(Color.BLACK));
		scroller2.getViewport().setBackground(Color.WHITE);
		scroller2.getViewport().add(outputArea2);
		panel2.add(scroller2);
		outputArea2.setEditable(false); // set the GUI for searching and exporting features

	
		JComponent panel3 = makeTextPanel("");
		tabbedPane.addTab("Add/Remove", null, panel3,
		                  "Adds and romoves searched for records");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		add(tabbedPane);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        setSize(1200,500);
        setLocation(400,200);
        setVisible(true);  
        panel3.add(dropBox2);
        dropBox2.addActionListener(this);
		panel3.add(labName2);
		panel3.add(name2);
        name2.setEditable(true);
        panel3.add(labId2);
		panel3.add(id2);
        id2.setEditable(true);
        panel3.add(labNumber2);
		panel3.add(number2);
		number2.setEditable(true);
        panel3.add(labDay2);
        panel3.add(day2);
        day2.setEditable(true);
        panel3.add(Box.createRigidArea(new Dimension(220,0)));
        panel3.add(labStartTime2);
        panel3.add(startHours2);
        panel3.add(startMins2);
        panel3.add(labEndTime2);
        panel3.add(endHours2);
        panel3.add(endMins2);
        panel3.add(labWeekPattern2);
        panel3.add(weekPattern2);
        weekPattern2.setEditable(true);
        panel3.add(labLocation);
        panel3.add(location);
        location.setEditable(true);
        panel3.add(labRoomSize);
        panel3.add(roomSize);
        roomSize.setEditable(true);
        panel3.add(labClassSize);
        panel3.add(classSize);
        classSize.setEditable(true);
        panel3.add(Box.createRigidArea(new Dimension(200,0)));
        panel3.add(labStaff);
        panel3.add(staff);
        staff.setEditable(true);
        panel3.add(labDepartment);
        panel3.add(department);
        department.setEditable(true);   
        panel3.add(Box.createRigidArea(new Dimension(200,0)));
        panel3.add(add);
        add.addActionListener(this);
        panel3.add(remove);
        remove.addActionListener(this);
        panel3.add(removeAll);
        removeAll.addActionListener(this);
        panel3.add(searchPartial2);
        searchPartial2.addActionListener(this);
        panel3.add(searchExact2);
        searchExact2.addActionListener(this);
        panel3.add(clear2);
        clear2.addActionListener(this);
		scroller3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		outputArea3.setBorder(new LineBorder(Color.BLACK));
		scroller3.getViewport().setBackground(Color.WHITE);
		scroller3.getViewport().add(outputArea3);
		panel3.add(scroller3);
		outputArea3.setEditable(false); // set the GUI for search add remove append features
	}
	
	protected JComponent makeTextPanel(String text) 
	{
	    JPanel panel = new JPanel(false);
	    JLabel filler = new JLabel(text);
	    filler.setHorizontalAlignment(JLabel.CENTER);
	    panel.add(filler);
	    return panel; //create a set panel type for use in GUI
	}

    public void actionPerformed(ActionEvent event) 
    {   
    	int selectedIndex = dropBox.getSelectedIndex(); //checks drop box for which type of class
    	int selectedIndex2 = dropBox2.getSelectedIndex(); //checks drop box for which type of class
    	if(event.getSource() == importF)
    	{
    		if(!importText.getText().toLowerCase().equals("export"))
    			getImport(importText.getText() + ".txt"); //add .txt to filename this should not be needed as complex.txt is set up in run config
    		else
    			outputArea.setText("Cannot import an already formatted and exported file!");
    	}
    	if(event.getSource() == add)
    	{
    		getInput(false);//call get input and add
    	}
    	if(event.getSource() == remove)
    	{
    		getInput(true);//call get input and remove
    	}
    	if(event.getSource() == removeAll)
    	{
    		myRecords.removeAll();
    		outputArea3.setText("All entries have been removed\n");
    	}
    	if(event.getSource() == clear || event.getSource() == clear2)
    	{
    		if(event.getSource() == clear)
    			outputArea2.setText("");//clear display
    		if(event.getSource() == clear2)
    			outputArea3.setText("");//clear display
    		clearAll();
    	}
    	if(event.getSource() == searchByName)
    	{
    		String classType = dropBox.getItemAt(selectedIndex); //check class type
    		classType = classType.substring(0, 1);
    		String n = name.getText();
    		String no = number.getText();
    		String i = id.getText();
            outputArea2.setText(myRecords.findByName(n, classType, no, i)); //search for it using exact class name
    	}
    	if(event.getSource() == searchPartial)
    	{
    		String classType = dropBox.getItemAt(selectedIndex); //check class type
    		classType = classType.substring(0, 1);
    		String n = name.getText();
    		outputArea2.setText(myRecords.findPartial(n, classType)); //search for it using exact class name
    	}
    	if(event.getSource() == searchPartial2)
    	{
    		String classType = dropBox2.getItemAt(selectedIndex2); //check class type
    		classType = classType.substring(0, 1);
    		String n = name2.getText();
    		outputArea3.setText(myRecords.findPartial(n, classType)); //search for it using exact class name
    	}
    	if(event.getSource() == searchExact)
    	{
    		String classType = dropBox.getItemAt(selectedIndex); //check class type
    		classType = classType.substring(0, 1);
    		String n = name.getText();
    		String d = day.getText();
    		String i = id.getText();
    		String no = number.getText();
    		String sth = "";
    		String stm = "";
    		String eth = "";
    		String etm = "";
    		if((int)startHours.getValue() < 10)
    			sth = "0" + (startHours.getValue().toString());
    		else
    			sth = startHours.getValue().toString();
    		if((int)startMins.getValue() < 10)
    			stm = "0" + (startMins.getValue().toString());
    		else
    			stm = startMins.getValue().toString();
    		if((int)endHours.getValue() < 10)
    			eth = "0" + (endHours.getValue().toString());
    		else
    			eth = endHours.getValue().toString();
    		if((int)endMins.getValue() < 10)
    			etm = "0" + (endMins.getValue().toString());
    		else
    			etm = endMins.getValue().toString();
    		
    		String st = sth + ":" + stm;
    		String et = eth + ":" + etm;
    		String wp = weekPattern.getText();
    		outputArea2.setText(myRecords.findExact(n, classType, d, st, et, wp, no, i)); //search for it using exact class name
    	}
    	if(event.getSource() == searchExact2) //make an exact check of information entered
    	{
    		String classType = dropBox2.getItemAt(selectedIndex2); //check class type
    		classType = classType.substring(0, 1);
    		String n = name2.getText();
    		String d = day2.getText();
    		String i = id2.getText();
    		String no = number2.getText();
    		String sth = "";
    		String stm = "";
    		String eth = "";
    		String etm = "";
    		if((int)startHours2.getValue() < 10)
    			sth = "0" + (startHours2.getValue().toString());
    		else
    			sth = startHours2.getValue().toString();
    		if((int)startMins2.getValue() < 10)
    			stm = "0" + (startMins2.getValue().toString());
    		else
    			stm = startMins2.getValue().toString();
    		if((int)endHours2.getValue() < 10)
    			eth = "0" + (endHours2.getValue().toString());
    		else
    			eth = endHours2.getValue().toString();
    		if((int)endMins2.getValue() < 10)
    			etm = "0" + (endMins2.getValue().toString());
    		else
    			etm = endMins2.getValue().toString();
    		
    		String st = sth + ":" + stm;
    		String et = eth + ":" + etm;
    		String wp = weekPattern2.getText();
    		outputArea3.setText(myRecords.findExact(n, classType, d, st, et, wp, no, i)); //search for it using exact class name
    	}
    	if(event.getSource() == exportF)
    	{
    		exportFile();
    	}
    	if(event.getSource() == exportHTML)
    	{
    		exportFileHTML();
    	}
	}
    public void clearAll()
    {
    	name.setText("");
    	name2.setText("");
    	day.setText("");
    	day2.setText("");
    	number.setText("");
    	id.setText("");
    	number2.setText("");
    	id2.setText("");
    	weekPattern.setText("");
    	weekPattern2.setText("");
    	location.setText("");
    	roomSize.setText("");
    	classSize.setText("");
    	staff.setText("");
    	department.setText("");
    	//clear all data
    }
    public void getImport(String fileName)
    {
		FileIO fio = null;
		boolean isImported = false;
		if(importedFileName.equals(fileName.toLowerCase()))
		{
			isImported = true; //checks if the filename has already been imported
		}
		if(!isImported) //if it hasn't add the file name and import files using fileIO
		{
			myRecords.removeAll();
			importedFileName = fileName.toLowerCase();
    		try 
    		{
    			fio = new FileIO(fileName);
    			outputArea.append(fio.format());	    		
			} 
    		catch (FileNotFoundException e) 
    		{
    			outputArea.append("Output file not found exception\n");
				e.printStackTrace();
			}
    		if(fio.isConverted())
    		{
    			importOutput();
    		}
		}  
		else
		{
			outputArea.append("Files already imported!\n");
		}
    }
    public void getInput(boolean isRemove)
    {
    	int selectedIndex = dropBox.getSelectedIndex(); //checks drop box for which type of class
    	String wc = dropBox.getItemAt(selectedIndex);
		
		String n = name2.getText();
		String d = day2.getText();
		String sth = "";
		String stm = "";
		String eth = "";
		String etm = "";
		if((int)startHours2.getValue() < 10)
			sth = "0" + (startHours2.getValue().toString()); //set string to include the 0 for correct formatting
		else
			sth = startHours2.getValue().toString();
		if((int)startMins2.getValue() < 10)
			stm = "0" + (startMins2.getValue().toString()); //set string to include the 0 for correct formatting
		else
			stm = startMins2.getValue().toString();
		if((int)endHours2.getValue() < 10)
			eth = "0" + (endHours2.getValue().toString()); //set string to include the 0 for correct formatting
		else
			eth = endHours2.getValue().toString();
		if((int)endMins2.getValue() < 10)
			etm = "0" + (endMins2.getValue().toString()); //set string to include the 0 for correct formatting
		else
			etm = endMins2.getValue().toString();
		String st = sth + ":" + stm; 
		String et = eth + ":" + etm;
		String wp = weekPattern2.getText();
		String l = location.getText();
		if(l.isEmpty())
			l = "unconfirmed";
		String s = staff.getText();
		if(s.isEmpty())
			s = "unconfirmed";
		String dep = department.getText();
		if(dep.isEmpty())
			dep = "unconfirmed";
		int rsI = 0, csI = 0;
		String no = number2.getText();
		String i = id2.getText();

		 try 
		 {
             rsI = Integer.parseInt(roomSize.getText());
         } 
		 catch (NumberFormatException e) 
		 {
             outputArea3.append("You've entered a non-integer in room size, room size set to 0\n"); //only allow numbers in room size
         }		
		 try 
		 {
             csI = Integer.parseInt(classSize.getText());
         } 
		 catch (NumberFormatException e) 
		 {
			 outputArea3.append("You've entered a non-integer in class size, class size set to 0\n"); //only allow numbers in class size
         }

		Lecture e = new Lecture(wc, n, d, st, et, wp, l, rsI, csI, s, dep, no, i); //default is to add a lecture, the rest check index for type of class
		 if(selectedIndex == 0)
         {
             e = new ComputerLab(wc, n, d, st, et, wp, l, rsI, csI, s, dep, no, i);
         }
         if(selectedIndex == 2)
         {
             e = new Seminar(wc, n, d, st, et, wp, l, rsI, csI, s, dep, no, i);
         }
         
         if(!isRemove) //if isn't remove then it is add, this adds the entry if there is no duplicate
         {
	        if(!n.isEmpty() && !d.isEmpty() && !st.isEmpty() && !et.isEmpty() && !wp.isEmpty())
	        {
	 			boolean hasEntry = myRecords.addEntry(e); //check if the entry is a duplicate
		    		if(hasEntry)
		                outputArea3.append("Entry already exists.\n");
		            else
		            {
		                outputArea3.append("Entry added.\n");
		                outputArea3.append(myRecords.getCount() + " records in total.\n");
		            }
	        }
	 		else
	 		{
	 			outputArea3.setText("Please enter information into name / number(if has one) / ID(if has one) / day / starttime / endtime and week pattern\n");
	 		}
         }
         else if(isRemove) //if is remove then this gets an removes the entry
         {
        	 if(!n.isEmpty() && !d.isEmpty() && !st.isEmpty() && !et.isEmpty() && !wp.isEmpty())
        	 {
        		 boolean hasEntry = myRecords.removeEntry(e); //check if the entry is a duplicate
        		 	if(hasEntry)
        		 	{
			             outputArea3.append("Entry removed\n");
			             outputArea3.append(myRecords.getCount() + " records in total.\n");
        		 	}
			         else
			             outputArea3.append("Entry doesn't exist\n");
        	 }
        	 else
        		 outputArea3.setText("Please enter information into name / number(if has one) / ID(if has one) / day / starttime / endtime and week pattern\n");
         }      
    }
    public void importOutput()
    {
    	int count = 0;
    	myRecords.setCount();
    	String line;
		 try{
	            FileReader fileReader = new FileReader("output.txt");
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            outputArea.append("File restructured\n");
	            while ((line = bufferedReader.readLine()) != null)
	            {
	            	//0--name  1-day 2-startTime 3-endTime 4-weekPattern 5-location 6-roomSize 7-classSize 8-staff 9-department     		            	
	            	//parsing	        
	            	String[] splitStr = line.split("\t"); // split into individual strings
	            	String theClass = splitStr[0]; // take the original name,class type and no.
	            	String ss = theClass.substring(theClass.indexOf(".") + 1); //create type and no
	            	int max = theClass.length() - ss.length();  //check value of name - type an no.
	            	String s2 = theClass.substring(0, max); //set string containing just name
	            	s2 = s2.replaceAll("[-+.^:,]",""); //replace all chars in it
	            	String ssNo = ""; // set default string for no to blank
	            	String ssId = "";
	            	//standardise
	            	ss = ss.toUpperCase();
	            	//replace chars
	            	ss = ss.replace("#", "");
					ss = ss.replace("\\*", "");
					//These date prefixes are obsolete
					ss = ss.replace("/M", "");//replace Monday prefix
					ss = ss.replace("/TU", "");//replace Tuesday prefix
					ss = ss.replace("/W", "");//replace Wednesday prefix
					ss = ss.replace("/TH", "");//replace Thursday prefix
					ss = ss.replace("/T", "");//replace T prefix					
					if(ss.contains("/") && !ss.contains("("))
	            		ssNo = ss.substring(ss.indexOf("/") + 1); //  for 1,2,3,4 seminars						
					else if(ss.contains("("))
					{
						ssNo = ss.substring(ss.indexOf("(")); // for a,b,c,d bad input replace
						ss = ss.replace(ssNo, ""); //remove it from ss
						ssNo = ssNo.replace("(", "");
						ssNo = ssNo.replace(")", "");
						if(ssNo.length() > 1)
							ssNo = "";
					}
					String[] locFix = splitStr[5].split("\\*"); //bad input with unknown reason, replace 
					String[] romFix = splitStr[6].split("\\*"); //bad input with unknown reason, replace 
					splitStr[5] = locFix[0];
					splitStr[6] = romFix[0];
					//if a unique id is used strip it clean 
					ssId = ss.replace(ssNo, "");
					ssId = ssId.replace("/", ""); //replace slashes
					ssId = ssId.replace("S", ""); //replace class types
					ssId = ssId.replace("C", "");
					ssId = ssId.replace("L", "");
					ssId = ssId.replace("P", "");
					ssId = ssId.replace(" ", ""); //replace spaces
	            	String[] theClasses = s2.split("/");
					int repitions = 1; //set reps for for loop
					if(theClasses.length > 1) //increase if have different rooms for same seminars
						repitions = theClasses.length; //if multiple classes in same line										
										
	            	String[] newSplit = new String[13]; //create new array for strings
	            	//0-whichClass 1-name  2-day 3-startTime 4-endTime 5-weekPattern 6-location 7-roomSize 8-classSize 9-staff 10-department 11-whichNo 12-id
	            	for(int i = 0; i < 12; i ++)
	            	{
	            		if(i == 0)
	            		{
	            			newSplit[0] = ss; //class type
	            			newSplit[1] = s2; //Name
	            		}
	            		else if(i < 10)
	            			newSplit[i+1] = splitStr[i]; //set all other values
	            		else if(i == 10)
	            			newSplit[i + 1] = ssNo; //class number if has value or "" by default
	            		else if(i == 11)
	            			newSplit[i+1] = ssId; //class id if has value or "" by default
	            	}
	            	for(int i = 0; i < newSplit.length - 2; i++)
	            		if(newSplit[i].isEmpty())
	            			newSplit[i] = "unconfirmed"; //if any value other than the no. and id is blank set it to unconfirmed
	            	
	            	if(!newSplit[11].isEmpty())
	            		newSplit[11] = newSplit[11]; //if there is no number or letter, set blank else set space then no.
	            	
	            	String whichType = newSplit[0].substring(0, 1);	 // get the code for type of class
											            	
	            	//0-whichClass 1-name  2-day 3-startTime 4-endTime 5-weekPattern 6-location 7-roomSize 8-classSize 9-staff 10-department 11-whichNo	 12-id
	            			            				
	            	if(count >= 1)
	            	{
		            	for(int i = 0; i < repitions; i ++)
		            	{
		            		if(repitions > 1)
		            		{
		            			newSplit[1] = theClasses[i];
		            		}
		            		
			            	Lecture e = new Lecture(newSplit[0], newSplit[1], newSplit[2], newSplit[3], newSplit[4], newSplit[5], newSplit[6],
			            			Integer.parseInt(newSplit[7]), Integer.parseInt(newSplit[8]), newSplit[9], newSplit[10], newSplit[11], newSplit[12]);
			        		//set the four variations
			        		 if(whichType.equals("C"))
			                     e = new ComputerLab(newSplit[0], newSplit[1], newSplit[2], newSplit[3], newSplit[4], newSplit[5], newSplit[6],
			                    		 Integer.parseInt(newSplit[7]), Integer.parseInt(newSplit[8]), newSplit[9], newSplit[10],newSplit[11], newSplit[12]);
			                 if(whichType.equals("S"))
			                     e = new Seminar(newSplit[0], newSplit[1], newSplit[2], newSplit[3], newSplit[4], newSplit[5], newSplit[6],
			                    		 Integer.parseInt(newSplit[7]), Integer.parseInt(newSplit[8]), newSplit[9], newSplit[10],newSplit[11], newSplit[12]);      	
			                 myRecords.addEntry(e); //add the record of the given type
		            	}
	            	}
	            	else
	            	{
	            		count++;
	            	}
	            }
	            bufferedReader.close(); //close buffered reader
	            outputArea.append("Records appended\n");
	            outputArea.append("File recombined\n");
	            outputArea.append(myRecords.getCount() + " records imported successfully\n"); //show amount of unique records added
	        }
	        catch(IOException ex)
	        {
	            outputArea.append("Error reading file output.txt\n");
	        }
    }
    public void exportFile()
    {
    	if(!outputArea2.getText().isEmpty() && (outputArea2.getText().substring(0, 1).equals("c") || outputArea2.getText().substring(0, 1).equals("L")
    			|| outputArea2.getText().substring(0, 1).equals("s"))) //checks that the entries are valid and not other output text
    	{
	    	try 
	    	{
				FileWriter fw = new FileWriter("export.txt");
				outputArea2.write(fw);
				outputArea2.setText("Information exported to file named export.txt");//confirm export
			} 
	    	catch (IOException e) 
	    	{
				outputArea2.setText("Error exporting file");//catch io exception error
			}
    	}
    	else
    		outputArea2.setText("No information to export!");//nothing to export
    }
    public void exportFileHTML()
    {
    	if(!outputArea2.getText().isEmpty() && (outputArea2.getText().substring(0, 1).equals("c") || outputArea2.getText().substring(0, 1).equals("L")
    			|| outputArea2.getText().substring(0, 1).equals("s"))) //checks that the entries are valid and not other output text
    	{
	    	int limit = (int) recordsLimit.getValue();
	    	int counter = 0;
	    	StringBuilder sb = new StringBuilder();
	    	String text[] = outputArea2.getText().split("\n"); // get input via the text area and split it for new lines
		    sb.append("<html>");
		    sb.append("<head>");
		    sb.append("<title>Your class records");
		    sb.append("</title>");
		    sb.append("</head>");
		    sb.append("<body><b>"); //html code
		    sb.append("Below is the list of classes:"); //html code
		    sb.append("</br>"); //html code
		    for(int i = 1; i < text.length && i <= limit; i++) //for each line add a break and a record
		    {
		    	sb.append("</br>" + text[i]);
		    	counter = i; // count the records
		    }
		    sb.append("</b></body>");
		    sb.append("</html>");
		    FileWriter fstream;
			try 
			{
				fstream = new FileWriter("export.html");
				BufferedWriter out = new BufferedWriter(fstream);
			    out.write(sb.toString());
			    out.close();
			} 
			catch (IOException e) 
			{
				outputArea2.setText("Error exporting file");//catch io exception error
			}	
			if(counter < limit)
				outputArea2.setText("Information exported as export.html " + counter + " records listed.");//how many records
			else
				outputArea2.setText("Information exported as export.html " + counter + " records listed.\nMaximum records limited to " + limit + "."); //how many records
    	}
    	else
    		outputArea2.setText("No information to export!");//nothing to export
    }
}
