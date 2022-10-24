import java.util.*;
public class Ledger
{
    //class attributes
    private ArrayList list;
    private MyDate d;

    //default constructor
    public Ledger ()
    {
        this.list = new ArrayList<String>();
        this.d = new MyDate();
    }

    //method that updates the ledger after each purchase/sell transaction
    public void updateLedger (String[] userInput, String tickerSymbol, int coinValue)
    {
        String str = "";

        if (userInput[0].equals("buy"))
        {
            str = "You bought " + userInput[1] + " " + tickerSymbol + " on " + d.getDate();
        }
        else 
        {
            str = "You sold " + userInput[1] +  " " + tickerSymbol + " on " + d.getDate();
        }
        this.list.add(str);
    }

    //method that prints the contents of the ledger (ArrayList)
    public void printLedger ()
    {
        if (this.list.isEmpty())
        {
            System.out.println("NONE");
        }
        else 
        {
            for (int i = 0; i < this.list.size(); i++)
            {
                System.out.println(list.get(i));
            }
        }
    }
}
