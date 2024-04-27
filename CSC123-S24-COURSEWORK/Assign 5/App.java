//Name: Pablo Conde 
//Email: pconde1@csudh.edu

import java.util.*;

public class App {
    private static Library library = new Library();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    newMembership();
                    break;
                case 2:
                    addMaterial();
                    break;
                case 3:
                    issueItem();
                    break;
                case 4:
                    returnItem();
                    break;
                case 5:
                    reportInventory();
                    break;
                case 6:
                    reportLoans();
                    break;
                case 7:
                    lookupMembership();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                    break;
            }
        } while (choice != 8);

        scan.close();
    }

    private static void printMenu() {
        System.out.println("\n1 – New Membership");
        System.out.println("2 – Add Material");
        System.out.println("3 – Issue Item");
        System.out.println("4 – Return Item");
        System.out.println("5 – Report Inventory");
        System.out.println("6 – Report Loans");
        System.out.println("7 – Lookup Membership");
        System.out.println("8 – Exit");
        System.out.print("Please enter your choice(1-8): ");
    }

    private static void newMembership() {
        System.out.println("Enter member details:");

        System.out.print("First Name: ");
        String firstName = scan.nextLine();

        System.out.print("Last Name: ");
        String lastName = scan.nextLine();

        System.out.print("Date of Birth (MM/DD/YY): ");
        String dateOfBirth = scan.nextLine();

        System.out.print("City: ");
        String city = scan.nextLine();

        System.out.print("Zip code: ");
        String zipCode = scan.nextLine();

        System.out.print("Is this member a child? (true/false): ");
        boolean isChild = scan.nextBoolean();
        scan.nextLine(); 

        Member guardian = null;
        if (isChild) {
            System.out.println("Enter guardian details:");
            System.out.print("Guardian First Name: ");
            String guardianFirstName = scan.nextLine();

            System.out.print("Guardian Last Name: ");
            String guardianLastName = scan.nextLine();

            System.out.print("Guardian Date of Birth (MM/DD/YY): ");
            String guardianDateOfBirth = scan.nextLine();

            System.out.print("Guardian City: ");
            String guardianCity = scan.nextLine();

            System.out.print("Guardian Zip code: ");
            String guardianZipCode = scan.nextLine();

            guardian = new Member(0, guardianFirstName, guardianLastName, guardianDateOfBirth, guardianCity, guardianZipCode, false, null);
        }

        int membershipNumber = generateMembershipNumber();
        Member newMember = new Member(membershipNumber, firstName, lastName, dateOfBirth, city, zipCode, isChild, guardian);
        library.addMember(newMember);

        System.out.println("New membership created successfully. Membership number: " + membershipNumber);
    }

    private static int generateMembershipNumber() {
        return new Random().nextInt(10000) + 1000;
    }

    private static void addMaterial() {
        System.out.println("-Enter material details-");

        System.out.print("Item Reference(ex.0000): ");
        int itemReference = scan.nextInt();
        scan.nextLine(); 

        System.out.print("Title: ");
        String title = scan.nextLine();

        System.out.print("Replacement Value(ex.2.99): ");
        double replacementValue = scan.nextDouble();
        scan.nextLine(); 

        System.out.print("Location (shelf id.location)(ex.11.1): ");
        String location = scan.nextLine();

        System.out.print("Is the material suitable for children? (true/false): ");
        boolean isSuitableForChildren = scan.nextBoolean();
        scan.nextLine(); 

        System.out.print("Material Type (1 - Book, 2 - Magazine, 3 - DVD): ");
        int materialType = scan.nextInt();
        scan.nextLine(); 

        Material material;

        switch (materialType) {
            case 1:
                System.out.print("Author: ");
                String author = scan.nextLine();

                System.out.print("ISBN: ");
                String isbn = scan.nextLine();

                System.out.print("Number of Pages: ");
                int numberOfPages = scan.nextInt();
                scan.nextLine(); 

                material = new Book(itemReference, title, replacementValue, location, isSuitableForChildren, author, isbn, numberOfPages);
                break;
            case 2:
                System.out.print("Publication Date (month/year): ");
                String publicationDate = scan.nextLine();

                System.out.print("Issue Number: ");
                int issueNumber = scan.nextInt();
                scan.nextLine(); 

                material = new Magazine(itemReference, title, replacementValue, location, isSuitableForChildren, publicationDate, issueNumber);
                break;
            case 3:
                System.out.print("Release Date: ");
                String releaseDate = scan.nextLine();

                System.out.print("Duration in minutes: ");
                int durationMinutes = scan.nextInt();
                scan.nextLine(); 

                material = new DVD(itemReference, title, replacementValue, location, isSuitableForChildren, releaseDate, durationMinutes);
                break;
            default:
                System.out.println("Invalid material type.");
                return;
        }

        library.addMaterial(material);
        System.out.println("Material added successfully.");
    }

    private static void issueItem() {
        System.out.print("Enter membership number: ");
        int membershipNumber = scan.nextInt();

        System.out.print("Enter item reference: ");
        int itemReference = scan.nextInt();

        library.issueItem(membershipNumber, itemReference);
    }

    private static void returnItem() {
        System.out.print("Enter item reference: ");
        int itemReference = scan.nextInt();

        library.returnItem(itemReference);
    }

    private static void reportInventory() {
        System.out.println("Inventory Report:");
        library.reportInventory();
    }

    private static void reportLoans() {
        System.out.println("Loans Report:");
        library.reportLoans();
    }

    private static void lookupMembership() {
        System.out.print("Enter membership number: ");
        int membershipNumber = scan.nextInt();

        library.lookupMembership(membershipNumber);
    }
}
