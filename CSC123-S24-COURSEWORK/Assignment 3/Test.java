import java.util.Date;
public class Test {
	public static void main(String[] args) {
        // create a DMV 
        DMV dmv = new DMV("California");

        // create owners
        Owner owner1 = new Owner("Evil", "Doo", "56th St", 
        		"Watts", "CA", "12671");
        Owner owner2 = new Owner("Jimmy", "Cooper", "45th St",
        		"San Fransisco", "CA", "34589");

        // create vehicles
        Vehicle vehicle1 = new Vehicle("VIN165748992",
        		new Date(), "Toyota", "Ae86", "White", 4);
        Vehicle vehicle2 = new Vehicle("VIN209472850", 
        		new Date(), "Honda", "Civic", "Red", 4);

        // input vehicle1
        System.out.println("Registering Vehicle 1");
        dmv.registerVehicle(new Owner[]{owner1}, vehicle1, "GFH354");

        // test to see if registration is active
        System.out.println(" \nTrying to register Vehicle 1 again ");
        dmv.registerVehicle(new Owner[]{owner1}, vehicle1, "GMK198");

        // make citation1
        Registration registration1 = dmv.searchRegistrationByPlate("GFH354");
        if (registration1 != null) {
            Citation citation1 = new Citation(new Date(), 193, 150.0,
            		"Pending", registration1);
            dmv.registerCitation(citation1);
        }

        // input vehicle2
        System.out.println("\nRegistering Vehicle 2");
        dmv.registerVehicle(new Owner[]{owner2}, vehicle2, "GNK196");

        // make citation
        Registration registration2 = dmv.searchRegistrationByPlate("GNK196");
        if (registration2 != null) {
            Citation citation2 = new Citation(new Date(), 476, 200.0,
            		"Pending", registration2);
            dmv.registerCitation(citation2);
        }

        // show registrations
        System.out.println("\nList of Registrations:");
        dmv.listRegistrations();
        System.out.println();

        // show citations
        System.out.println("\nList of Citations:");
        dmv.listCitations();
    }
}