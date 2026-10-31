package model;

public class Admin extends User {

    public Admin(int userId, String name, String email) {
        super(userId, name, email);
    }

    @Override
    public void displayDashboard() {
        System.out.println("Welcome to Admin Dashboard!");
        displayDetails();
    }

    public void manageDonations() {
        System.out.println("Admin can manage all food donations.");
    }
}