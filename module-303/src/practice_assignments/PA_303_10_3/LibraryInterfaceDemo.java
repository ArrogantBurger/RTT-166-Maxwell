package practice_assignments.PA_303_10_3;

public class LibraryInterfaceDemo {

    public static void main(String[] args) {
        LibraryUser user1 = new KidUser(10, "Kids");
        user1.registerAccount();
        LibraryUser user2 = new KidUser(18);
        user2.registerAccount();

        LibraryUser user3 = new KidUser(11, "Fiction");
        user1.requestBook();
        user3.requestBook();

        LibraryUser user4 = new AdultUser(5, "");
        user4.registerAccount();
        LibraryUser user5 = new AdultUser(23, "Fiction");
        user5.registerAccount();

        LibraryUser user6 = new AdultUser(16, "Kids");
        user5.requestBook();
        user6.requestBook();
    }
}
