package controllers.dto;

/**
 * Generated using: https://codverter.com/src/sqltoclass
 */
public class Item {
    private String name;
    private double price;

    public String getname()
    {
        return this.name;
    }
    public void setname(String value)
    {
        this.name = value;
    }

    public double getprice()
    {
        return this.price;
    }
    public void setprice(double value)
    {
        this.price = value;
    }


    public Item(String name_,double price_)
    {
        this.name = name_;
        this.price = price_;
    }
}
