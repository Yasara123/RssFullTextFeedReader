import java.io.*;
import java.nio.channels.Channel;

import nu.xom.*;
public class Aggregator {
public String [] title= new String[15];
public String [] link= new String[15];
public int count=0;
public Aggregator(String rssUrl) {
    try {
        Builder builder=new Builder();
        Document doc=builder.build(rssUrl);
        Element root=doc.getRootElement();
        Element channel=root.getFirstChildElement("channel");
        if(channel != null){
            Elements items=channel.getChildElements("item");
            for (int current = 0; current < items.size(); current++) {
                if(count>15){
                    break;
                }
                Element item= items.get(current);
                Element titleElement=item.getFirstChildElement("title");
                Element linkElement=item.getFirstChildElement("link");
                title[current]=titleElement.getValue();
                link[current]=linkElement.getValue();
                count++;
                
            }
        }
    } catch ( ParsingException e) {
        // TODO: handle exception
        System.out.println("XML Error");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
}
public void listItems() {
    for (int i = 0; i < 15; i++) {
        if(title[i] != null){
            System.out.println("\n"+title[i]);
            System.out.println(link[i]);
            i++;
        }
        
    }
    
}
public static void main(String[] arguments) {
    
        Aggregator aggile=new Aggregator("https://news.google.com/news?cf=all&hl=en&pz=1&ned=us&topic=n&output=rss");
        aggile.listItems();
    
}
}
