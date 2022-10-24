import java.util.*;
public class Bitcoin 
{
    public static void main (String[] args)
    {
        //clears terminal
        System.out.println("\033[H\033[2J");

        //declaring variables
        Scanner input = new Scanner(System.in);
        GetLive g = new GetLive();
        Wallet w = new Wallet();
        Ledger l = new Ledger();
        String userInput;
        String[] userInputA;

        //creates wallet based off of user command-line arg input
        if (args.length == 0)
        {
            w = new Wallet();
        }
        else if (args.length == 3)
        {
            w = new Wallet (args[0], Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        }
        else 
        {
            System.out.println("INVALID USE OF PROGRAM");
            System.exit(1);
        }

        //menu UI
        System.out.println("Welcome to the crypto market!");
        while (true)
        {
            System.out.println("\nSelect from the following options:");
            System.out.println("price");
            System.out.println("buy [AMOUNT]");
            System.out.println("sell [AMOUNT]");
            System.out.println("balance");
            System.out.println("history");
            System.out.println("exit\n");
            System.out.print("Enter: ");

            //getting user input in String form
            userInput = input.nextLine();
            userInputA = userInput.split(" ");


            //user options decision structure
            if (userInputA[0].toLowerCase().equals("price"))
            {
                //prints current price of coin
                System.out.println("Current price: " + g.getPrice());
            }
            else if (userInputA[0].toLowerCase().equals("buy"))
            {
                //checking if user has sufficient funds for purchase
                if (g.purchaseCalc(Double.parseDouble(userInputA[1])) < w.getMoney())
                {
                    //changing coins in wallet
                    w.setCoinsInWallet(Double.parseDouble(userInputA[1]));

                    //subtracting purchase amount from available funds
                    w.setMoney(g.purchaseCalc(Double.parseDouble(userInputA[1])) - (g.purchaseCalc(Double.parseDouble(userInputA[1]))*2));
                    System.out.println("Purchase successful, thank you!");

                    //updating ledger
                    l.updateLedger(userInputA, w.getTickerSymbol(), g.getPrice());
                }
                else 
                {
                    //message if user lacks funds for purchase
                    System.out.println("INSUFFICIENT FUNDS");
                }
                g.updatePrice();
            }
            else if (userInputA[0].toLowerCase().equals("sell"))
            {
                //checking if user has enough coins in wallet for sell
                if (w.getCoinsInWallet() >= Double.parseDouble(userInputA[1]))
                {
                    //updating coin amount in wallet
                    w.setMoney(g.sellCalc(Double.parseDouble(userInputA[1])));

                    //updating funds available post sell
                    w.setCoinsInWallet(Double.parseDouble(userInputA[1]) - Double.parseDouble(userInputA[1])*2);
                    System.out.println("Sell successful, thank you!");

                    //updating ledger
                    l.updateLedger(userInputA, w.getTickerSymbol(), g.getPrice());
                }
                else 
                {
                    //message if user lacks # of coins selling
                    System.out.println("INSUFFICIENT COINS");
                }
                g.updatePrice();
            }
            else if (userInputA[0].toLowerCase().equals("balance"))
            {
                //prints wallet information
                w.print(g.getPrice());
            }
            else if (userInputA[0].toLowerCase().equals("history"))
            {
                //prints ledger
                l.printLedger();
            }
            else if (userInputA[0].toLowerCase().equals("exit"))
            {
                //closes scanner and exits program
                input.close();
                System.exit(0);
            }
            else 
            {
                //input validation message
                System.out.println("Invalid input, try again.");
            }
        }

    }
}
