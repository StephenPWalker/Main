import java.util.Random;
import java.io.*;

public class garden_gate_problem {

	public static void main(String[] args) {
    RandomAccessFile admin;
    byte init[] = {0};

    if (args.length != 1)
      System.err.println("usage: java {gate_bottom,gate_top}");
    else {
      if(args[0].compareToIgnoreCase("gate_bottom") == 0) {
         System.out.println("running the bottom gate");
         try{
          admin = new RandomAccessFile("admin.txt","rw");
          admin.seek(0);
          admin.write(init);
          admin.close();
         }
         catch (IOException e){
            System.out.println("something wrong with file access" + e);
         }
      } else
         System.out.println("running the top gate");
      
      gate counter = new gate(args[0]);
	  counter.counting();
    }
  }
}
