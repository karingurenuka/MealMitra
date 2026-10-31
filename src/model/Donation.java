package model;

public class Donation {

    private int donationId;
    private String foodName;
    private int quantity;
    private String expiryTime;
    private String status;

    public Donation(int donationId, String foodName,
                    int quantity, String expiryTime) {

        this.donationId = donationId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.expiryTime = expiryTime;
        this.status = "Available";
    }

    public int getDonationId() {
        return donationId;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayDonation() {
        System.out.println("Donation ID: " + donationId);
        System.out.println("Food Name: " + foodName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Expiry Time: " + expiryTime);
        System.out.println("Status: " + status);
    }
}