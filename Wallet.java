public class Wallet
{
    //class attributes
    private String tickerSymbol;
    private double coinsInWallet;
    private double money;

    //default constructor
    public Wallet()
    {
        this.tickerSymbol = "BTC";
        this.coinsInWallet = 0.0;
        this.money = 75000;
    }

    //constructor #2
    //allows user to modify class default attributes
    public Wallet(String tickerSymbol, double coinsInWallet, double money)
    {
        this.tickerSymbol = tickerSymbol;
        this.coinsInWallet = coinsInWallet;
        this.money = money;
    }

    //getters
    public String getTickerSymbol ()
    {
        return this.tickerSymbol;
    }

    public double getCoinsInWallet ()
    {
        return this.coinsInWallet;
    }

    public double getMoney ()
    {
        return this.money;
    }

    //setters
    public void setTickerSymbol (String coinName)
    {
        this.tickerSymbol = coinName;
    }

    public void setCoinsInWallet (double coinAmount)
    {
        this.coinsInWallet += coinAmount;
    }

    public void setMoney (double money)
    {
        this.money += money;
    }

    //method prints wallet information
    public void print(int coinPrice)
    {
        System.out.println("\nWallet Information:");
        System.out.println("Coin: " + getTickerSymbol());
        System.out.println("Amount in Wallet: " + getCoinsInWallet());
        System.out.println("Trading funds available: $" + getMoney());
        System.out.println("Current value of coin: " + coinPrice);
    }


}
