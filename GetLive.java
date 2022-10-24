public class GetLive
{
    //class attribute
    private int currPrice;

    //default constructor
    public GetLive ()
    {
        this.currPrice = 60000;
    }

    //method that updates value of coin
    public void updatePrice ()
    {
        this.currPrice = (int)(Math.random() * (65000 - 55000) + 55000);
    }

    //getter
    public int getPrice()
    {
        return this.currPrice;
    }

    //method that calculates purchase transaction
    //returns a double that represents USD value of purchase (negative value)
    public double purchaseCalc (double coinsPurchasing)
    {
        return coinsPurchasing * this.currPrice;
    }

    //method that calculates sell transaction
    //returns a double that represents USD value of sell (positive value)
    public double sellCalc (double coinsSelling)
    {
        return coinsSelling * this.currPrice;
    }
}
