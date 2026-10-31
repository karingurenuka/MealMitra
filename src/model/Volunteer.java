package model;

public class Volunteer extends User {

    private String availability;

    public Volunteer(int userId, String name, String email,
                     String availability) {

        super(userId, name, email);
        this.availability = availability;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Welcome to Volunteer Dashboard!");
        System.out.println("Availability: " + availability);
        displayDetails();
    }

    public void collectDonation() {
        System.out.println(name + " can collect and deliver food.");
    }
}