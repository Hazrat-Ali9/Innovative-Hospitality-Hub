package sample;

import java.sql.ResultSet;
public class RoomTable {
    String room_number,availability,clean_status,price,bed_type;

    public RoomTable(String room_number, String availability, String clean_status, String price, String bed_type) {
        this.room_number = room_number;
        this.availability = availability;
        this.clean_status = clean_status;
        this.price = price;
        this.bed_type = bed_type;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getClean_status() {
        return clean_status;
    }

    public void setClean_status(String clean_status) {
        this.clean_status = clean_status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBed_type() {
        return bed_type;
    }

    public void setBed_type(String bed_type) {
        this.bed_type = bed_type;
    }
}
