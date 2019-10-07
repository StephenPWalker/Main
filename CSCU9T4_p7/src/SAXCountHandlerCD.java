
import java.io.*;
import javax.xml.parsers.*;

import org.xml.sax.*;

public class SAXCountHandlerCD {
  /**
    Main program to call SAX parser.

    @param args			command-line arguments
    First argument is the name of the xml file to process
  */
 
  public static void main(String[] args) {
    parse(args[0]);
  }

  /**
    Callback when parser finds character data.

    @param filename		XML file to read
  */
  private static void parse(String filename) {
    try {
      System.out.println("-------------------");
      System.out.println("parsing " + filename);
      System.out.println();
      // get an instance of SAXParserFactory and get an XMLReader from it
      SAXParserFactory factory = SAXParserFactory.newInstance();
      XMLReader reader = factory.newSAXParser().getXMLReader();

      // turn off XML validation
      reader.setFeature("http://xml.org/sax/features/validation",false);

      // register the relevant handler with the parser, choosing one of:
      BasicHandler handler = new BasicHandler();
      //CountHandler handler = new CountHandler();
    
      reader.setContentHandler(handler);
      reader.setErrorHandler(handler);

      // parse the given file
      InputSource inputSource = new InputSource(filename);
      reader.parse(inputSource);
      System.out.println("-------------------");
      System.out.println();
    }
    catch (Exception exception) {
      System.err.println("could not parse file - " + exception);
    }
  }

}
