package model;

public class NGO extends User {

    private String ngoName;
    private String serviceArea;

    public NGO(int userId, String name, String email,
               String ngoName, String serviceArea) {
        super(userId, name, email);
        this.ngoName = ngoName;
        this.serviceArea = serviceArea;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Welcome to NGO Dashboard!");
        System.out.println("NGO Name: " + ngoName);
        System.out.println("Service Area: " + serviceArea);
        displayDetails();
    }

    public void acceptDonation() {
        System.out.println(ngoName + " can accept food donations.");
    }
}