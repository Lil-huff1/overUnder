import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
public class Download
{
  static String total = " ";
  static int gameID = 0;
  public static void main(String[] args) {
    URL url;
    InputStream is = null;
    BufferedReader br;
    String line;

    try {
        url = new URL("http://www.espn.com/nba/bottomline/scores");
        is = url.openStream();  // throws an IOException
        br = new BufferedReader(new InputStreamReader(is));
       line = br.readLine();
            //System.out.println(line);
        String[] games = line.split("gameId");
        String game1[] = new String[games.length];
        for(int i = 0; i < games.length; i++)
        {
          Component frame = null;
          JOptionPane.showMessageDialog(frame, "test");
          System.out.println(i);
          System.out.println(games[i]);

          if(games[i].length() < 75)
          {
            break;
          }
          Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(games[i]);
          while(m.find()) {
            System.out.println("TIME OF GAME");
            System.out.println(m.group(1)); 
            game1[i] = m.group(1); 
          }
          //System.out.println("TIME TEST" + game1[i].substring(0, 1) + game1[i].substring(12, 13));
          if((game1[i].charAt(0) == '0') && (game1[i].charAt(12) == '2'))
          {
            //System.out.println("HALFTIME SUCCESS");
          int indexOne = 0;
          int indexTwo = 0;
          String scoreOne = null;
          String scoreTwo = null;
          for(int j = 0; j < games[i].length(); j++)
          {
            //System.out.println("J IS " + j);
            if(games[i].charAt(j) == '%' && indexOne == 0  && Character.isDigit(games[i].charAt(j + 3)))
            {
              indexOne = j + 3;
              scoreOne = games[i].substring(indexOne, indexOne + 2);
              System.out.println(scoreOne + "SCORE ONE");
              j += 16;
              
            }
            else if(games[i].charAt(j) == '%' && indexOne != 0 && indexTwo == 0 && Character.isDigit(games[i].charAt(j + 3)))
            {
              indexTwo = j + 3;
              scoreTwo = games[i].substring(indexTwo, indexTwo + 2);
              System.out.println(scoreTwo + "SCORE TWO");
              break;
            }
          }
          total = scoreOne + scoreTwo;
          gameID = i;
          }
        }
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
  public static String getTotal()
  {
    return total;
  }
  public static int getGameID()
  {
    return gameID;
  }
}
