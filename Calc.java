
public class Calc
{


  public static boolean Gamble(int beginOver, int halfOver)
  {
    boolean Gamb = false;
    int difference = halfOver - beginOver;
    if(difference >= 10)
    {
      Gamb = true;
    }
    return Gamb;
    
  }
  public static void main(String[] args)
  {
    Download.main(args);
    int game = Download.getGameID();
    String gameID = String.valueOf(game);
    String diff = Download.getTotal();
    System.out.println("DIFF LENGTH" + diff);
    String sendfin;
    if(diff.length() > 2)
    {
    String first = diff.substring(0, 2);
    int test1 = Integer.parseInt(first);
    String second = diff.substring(2, 4);
    int test2 = Integer.parseInt(second);
    int finTot = (test1+test2) * 2;
    System.out.println("FINAL TOTAL" + finTot);
    if(Gamble(10, finTot))
    {
      System.out.println("GAMBLE TRUE");
      int send = finTot;
      sendfin = String.valueOf(send);
      //Text.sendText(gameID, sendfin);
    }
    else
    {
      System.out.println("GAMBLE FALSE");
    }
    }
    else
    {
      //Text.sendText("test", "1");
    }
  }
}
