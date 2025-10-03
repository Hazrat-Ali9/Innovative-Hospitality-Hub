package sample;

import java.sql.ResultSet;

public class ModelTableBooking {

    String name,email,room,deposit,days,status;

    public ModelTableBooking(String name, String email, String room, String deposit, String days, String status) {
        this.name = name;
        this.email = email;
        this.room = room;
        this.deposit = deposit;
        this.days = days;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



