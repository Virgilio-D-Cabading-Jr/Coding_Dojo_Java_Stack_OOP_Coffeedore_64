//  ////////////////////////////////////////////////////////////////
//  COFFEEDORE 64 APPLICATION
//  By: Virgilio D. Cabading Jr.    Created at: November 30, 2021 1345
//  ////////////////////////////////////////////////////////////////

public class Coffeedore64 {
    public static void main(String[] args) {
        System.out.println("/////////////////////////////////////////////////////");
        System.out.println("COFFEEDORE 64 APPLICATION\n");
        
        CoffeeKiosk coffeeKiosk = new CoffeeKiosk();
        coffeeKiosk.display();

        // **** Create Menu ************
        coffeeKiosk.addMenuItem("Banana", 2);
        coffeeKiosk.addMenuItem("Coffee", 1.5);
        coffeeKiosk.addMenuItem("Latte", 4.5);
        coffeeKiosk.addMenuItem("Capuccino", 3);
        coffeeKiosk.addMenuItem("Muffin", 4);

        // **** Display Menu ************
        coffeeKiosk.displayMenu();
        System.out.println();

        coffeeKiosk.newOrder();
    }
}
