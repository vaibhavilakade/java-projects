package JavaProject;

import java.util.*;

class MenuItem {
    int itemId;
    String name;
    double price;

    MenuItem(int itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return itemId + "\t" + name + "\t₹" + price;
    }
}

public class RestaurantBillingSystem {

    static ArrayList<MenuItem> menu = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add default menu items
    static {
        menu.add(new MenuItem(101, "Pizza", 250));
        menu.add(new MenuItem(102, "Burger", 100));
        menu.add(new MenuItem(103, "Pasta", 180));
        menu.add(new MenuItem(104, "Coffee", 80));
        menu.add(new MenuItem(105, "Sandwich", 120));
    }

    // Display Menu
    public static void displayMenu() {

        System.out.println("\n========== MENU ==========");

        Iterator<MenuItem> itr = menu.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    // Find Item by ID
    public static MenuItem findItem(int id) {

        for (MenuItem item : menu) {
            if (item.itemId == id) {
                return item;
            }
        }
        return null;
    }

    // Take Order and Generate Bill
    public static void placeOrder() {

        HashMap<MenuItem, Integer> cart = new HashMap<>();

        char choice = 0;

        do {

            System.out.print("\nEnter Item ID: ");
            int id = sc.nextInt();

            MenuItem item = findItem(id);

            if (item == null) {
                System.out.println("Invalid Item ID!");
                continue;
            }

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            cart.put(item, cart.getOrDefault(item, 0) + qty);

            System.out.print("Do you want to order more items? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        generateBill(cart);
    }

    // Generate Bill
    public static void generateBill(HashMap<MenuItem, Integer> cart) {

        int totalItems = 0;
        double totalBill = 0;

        System.out.println("\n========== BILL ==========");

        for (Map.Entry<MenuItem, Integer> entry : cart.entrySet()) {

            MenuItem item = entry.getKey();
            int qty = entry.getValue();

            double amount = item.price * qty;

            totalItems += qty;
            totalBill += amount;

            System.out.println(
                    item.name + " x " + qty + " = ₹" + amount
            );
        }

        System.out.println("\n----------------------------");
        System.out.println("Total Items Ordered : " + totalItems);
        System.out.println("Your Total Bill     : ₹" + totalBill);
        System.out.println("----------------------------");
        System.out.println("Thank You! Visit Again 😊");
    }

    public static void main(String[] args) {

        System.out.println("🍽️ Welcome to Restaurant");

        displayMenu();

        placeOrder();
    }
}