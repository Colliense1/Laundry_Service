package com.example.colliensepodder.laundry.models;

public class Shop {
    String shopName;
    String phoneNumber;
    String address;
    String shirtCost;
    String pantCost;
    String blanketCost;
    String curtainCost;
    String email;

    public Shop(String shopName, String phoneNumber, String address, String shirtCost, String pantCost, String blanketCost, String curtainCost, String email) {
        this.shopName = shopName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.shirtCost = shirtCost;
        this.pantCost = pantCost;
        this.blanketCost = blanketCost;
        this.curtainCost = curtainCost;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Shop() {

    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShirtCost() {
        return shirtCost;
    }

    public void setShirtCost(String shirtCost) {
        this.shirtCost = shirtCost;
    }

    public String getPantCost() {
        return pantCost;
    }

    public void setPantCost(String pantCost) {
        this.pantCost = pantCost;
    }

    public String getBlanketCost() {
        return blanketCost;
    }

    public void setBlanketCost(String blanketCost) {
        this.blanketCost = blanketCost;
    }

    public String getCurtainCost() {
        return curtainCost;
    }

    public void setCurtainCost(String curtainCost) {
        this.curtainCost = curtainCost;
    }
}
