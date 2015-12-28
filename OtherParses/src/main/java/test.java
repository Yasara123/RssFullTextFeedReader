
import java.io.InputStream;
import java.net.URL;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.LinkContentHandler;
import org.apache.tika.sax.TeeContentHandler;
import org.apache.tika.sax.ToHTMLContentHandler;
import org.jsoup.Jsoup;
import org.xml.sax.ContentHandler;
public class test {
    private static String cleanHtml(String text) { 
        text=text.replaceAll("</?\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|\'.*?\'|[^\'\">\\s]+))?)+\\s*|\\s*)/?>", "");
        text=text.replaceAll("<div.*?.*?>", "");
        text = text.replaceAll("—", "--"); 
        text = text.replaceAll("“", "\""); 
        text = text.replaceAll("”", "\""); 
        text = text.replaceAll("‘", "'"); 
        text = text.replaceAll("’", "'");       
        text = text.replaceAll("https?://\\S+\\s?", ""); 
        return text; 
    } 
    public static void main(String[] args) throws Exception{
        //URL url = new URL("http://abcnews.go.com/US/wireStory/chicago-police-shooting-grandmother-teen-draws-criticism-35970453");
        URL url = new URL("http://abcnews.go.com/US/wireStory/chicago-police-shooting-grandmother-teen-draws-criticism-35970453");
        InputStream input = url.openStream();
        LinkContentHandler linkHandler = new LinkContentHandler();
        ContentHandler textHandler = new BodyContentHandler(1000000);
        ToHTMLContentHandler toHTMLHandler = new ToHTMLContentHandler();
        TeeContentHandler teeHandler = new TeeContentHandler(linkHandler, textHandler, toHTMLHandler);
        Metadata metadata = new Metadata();
        ParseContext parseContext = new ParseContext();
        HtmlParser parser = new HtmlParser();
        parser.parse(input, teeHandler, metadata, parseContext);
        System.out.println("title:\n" + metadata.get("title"));
        //System.out.println("links:\n" + linkHandler.getLinks());
        String text=cleanHtml(textHandler.toString());
        //System.out.println("text:\n" + textHandler.toString());
        System.out.println("text:\n" +textHandler.toString());
        //System.out.println("html:\n" + toHTMLHandler.toString());
    }
    
 
}