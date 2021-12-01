//  ////////////////////////////////////////////////////////////////
//  ITEM CLASS
//  By: Virgilio D. Cabading Jr.    Created at: November 29, 2021 1630
//  ////////////////////////////////////////////////////////////////

public class Item {
    //  //// VARIABLES /////////////////////////////////////////////
    private String name;
    private double price;
    private int index;

    //  //// METHODS ///////////////////////////////////////////////

    //  **** CONSTRUCTORS ******************************************
    
    //  ---- Constructor -------------------------------------------
    public Item() {
        this("none", (double) 0);
    }

    //  ---- Constructor -------------------------------------------
    //  @param: 1. String name 2. double price
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }


    //  **** SET METHODS *******************************************

    public void setName (String name) {
        this.name = name;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public void setIndex (int index) {
        this.index = index;
    }

    //  **** GET METHODS *******************************************

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getItem() {
        return String.format("%d: %s -- S%.2f", this.index, this.name, this.price);
    }

    public int getIndex() {
        return this.index;
    }
}