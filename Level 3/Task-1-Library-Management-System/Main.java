import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LibraryManagement library = new LibraryManagement();

        int choice = -1;

        do {
            System.out.println("\n================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Register User");
            System.out.println("6. View Users");
            System.out.println("7. Borrow Book");
            System.out.println("8. Return Book");
            System.out.println("0. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter book title: ");
                        String title = input.nextLine();

                        System.out.print("Enter author: ");
                        String author = input.nextLine();

                        System.out.print("Enter ISBN: ");
                        String isbn = input.nextLine();

                        System.out.print("Enter total copies: ");
                        int copies = Integer.parseInt(input.nextLine());

                        library.addBook(title, author, isbn, copies);
                        break;

                    case 2:
                        library.viewBooks();
                        break;

                    case 3:
                        System.out.print("Enter book ID: ");
                        int updateId = Integer.parseInt(input.nextLine());

                        System.out.print("Enter new title: ");
                        String newTitle = input.nextLine();

                        System.out.print("Enter new author: ");
                        String newAuthor = input.nextLine();

                        System.out.print("Enter new ISBN: ");
                        String newIsbn = input.nextLine();

                        System.out.print("Enter new total copies: ");
                        int newCopies = Integer.parseInt(input.nextLine());

                        library.updateBook(updateId, newTitle,
                                newAuthor, newIsbn, newCopies);
                        break;

                    case 4:
                        System.out.print("Enter book ID: ");
                        int deleteId = Integer.parseInt(input.nextLine());

                        library.deleteBook(deleteId);
                        break;

                    case 5:
                        System.out.print("Enter user name: ");
                        String name = input.nextLine();

                        System.out.print("Enter email: ");
                        String email = input.nextLine();

                        library.addUser(name, email);
                        break;

                    case 6:
                        library.viewUsers();
                        break;

                    case 7:
                        System.out.print("Enter book ID: ");
                        int borrowBookId = Integer.parseInt(input.nextLine());

                        System.out.print("Enter user ID: ");
                        int borrowUserId = Integer.parseInt(input.nextLine());

                        library.borrowBook(borrowBookId, borrowUserId);
                        break;

                    case 8:
                        System.out.print("Enter book ID: ");
                        int returnBookId = Integer.parseInt(input.nextLine());

                        System.out.print("Enter user ID: ");
                        int returnUserId = Integer.parseInt(input.nextLine());

                        library.returnBook(returnBookId, returnUserId);
                        break;

                    case 0:
                        System.out.println("Thank you for using the Library Management System!");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }

        } while (choice != 0);

        input.close();
    }
}
