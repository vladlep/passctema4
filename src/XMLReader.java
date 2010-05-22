// ValidatingXMLDotReader.java
// Uses the SAX interface
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class XMLReader extends DefaultHandler {

    static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

    public static List loadList () {
        /*if (argv.length != 1) {
            System.err.println("Usage: cmd filename");
            System.exit(1);
        }*/
        try {
            DefaultHandler handler = new XMLReader();

            SAXParserFactory factory = SAXParserFactory.newInstance();

            factory.setValidating(true);

            factory.setNamespaceAware(true);

            SAXParser saxParser = factory.newSAXParser();

            saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);

            saxParser.parse(new File("horoscop.xml"), handler);

        } catch (SAXParseException spe) {
            // Error generated by the parser
            System.out.println("\n** Parsing error" + ", line " +
                    spe.getLineNumber() + ", uri " + spe.getSystemId());
            System.out.println("   " + spe.getMessage());

            // Use the contained exception, if any
            Exception x = spe;

            if (spe.getException() != null) {
                x = spe.getException();
            }

            x.printStackTrace();
        } catch (SAXException sxe) {
            // Error generated by this application
            // (or a parser-initialization error)
            Exception x = sxe;

            if (sxe.getException() != null) {
                x = sxe.getException();
            }

            x.printStackTrace();
        } catch (ParserConfigurationException pce) {
            // Parser with specified options can't be built
            pce.printStackTrace();
        } catch (IOException ioe) {
            // I/O error
            ioe.printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }

       
		return list;
    }

//===========================================================
// state variables
//===========================================================
    private int nr_matr;
    private String nume;
    private double medie;
    private static ArrayList<Student> list = new ArrayList<Student>(); 

//===========================================================
// SAX DocumentHandler methods
//===========================================================

    public void startDocument()
            throws SAXException {
        System.out.println("startDocument");
    }

    public void endDocument()
            throws SAXException {
        System.out.println("endDocument");
    }

    /**
    Called for each node
    -look at qName and atts to see the node state
    -process that node if appropriate
    -or, update our state to affect future calls to startElement()
    or characters()
     */
    public void startElement(String namespaceURI, String localName,
            String qName, Attributes atts)
            throws SAXException {
        System.out.println("start element:" + qName);
        
        if (qName.equals("student")) {
            nr_matr = Integer.parseInt(atts.getValue("nr_matr"));
            nume = atts.getValue("nume");
            medie = Double.parseDouble(atts.getValue("medie"));
            Student stud= new Student(nr_matr,nume,medie);
            list.add(stud);
            System.out.println("student: "+nr_matr + ", " + nume+", "+medie);
        
        }
        
    }


// Called at the end of each element
    public void endElement(java.lang.String uri,
            java.lang.String localName,
            java.lang.String qName)
            throws SAXException {
        System.out.println("end element:" + qName);
        
    }

// Called for characters between nodes.
    public void characters(char buf[], int offset, int len)
            throws SAXException {
        String s = new String(buf, offset, len);
        s = s.trim();
        if (!s.equals("")) {
            System.out.println("characters:" + s);   
        }
    }
    
}