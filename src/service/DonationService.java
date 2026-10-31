
package service;

import exception.InvalidDonationException;
import java.util.ArrayList;
import java.util.List;
import model.Donation;

public class DonationService implements DonationOperations {

    private List<Donation> donations = new ArrayList<>();

    @Override
    public void addDonation(Donation donation) {
        donations.add(donation);
        System.out.println("Donation added successfully!");
    }

    @Override
    public void viewDonations() {
        if (donations.isEmpty()) {
            System.out.println("No donations available.");
            return;
        }

        for (Donation donation : donations) {
            donation.displayDonation();
            System.out.println("--------------------");
        }
    }

    @Override
    public void acceptDonation(int donationId) {
        for (Donation donation : donations) {
            if (donation.getDonationId() == donationId
                    && donation.getStatus().equals("Available")) {

                donation.setStatus("Accepted");
                System.out.println("Donation accepted successfully!");
                return;
            }
        }

        System.out.println("Donation not found or already accepted.");
    }

    public void validateDonation(Donation donation)
            throws InvalidDonationException {

        if (donation.getQuantity() <= 0) {
            throw new InvalidDonationException(
                "Donation quantity must be greater than zero."
            );
        }
    }

    public List<Donation> getDonations() {
        return donations;
    }
}
