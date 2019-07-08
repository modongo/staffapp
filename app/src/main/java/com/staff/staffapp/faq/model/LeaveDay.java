package com.staff.staffapp.faq.model;

public class LeaveDay {
    int id;
    String type;
    String staff;
    int entitled;
    int carryover;
    int taken;
    int balance;

    public LeaveDay(){}

    public LeaveDay(int id, String type, String staff, int entitled, int carryover, int taken, int balance){
        this.id = id;
        this.type = type;
        this.staff = staff;
        this.entitled = entitled;
        this.carryover = carryover;
        this.taken = taken;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getStaff() {
        return staff;
    }

    public int getEntitled() {
        return entitled;
    }

    public int getCarryover() {
        return carryover;
    }

    public int getTaken() {
        return taken;
    }

    public int getBalance() {
        return balance;
    }
}
