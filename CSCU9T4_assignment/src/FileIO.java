// FILEIO code created and submitted by spw00004

import java.io.*;

public class FileIO 
{
	private String inputFileName;
	private PrintWriter out = new PrintWriter("output.txt");
	private String line = null;
	private String result;
	private boolean isConverted = false;
	
	 public FileIO(String fileName) throws FileNotFoundException
	 {
		  	inputFileName = fileName;  //get filename
	 }
	 public String format()
	 {
		 try{
	            FileReader fileReader = new FileReader(inputFileName); 
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            while ((line = bufferedReader.readLine()) != null)
	            {
	            	line.split("\t"); //split one tab 
	                out.println(line);
	            }
	            out.close();
	            bufferedReader.close();
	            result = ("File converted\n"); //file converted into a line per record
	            isConverted = true;
	        }
	        catch(IOException ex)
	        {
	            result = ("Error reading file " + inputFileName + "\n");
	        }
		 return result;
	 }
	 public boolean isConverted()
	 {
		 return isConverted;
	 }
}
