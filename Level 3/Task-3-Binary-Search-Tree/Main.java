import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("   BINARY SEARCH TREE");
            System.out.println("==============================");
            System.out.println("1. Insert Multiple Nodes");
            System.out.println("2. Delete Node");
            System.out.println("3. Search Node");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("How many values do you want to insert? ");
                        int count = Integer.parseInt(input.nextLine());

                                for (int i = 1; i <= count; i++) {
                                System.out.print("Enter value " + i + ": ");
                                int value = Integer.parseInt(input.nextLine());
                                bst.insert(value);
                             }

                                System.out.println("All nodes inserted successfully!");
                            break;

                    case 2:
                        System.out.print("Enter value to delete: ");
                        int deleteValue =
                                Integer.parseInt(input.nextLine());

                        if (bst.search(deleteValue)) {
                            bst.delete(deleteValue);
                            System.out.println("Node deleted successfully!");
                        } else {
                            System.out.println("Value not found!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter value to search: ");
                        int searchValue =
                                Integer.parseInt(input.nextLine());

                        if (bst.search(searchValue)) {
                            System.out.println("Value found!");
                        } else {
                            System.out.println("Value not found!");
                        }
                        break;

                    case 4:
                        System.out.print("Inorder: ");
                        bst.inorder(bst.getRoot());
                        System.out.println();
                        break;

                    case 5:
                        System.out.print("Preorder: ");
                        bst.preorder(bst.getRoot());
                        System.out.println();
                        break;

                    case 6:
                        System.out.print("Postorder: ");
                        bst.postorder(bst.getRoot());
                        System.out.println();
                        break;

                    case 0:
                        System.out.println("Exiting application...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                choice = -1;
            }

        } while (choice != 0);

        input.close();
    }
}
