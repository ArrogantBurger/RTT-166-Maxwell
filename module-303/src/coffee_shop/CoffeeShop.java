package coffee_shop;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.*;

public class CoffeeShop {

    private Scanner scanner = new Scanner(System.in);

    // this is a class level variable that will contain our list of products for sale
    // best practice is to define these at the top of the class
    private List<Product> products = new ArrayList<>();

    private List<Product> cart = new ArrayList<>();

    // used to format money to two decimal places
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

        sortByPrice(products);
    }

    // use a bubble sort algo
    // sort the list of products by price using 2 nested for loops to implement the bubble sort in a function
    // should create a function that will take in a List<Product> to be sorted and return a sorted List<Product>
    private List<Product> sortByPrice(List<Product> source) {
        // convert the List to an array
        Product temp;

        for (int outer = 0; outer < source.size() - 1; outer++) {
            for (int inner = outer + 1; inner < source.size(); inner++) {
                Product p0 = source.get(outer);
                Product p1 = source.get(inner);

                if (p0.getPrice() > p1.getPrice()) {
                    source.set(inner, p0);
                    source.set(outer, p1);
                }
            }
        }

        // products.forEach(p -> System.out.println(p));
        return null;
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
        System.out.println("4) Search");
        if (cart.size() > 0) {
            System.out.println("5) Remove product");
            System.out.println("6) Exit");
        } else {
            System.out.println("5) Exit");
        }


        System.out.print("Enter selection: ");

        try {
            int selection = scanner.nextInt();
            return selection;
        } catch (Exception e) {
            //System.out.println("Invalid selection " + e.getMessage());
            return -1;
        } finally {
            scanner.nextLine();
        }
    }

    public void addProductToCart() {
        // display items for sale
        printProductMenu();

        // Accepts product type
        System.out.print("Enter product number: ");
        int selection = scanner.nextInt();
        scanner.nextLine();

        if (selection >= 1 && selection <= products.size()) {
            Product p = products.get(selection - 1);

            // Accepts product quantity
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
            for (Product item : cart) {
                if (item.getName().equals(p.getName()) && !itemFound) {
                    itemFound = true;
                    break;
                }
            }
            if (!itemFound) {
                cart.add(p);
            }

            // Info message showing item added to cart along with the current quantity
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
            // creates even spacing in the terminal
            for (int i = 0; i < (6 - item.getName().length() / 4); i++) {
                System.out.print("\t");
            }
            System.out.print("x" + item.getQuantity() + "\t" + d.format(item.getPrice() * item.getQuantity()));
            System.out.print("\n");
            subtotal += item.getPrice() * item.getQuantity();
        }
        System.out.println("");
        System.out.println("Subtotal\t\t" + d.format(subtotal));

        // calculate and add sales tax
        double tax = subtotal * 0.0825;
        System.out.println("Tax\t\t\t\t" + d.format(tax));
        System.out.println("Total\t\t\t" + d.format(subtotal + tax));
    }

    public void productSearch() {
        System.out.println("Enter a product name to search for: ");
        String search = scanner.nextLine();

        // this line of code filters the list of products based on if the search input is in the string
        List<Product> results = products.stream().filter(p -> p.getName().toLowerCase().contains(search.toLowerCase())).toList();

        // print the result list using a lambda
        results.forEach(p -> System.out.println(p.getName()));
    }

    public void removeProductFromCart() {
        //System.out.println("*cutely removes item from cart*");

        for (Product item : cart) {
            int j = 1;
            System.out.print(j + ") " + item.getName());
            j++;
            // creates even spacing in the terminal
            for (int i = 0; i < (6 - item.getName().length() / 4); i++) {
                System.out.print("\t");
            }
            System.out.print("x" + item.getQuantity() + "\t" + d.format(item.getPrice() * item.getQuantity()));
            System.out.print("\n");
        }

        System.out.println("Select an item to remove from the cart");


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
                // search
                productSearch();
            } else if (selection == 5 && cart.size() > 0) {
                // remove product ONLY if product has been purchased
                // else exit
                removeProductFromCart();
            }
            else if ((selection == 5 && cart.size() == 0) || (selection == 6 && cart.size() > 0)) {
                // exit ONLY if product has been purchased
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                //System.out.println("Invalid selection entered " + selection + "\n");
                System.out.println("Invalid selection entered, please select valid number." + "\n");
            }
        }


    }

    public static void main(String[] args) {
        CoffeeShop cs = new CoffeeShop();
        cs.start();
    }
}
