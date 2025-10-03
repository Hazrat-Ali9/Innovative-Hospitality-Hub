package sample;

import java.io.Serializable;

public class RoomBook_Model implements Serializable {
    private String id;
    private String number;
    private String name;
    private String email;
    private String country;
    private String roomNum;
    private String checkIn;
    private String deposit;
    private String gender;

    private String status;

    public RoomBook_Model(String id, String number, String name, String email, String country,
                    String roomNum, String checkIn, String deposit, String gender, String status) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.email = email;
        this.country = country;
        this.roomNum = roomNum;
        this.checkIn = checkIn;
        this.deposit = deposit;
        this.gender = gender;
        this.status = status;
    }

    // Setters and Getters for all attributes
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", checkIn='" + checkIn + '\'' +
                ", deposit='" + deposit + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
