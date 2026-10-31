
import java.util.Scanner;
import model.*;
import service.*;
import exception.*;
import notification.*;
import storage.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DonationService service = new DonationService();
        DonationStorage storage = new DonationStorage();

        int choice;

        do {
            System.out.println("\n===== SMART FOOD DONATION SYSTEM =====");
            System.out.println("1. Register Donor");
            System.out.println("2. Register NGO");
            System.out.println("3. Register Volunteer");
            System.out.println("4. Add Food Donation");
            System.out.println("5. View Donations");
            System.out.println("6. Accept Donation");
            System.out.println("7. Save Donations");
            System.out.println("8. Read Saved Donations");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Donor ID: ");
                    int donorId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String donorName = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String donorEmail = sc.nextLine();

                    System.out.print("Enter Organization Name: ");
                    String organization = sc.nextLine();

                    Donor donor = new Donor(
                        donorId, donorName, donorEmail, organization
                    );

                    donor.displayDashboard();
                    break;

                case 2:
                    System.out.print("Enter NGO ID: ");
                    int ngoId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String ngoUserName = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String ngoEmail = sc.nextLine();

                    System.out.print("Enter NGO Name: ");
                    String ngoName = sc.nextLine();

                    System.out.print("Enter Service Area: ");
                    String area = sc.nextLine();

                    NGO ngo = new NGO(
                        ngoId, ngoUserName, ngoEmail, ngoName, area
                    );

                    ngo.displayDashboard();
                    break;

                case 3:
                    System.out.print("Enter Volunteer ID: ");
                    int volunteerId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String volunteerName = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String volunteerEmail = sc.nextLine();

                    System.out.print("Enter Availability: ");
                    String availability = sc.nextLine();

                    Volunteer volunteer = new Volunteer(
                        volunteerId, volunteerName,
                        volunteerEmail, availability
                    );

                    volunteer.displayDashboard();
                    break;

                case 4:
                    try {
                        System.out.print("Enter Donation ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Food Name: ");
                        String foodName = sc.nextLine();

                        System.out.print("Enter Quantity: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Expiry Time: ");
                        String expiry = sc.nextLine();

                        Donation donation = new Donation(
                            id, foodName, quantity, expiry
                        );

                        service.validateDonation(donation);
                        service.addDonation(donation);

                    } catch (InvalidDonationException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Please enter a valid number.");
                        sc.nextLine();
                    }
                    break;

                case 5:
                    service.viewDonations();
                    break;

                case 6:
                    System.out.print("Enter Donation ID to accept: ");
                    int acceptId = sc.nextInt();
                    sc.nextLine();

                    service.acceptDonation(acceptId);

                    NotificationThread thread =
                        new NotificationThread(
                            "Donation acceptance request processed."
                        );

                    thread.start();
                    break;

                case 7:
                    storage.saveAllDonations(service.getDonations());
                    break;

                case 8:
                    storage.readDonations();
                    break;

                case 9:
                    System.out.println("Thank you for using our system!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 9);

        sc.close();
    }
}
