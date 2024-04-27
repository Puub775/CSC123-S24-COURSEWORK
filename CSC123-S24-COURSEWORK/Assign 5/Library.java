//Name: Pablo Conde 
//Email: pconde1@csudh.edu
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Material> catalogue;
    private Map<Integer, Member> members;

    public Library() {
        catalogue = new HashMap<>();
        members = new HashMap<>();
    }

    public void addMaterial(Material material) {
        catalogue.put(material.getItemReference(), material);
    }

    public void issueItem(int membershipNumber, int itemReference) {
        Member member = members.get(membershipNumber);
        Material material = catalogue.get(itemReference);

        if (member == null || material == null) {
            System.out.println("Invalid input.");
            return;
        }

        if (material instanceof Book && !member.isChild()) {
            issueMaterialToMember(member, (Book) material);
        } else if (material instanceof Magazine && !member.isChild()) {
            issueMaterialToMember(member, (Magazine) material);
        } else if (material instanceof DVD && !member.isChild()) {
            issueMaterialToMember(member, (DVD) material);
        } else if (material instanceof Book && member.isChild()) {
            System.out.println("Child member can only borrow children's books.");
        } else if (material instanceof Magazine && member.isChild()) {
            System.out.println("Child member can only borrow children's magazines.");
        } else if (material instanceof DVD && member.isChild()) {
            System.out.println("Child member can only borrow children's DVDs.");
        }
    }

    public void returnItem(int itemReference) {
        Material material = catalogue.get(itemReference);
        if (material != null) {
            
            System.out.println("Item returned successfully.");
        } else {
            System.out.println("Invalid item reference.");
        }
    }

    public void reportInventory() {
        System.out.println("Inventory Report:");
        for (Material material : catalogue.values()) {
            String itemType;
            if (material instanceof Book) {
                itemType = "Book";
            } else if (material instanceof Magazine) {
                itemType = "Magazine";
            } else {
                itemType = "DVD";
            }
            System.out.println("Item Reference: " + material.getItemReference() + ", Title: " + material.getTitle() + ", Type: " + itemType);
        }
    }

    public void reportLoans() {
        System.out.println("Loans Report:");
        // Iterate through loans and print details
    }

    public void lookupMembership(int membershipNumber) {
        Member member = members.get(membershipNumber);
        if (member != null) {
            System.out.println("Membership Details:");
            System.out.println("Membership Number: " + member.getMembershipNumber());
            System.out.println("First Name: " + member.getFirstName());
            System.out.println("Last Name: " + member.getLastName());
            System.out.println("Date of Birth: " + member.getDateOfBirth());
            System.out.println("City: " + member.getCity());
            System.out.println("Zip Code: " + member.getZipCode());
            System.out.println("Is Child: " + member.isChild());
            if (member.isChild()) {
                System.out.println("Guardian: " + member.getGuardian().getFirstName() + " " + member.getGuardian().getLastName());
            }
        } else {
            System.out.println("Membership not found.");
        }
    }

    public void addMember(Member newMember) {
        members.put(newMember.getMembershipNumber(), newMember);
    }

    private void issueMaterialToMember(Member member, Book book) {
        
        System.out.println("Book issued to member.");
    }

    private void issueMaterialToMember(Member member, Magazine magazine) {
       
        System.out.println("Magazine issued to member.");
    }

    private void issueMaterialToMember(Member member, DVD dvd) {
       
        System.out.println("DVD issued to member.");
    }
}
