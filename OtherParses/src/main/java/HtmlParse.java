
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class HtmlParse {

   public static void main(final String[] args) throws IOException, SAXException, TikaException {
   
      //Scanner scanner = new Scanner(System.in);     
      //System.out.println("Enter the path of your file");
      //String fileName = scanner.nextLine();
      
      //detecting the file type
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(new File("http://www.usatoday.com/story/weather/2015/12/28/severe-weather-midwest-texas/77963416/"));
      ParseContext pcontext = new ParseContext();
      
      //Html parser
      HtmlParser htmlparser = new HtmlParser();
      htmlparser.parse(inputstream, handler, metadata,pcontext);
      System.out.println("Contents of the document:" + handler.toString());
      System.out.println("Metadata of the document:");
      String[] metadataNames = metadata.names();
      
      for(String name : metadataNames) {
         System.out.println(name + ":   " + metadata.get(name));
      }
   }
}
