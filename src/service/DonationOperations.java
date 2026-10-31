package service;

import model.Donation;

public interface DonationOperations {

    void addDonation(Donation donation);

    void viewDonations();

    void acceptDonation(int donationId);
}