//Name: Pablo Conde 
//Email: pconde1@csudh.edu

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class DMV {
	//instance fields
    private String state;
    private List<Registration> registrations;
    private List<Citation> citations;
//create constructor
    public DMV(String state) {
        this.state = state;
        this.registrations = new ArrayList<>();
        this.citations = new ArrayList<>();
    }
//register
    public void registerVehicle(Owner[] owners, Vehicle vehicle, String plate) {
        // check for pending citations
        if (hasPendingCitations(vehicle)) {
            System.out.println("Vehicle has pending citations. Cannot register.");
            return;
        }

        // check for active registration
        if (hasActiveRegistration(vehicle)) {
            System.out.println("!Vehicle already has an active registration, cannot register!");
            return;
        }

        // create registration
        Registration registration = new Registration(generateUniqueID(),
        		new Date(), null, owners, vehicle, plate);
        registrations.add(registration);
        System.out.println("Vehicle registered successfully.");
        System.out.println("-------------------------------");
    }
//add citations
    public void registerCitation(Citation citation) {
        citations.add(citation);
        System.out.println("Citation registered successfully.");
        System.out.println("-------------------------------");
    }
//show registrations
    public void listRegistrations() {
        for (Registration registration : registrations) {
            System.out.println("Registration ID: " + registration.getUniqueID());
            System.out.println("Plate: " + registration.getPlate());
            System.out.println("State: " + state);
            System.out.println("Owners:");
            for (Owner owner : registration.getOwners()) {
                System.out.println("- " + owner.getFirstName() + " " + owner.getLastName());
            }
            System.out.println("Vehicle: " + registration.getVehicle().getMake() 
            		+ " " + registration.getVehicle().getModel());
            System.out.println("-------------------------------");
        }
    }
  //show citations
    public void listCitations() {
        for (Citation citation : citations) {
            System.out.println("Date: " + citation.getDate());
            System.out.println("Offence Code: " + citation.getOffenceCode());
            System.out.println("Amount: " + citation.getAmount());
            System.out.println("Status: " + citation.getStatus());
            System.out.println("Related Registration Plate: " 
            + citation.getRegistration().getPlate());
            System.out.println("-------------------------------");
        }
    }
//match plate for regist
    public Registration searchRegistrationByPlate(String plate) {
        for (Registration registration : registrations) {
            if (registration.getPlate().equals(plate)) {
                return registration;
            }
        }
        return null;
    }

    public Registration searchRegistrationByID(int id) {
        for (Registration registration : registrations) {
            if (registration.getUniqueID() == id) {
                return registration;
            }
        }
        return null;
    }
//regist. list
    public List<Registration> searchRegistrationByOwner(Owner owner) {
        List<Registration> ownerRegistrations = new ArrayList<>();
        for (Registration registration : registrations) {
            for (Owner regOwner : registration.getOwners()) {
                if (regOwner.equals(owner)) {
                    ownerRegistrations.add(registration);
                    break;
                }
            }
        }
        return ownerRegistrations;
    }
//citation list
    public List<Citation> searchCitationByOwner(Owner owner) {
        List<Citation> ownerCitations = new ArrayList<>();
        for (Citation citation : citations) {
            if (citation.getRegistration().getOwners()[0].equals(owner)) {
                ownerCitations.add(citation);
            }
        }
        return ownerCitations;
    }
//make ID
    private int generateUniqueID() {
        return (int) (Math.random() * 1000);
    }

    private boolean hasPendingCitations(Vehicle vehicle) {
        for (Citation citation : citations) {
            if (citation.getRegistration().getVehicle().equals(vehicle) 
            		&& citation.getStatus().equals("Pending")) {
                return true;
            }
        }
        return false;
    }

    private boolean hasActiveRegistration(Vehicle vehicle) {
        for (Registration registration : registrations) {
            if (registration.getVehicle().equals(vehicle) 
            		&& registration.getEndDate() == null) {
                return true;
            }
        }
        return false;
    }
}
