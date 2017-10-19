import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Text
{
  public static void sendText(String teams, String diff)
  {
    Runtime rt = Runtime.getRuntime();
    System.out.println("INSIDE TEXT");
    String line;
    String message =  "Game ID is " + teams  + " Score total is  " + diff;
    String[] args = {"osascript", "-e", "tell application \"Messages\" to send \"" + message + "\" to buddy \"Me\""};
    //int num = 3015299555;
    //String[] cmd = {"curl http://textbelt.com/text -d number=3015299555 -d message=test1234"
  //      + ""};
    try
    {
      Process pr = rt.exec(args);
      System.out.println("TEAMS = " + teams + "DIFF = " + diff);
      BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
      while ((line = input.readLine()) != null) {
          System.out.println(line);
      }
      input.close();
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
