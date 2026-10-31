package storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import model.Donation;

public class DonationStorage {

    private static final Path FILE_PATH =
            Paths.get("donations.txt");

    public void saveDonation(Donation donation) {

        String data = donation.getDonationId() + "," +
                      donation.getFoodName() + "," +
                      donation.getQuantity() + "," +
                      donation.getExpiryTime() + "," +
                      donation.getStatus() +
                      System.lineSeparator();

        try {
            Files.writeString(
                FILE_PATH,
                data,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );

            System.out.println("Donation saved to file!");

        } catch (IOException e) {
            System.out.println("Error saving donation: " + e.getMessage());
        }
    }

    public void readDonations() {

        try {
            if (Files.exists(FILE_PATH)) {
                String data = Files.readString(FILE_PATH);
                System.out.println("Saved Donations:");
                System.out.println(data);
            } else {
                System.out.println("No donation file found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public void saveAllDonations(java.util.List<Donation> donations) {
    for (Donation donation : donations) {
        saveDonation(donation);
    }
}
}