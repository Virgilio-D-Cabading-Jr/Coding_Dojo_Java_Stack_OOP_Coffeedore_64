import java.util.ArrayList;

//  ////////////////////////////////////////////////////////////////
//  COFFEE KIOSK CLASS 
//  By: Virgilio D. Cabading Jr.    Created at: November 30, 2021 1330
//  ////////////////////////////////////////////////////////////////

public class CoffeeKiosk {
    // //// VARIABLES /////////////////////////////////////////////
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    // //// METHODS ///////////////////////////////////////////////

    // **** CONSTRUCTORS ******************************************

    // ---- Constructor : Default ---------------------------------
    public CoffeeKiosk() {
        menu = new ArrayList<Item>();                               // Initialize into empty arrays
        orders = new ArrayList<Order>();
    }
    
    // **** GET METHODS *******************************************

    public Item getItemFromMenu(int index) {
        for (Item item : menu) {
            if (item.getIndex() == index) {                         // If found item using index
                return item;                                        //      return the item
            }
        }
        return null;                                                // Return null if didn't find item with given index
    }
    
    // **** SET METHODS *******************************************

    // **** ADD METHODS *******************************************

    // ---- Add Menu Item -----------------------------------------
    // @param: String name, double price
    public void addMenuItem(String name, double price) {
        Item item = new Item(name, price);
        this.menu.add(item);
        menu.get(menu.size()-1).setIndex(menu.size()-1); 
    }

    // ---- Add New Order -----------------------------------------
    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        String name = System.console().readLine("Please enter customer name for new order:  ");
    
    	// Your code:
        // Create a new order with the given input string
        Order newOrder = new Order(name);
        
        // Show the user the menu, so they can choose items to add.
        System.out.println("");
        this.displayMenu();

    	// Prompt the user to enter an item number
        String input = System.console().readLine(newOrder.getName() + ", please enter a menu item index or q to quit: ");
        System.out.println("");
        
        // While loop keeps looping until user inputs "q"
        while(!input.equals("q")) {
            
            if (CoffeeKiosk.isNumeric(input)) {                         // Check if there is an int within the input
                int index = Integer.parseInt(input);                    // Convert Input into an integer
    
                Item newItem = this.getItemFromMenu(index);             // Get the item specified by the index in the menu
                if (newItem != null) {                                  // If the item is in the menu
                    newOrder.addItem(newItem);                          //      add the item to the order
                    System.out.println(newOrder.getName() + ", " + newItem.getName() + " was added to the order.");
                } else {
                    System.out.println(newOrder.getName() + ", sorry could not order that last item.");
                }
                System.out.println("");
            }

            // Ask them to enter a new item index or q again, and take their input
            input = System.console().readLine(newOrder.getName() + ", please enter a menu item index or q to quit: ");
            System.out.println("");
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        System.out.println("\n*****************************************************");
        newOrder.display();
        System.out.println("");
    }


    // **** SHOW METHODS ******************************************

    public void display() {
        this.displayMenu();

        if (this.orders .size() > 0) {
            System.out.println(("==== Orders ============"));
        }
        for (int i=0; i< this.orders.size(); i++ ) {
                System.out.print( i + " ");
                orders.get(i).display();
        }
    }

    public void displayMenu() {
        if (this.menu.size() > 0) {
            System.out.println(("==== Menu ============"));
        }
        for (Item item : menu) {
            System.out.println(item.getItem());
        }
    }

    // **** UTILITIES ******************************************

    // ---- Is Numeric -----------------------------------------
    //          determines if there is an integer in the string
    // @return: boolean
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}