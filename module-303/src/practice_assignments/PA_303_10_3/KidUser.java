package practice_assignments.PA_303_10_3;

public class KidUser implements LibraryUser{

    int age;
    String bookType;

    KidUser(int age) {
        this.age = age;
    }

    KidUser(String bookType) {
        this.bookType = bookType;
    }

    KidUser(int age, String bookType) {
        this.age = age;
        this.bookType = bookType;
    }

    public void registerAccount() {
        if (age <= 11) {
            System.out.println("Sorry, age must be less than 12 to register as a kid.");
        }
    }

    public void requestBook() {
        if (bookType == "Kids") {
            System.out.println("Book issued successfully, please return the book within 10 days");
        } else {
            System.out.println("Oops, you are only allowed to take kids books.");
        }
    }
}
