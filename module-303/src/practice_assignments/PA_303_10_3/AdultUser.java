package practice_assignments.PA_303_10_3;

public class AdultUser implements LibraryUser {

    int age;
    String bookType;

    AdultUser(int age) {
        this.age = age;
    }

    AdultUser(String bookType) {
        this.bookType = bookType;
    }

    AdultUser(int age, String bookType) {
        this.age = age;
        this.bookType = bookType;
    }

    public void registerAccount() {
        if (age >= 12) {
            System.out.println("You have successfully registered under an adult account.");
        } else {
            System.out.println("Sorry, age must be greater than 12 to register as an adult.");
        }
    }

    public void requestBook() {
        if (bookType.equals("Fiction")) {
            System.out.println("Book issued successfully, please return the book within 7 days.");
        } else {
            System.out.println("Oops, you are only allowed to take adult fiction books.");
        }
    }
}
