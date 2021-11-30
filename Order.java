import java.util.ArrayList;

//  ////////////////////////////////////////////////////////////////
//  ORDER CLASS
//  By: Virgilio D. Cabading Jr.    Created at: November 29, 2021 1630
//  ////////////////////////////////////////////////////////////////

public class Order {
    //  //// VARIABLES /////////////////////////////////////////////
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    //  //// METHODS ///////////////////////////////////////////////

    //  **** CONSTRUCTORS ******************************************
    
    //  ---- Constructor -------------------------------------------
    public Order() {
        this("Guest");
    }

    //  ---- Constructor -------------------------------------------
    //  @param: String name
    public Order(String name) {
        this.name = name;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }

    //  **** SET METHODS *******************************************

    public void setName (String name) {
        this.name = name;
    }

    public void setReady (boolean ready) {
        this.ready = ready;
    }

    //  **** ADD METHODS *******************************************

    public void addItem(Item item) {
        this.items.add(item);
    }

    //  **** GET METHODS *******************************************

    public String getName() {
        return this.name;
    }

    // public double getTotal() {
    //     return this.total;
    // }

    public boolean getReady() {
        return this.ready;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public String getOrder() {
        String output = "";
        output += "Order || name: " + this.name + " | order ready: " + this.ready + " | total price: $" + this.getOrderTotal() +"\n";
        output += "Items in order: ";
        for (int i=0; i<this.items.size(); i++) {
            output += this.items.get(i).getName();
            if (i < (this.items.size()-1) ) {
                output += ", ";
            }
        }
        return output;
    }

    //  ---- Get Status Message --------------------------------------
    //  @logic:     1. If order is ready
    //                      return "Your order is ready. "
    //              2, If order is not ready
    //                      return "Thank you for waiting.  Your order will be ready soon."
    //  @return: String status message
    public String getStatusMessage() {
        if (this.ready) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting.  Your order will be ready soon.";
        }
    }

    //  ---- Get Order Total ------------------------------------------
    //  @return: double sum of all the prices of items in the order
    public double getOrderTotal() {
        double sum = 0;
        for (Item item : this.items) {
            sum += item.getPrice();
        }
        return sum;
    }

    //  **** SHOW METHODS ******************************************

    //  ---- Display -----------------------------------------------
    //  Prints to console the order information
    public void display() {
        System.out.println("Customer Name: " + this.name);
        double sum = 0;
        for (Item item : this.items) {
            System.out.printf("%s - $%.2f\n", item.getName(), item.getPrice());
            sum += item.getPrice();
        }
        System.out.printf("Total: $%.2f\n", sum);
        System.out.println(this.getStatusMessage());
    }
}
