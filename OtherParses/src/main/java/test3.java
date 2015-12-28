import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.htmlparser.jericho.Source;



public class test3 {
    public static void clr(String htl) {
        Source source = new Source(htl);
        //System.out.print(htl);
        System.out.print(source.getTextExtractor().toString()); 
        
    }

    public static void main(String[] args) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        
        try {
           // System.out.println("http://");
            String [] arr="http://news.google.com/news/url?sa=t&fd=R&ct2=us&usg=AFQjCNGcnogKGzZRFRiW9WTAfz4ijFw1JQ&clid=c3a7d30bb8a4878e06b80cf16b898331&cid=52779017179345&ei=WgCBVtiPDZHG8gWGtbvAAg&url=http://www.usatoday.com/story/weather/2015/12/28/severe-weather-midwest-texas/77963416/".split("http://");
            //System.out.println(arr[arr.length-1]);
            //System.out.println("ok");
            url = new URL("http://"+arr[arr.length-1]);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
          
            String ht="";
            while ((line = br.readLine()) != null) {
               ht=ht.concat((String)line);
                //System.out.println(line);
               
               
            }
            //System.out.println(ht);
            clr(ht);
            
        } catch (MalformedURLException mue) {
             mue.printStackTrace();
        } catch (IOException ioe) {
             ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }

    }

}
