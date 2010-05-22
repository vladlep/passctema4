import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;


public class XSDReader 
{
	public static void main(String argv[]) {
        /*if (argv.length != 1) {
            System.err.println("Usage: XMLDotReader filename");
            System.exit(1);
        }
	*/
        try {
            DefaultHandler dotsHandler = new XMLReader();
            
	    SAXParserFactory factory = SAXParserFactory.newInstance();
        
	    //use default non-validating parser

	    SAXParser saxParser = factory.newSAXParser();
	    
      //  System.out.println("rootul fisiierului"+new File(".").getCanonicalPath()); 
	    File f = new File("dots.xml"); 
	 // System.out.println(f.getPath()+" abs path "+f.getAbsolutePath());
	    
        saxParser.parse(f , dotsHandler);


        } catch (Throwable t) { // much too general exception handling !!!

            t.printStackTrace();
        }
    }


}
