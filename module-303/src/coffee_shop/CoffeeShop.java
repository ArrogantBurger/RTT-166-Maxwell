package coffee_shop;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {

    private Scanner scanner = new Scanner(System.in);

    // this is a class level variable that will contain our list of products for sale
    // best practice is to define these at the top of the class
    private List<Product> products = new ArrayList<>();

    private List<Product> cart = new ArrayList<>();

    private DecimalFormat d = new DecimalFormat("'$'0.00");

    private void initProducts() {
        Product p1 = new Product("Small Coffee", 4.59, 0);
        products.add(p1);

        Product p2 = new Product("Large Coffee", 7.99, 0);
        products.add(p2);

        Product p3 = new Product("Cookie", 5.89, 0);
        products.add(p3);

        Product p4 = new Product("Egg Sandwich", 6.49, 0);
        products.add(p4);

    }

    private void printProductMenu() {
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.print((i + 1) + " ) " + p.getName());
            for (int j = 0; j < (5 - p.getName().length() / 4); j++) {
                System.out.print("\t");
            }
            System.out.println(p.getPrice());
        }
        System.out.println("============================");
    }

    private int printMainMenu() {
        System.out.println("1) See product menu");
        System.out.println("2) Purchase product");
        System.out.println("3) Checkout");
        System.out.println("4) Exit");

        System.out.print("Enter selection: ");

        try {
            int selection = scanner.nextInt();
            return selection;
        } catch (Exception e) {
            System.out.println("Invalid selection" + e.getMessage());
            return -1;
        } finally {
            scanner.nextLine();
        }
    }

    public void addProductToCart() {
        // display items for sale
        printProductMenu();

        System.out.print("Enter product number: ");
        int selection = scanner.nextInt();
        scanner.nextLine();

        if (selection >= 1 && selection <= products.size()){
            Product p = products.get(selection - 1);

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            if (quantity > 0) {
                p.setQuantity(p.getQuantity() + quantity);
            } else {
                System.out.println("Invalid quantity entered.");
                return;
            }

            // Adds item to cart if no like item exists
            boolean itemFound = false;
            for (Product item : cart){
                if (item.getName().equals(p.getName()) && !itemFound) {
                    itemFound = true;
                    break;
                }
            }
            if (!itemFound) {
                cart.add(p);
            }


            System.out.println("Added " + p.getName() + " to your cart.\n");
            System.out.println("Currently have " + p.getQuantity() + " " + p.getName() + " in your cart.\n");
        } else {
            System.out.println("Invalid item selection");
        }
    }

    public void checkout() {
        System.out.println("==== Items in your cart ====");

        double subtotal = 0.0;
        int spacing = 0;

        // list the items in the cart
        for (Product item : cart) {
            System.out.print(item.getName());
            for (int i = 0; i < (6 - item.getName().length() / 4); i++) {
                System.out.print("\t");
            }
            System.out.print("x" + item.getQuantity() + "\t" + d.format(item.getPrice() * item.getQuantity()));
            //System.out.print("x" + item.getQuantity() +  "\t $" + (item.getPrice() * item.getQuantity()));
            //System.out.print(item.getName() + "\tx" + item.getQuantity() +  "\t $" + (item.getPrice() * item.getQuantity()));
            System.out.print("\n");
            subtotal += item.getPrice() * item.getQuantity();
        }
        System.out.println("");
        System.out.println("Subtotal\t\t" + d.format(subtotal));

        // calculate and add sales tax
        double tax = subtotal * 0.0825;
        System.out.println("Tax\t\t\t\t" + d.format(tax));
        System.out.println("Total\t\t\t"+ d.format(subtotal + tax));
    }

    public void start() {
        // this becomes similar to the main method in that it will be where our project starts and runs
        initProducts();
        while (true) {
            int selection = printMainMenu();
            if (selection == 1) {
                printProductMenu();
            } else if (selection == 2) {
                // purchase product
                addProductToCart();
            } else if (selection == 3) {
                // checkout
                checkout();
            } else if (selection == 4) {
                // exit
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Invalid selection entered " + selection + "\n");
            }
        }


    }

    public static void main(String[] args) {
        CoffeeShop cs = new CoffeeShop();
        cs.start();
    }
}
