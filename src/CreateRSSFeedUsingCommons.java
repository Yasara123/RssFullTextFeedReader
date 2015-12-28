import org.apache.commons.digester.rss.Channel;
import org.apache.commons.digester.rss.Item;
import org.apache.commons.digester.rss.RSSDigester;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.text.SimpleDateFormat;

class CreateRSSFeedUsingCommons {

    public static void main(String args[]) {

      SimpleDateFormat formatter=
          new SimpleDateFormat("dd MMM yyyy HH:mm:ss Z");
      String today = formatter.format(new Date());

      Channel newChannel = new Channel();

      newChannel.setCopyright("(c)Real Gagnon 2007");
      newChannel.setDescription("Useful Java code examples");
      newChannel.setLink("http://www.rgagnon.com/howto.html");
      newChannel.setLanguage("en");
      newChannel.setPubDate(today);

      Item item = new Item();
      item.setTitle("Real's HowTo");
      item.setLink("http://www.rgagnon.com/java-details/");
      item.setDescription("Cool java snippet!");
      newChannel.setPubDate(today);
      newChannel.addItem(item);

      try {
          FileOutputStream fout = new FileOutputStream("feed.xml");
          newChannel.render(fout);
          System.out.print(fout);
          fout.close();
          
      }
      catch (IOException e) {
          e.printStackTrace();
      }
    }
}
