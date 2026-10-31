package model;

public class Donor extends User {

    private String organizationName;

    public Donor(int userId, String name, String email, String organizationName) {
        super(userId, name, email);
        this.organizationName = organizationName;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Welcome to Donor Dashboard!");
        System.out.println("Organization: " + organizationName);
        displayDetails();
    }

    public void donateFood() {
        System.out.println(name + " can donate surplus food.");
    }
}