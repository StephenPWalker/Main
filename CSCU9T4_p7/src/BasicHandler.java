import org.xml.sax.*;				// import SAX classes
import org.xml.sax.helpers.*;		// import SAX helper classes

/**
  SAX event handler to output in basic format.

  @author 	CSCU9T4 Demo, University of Stirling
  @version  22/03/15
*/
public class BasicHandler extends DefaultHandler {

  /**
    Callback when parser finds character data.

    @param ch			character data
    @param start		character start index
    @param length		character count
    @throws			    SAX exception
  */
	  int count = 0;
  public void characters(char ch[], int start, int length) {
    String characters = new String(ch, start, length).trim();
    /*
    if (!characters.isEmpty())
      System.out.println("  characters '" + characters + "'");
      */
  }

  /**
    Callback when parser finds the end of a document.

    @throws			SAX exception
  */
  public void endDocument() throws SAXException {
    //System.out.println("endDocument callback");
  }

  /**
    Callback when parser finds the end of an element.

    @param namespaceURI		namespace URI
    @param localName		local namespace identifier
    @param qName		qualified name for namespace
    @throws			SAX exception
  */
  public void endElement(String namespaceURI, String localName, String qName)
   throws SAXException {
    //System.out.println("endElement callback for '" + qName + "'");
  }

  /**
    Callback when parser starts to read a document.

    @throws			SAX exception
  */
  public void startDocument() throws SAXException {
    //System.out.println("startDocument callback");
  }

  /**
    Callback when parser starts to read an element.

    @param namespaceURI		namespace URI
    @param localName		local namespace identifier
    @param qName		qualified name for namespace
    @param attributes		elements attributes
    @throws			SAX exception
  */
  public void startElement(String namespaceURI, String localName,
   String qName, Attributes attributes) throws SAXException {
	if(qName.equals("CD"))
	{
		count++;
		System.out.println("Reading CD Number =" + count);
	}
    /*System.out.println("startElement callback for '"  + qName + "'");
    for (int i = 0; i < attributes.getLength(); i++)
      System.out.println(
	"  attribute '" + attributes.getQName(i) +
	"' is '" + attributes.getValue(i) + "'");*/
  }

}
