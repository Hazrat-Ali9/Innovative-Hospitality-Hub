package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.control.Button;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class RequestInfo implements Initializable {
    @FXML
    private Button backBTN;
    @FXML
    private TableView<RoomBook_Model> requestInformation;

    @FXML
    private TableColumn<RoomBook_Model,String> colName;

    @FXML
    private TableColumn<RoomBook_Model,String> colEmail;

    @FXML
    private TableColumn<RoomBook_Model,String> colRoom;

    @FXML
    private TableColumn<RoomBook_Model,String> colDeposit;

    @FXML
    private TableColumn<RoomBook_Model,String> colDays;

    @FXML
    private TableColumn<RoomBook_Model,String> colStatus;

    ObservableList<RoomBook_Model> bookingList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colRoom.setCellValueFactory(new PropertyValueFactory<>("roomNum"));
        colDeposit.setCellValueFactory(new PropertyValueFactory<>("deposit"));
        colDays.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        loadBookingDataFromCSV();


        requestInformation.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        requestInformation.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println("Selected Booking: " + newSelection);
            }
        });
    }

    private void loadBookingDataFromCSV() {
        String csvFile = "customer_room_book_data.csv";
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                RoomBook_Model booking = new RoomBook_Model(data[0], data[1], data[2], data[3], data[4],
                        data[5], data[6], data[7], data[8], data[9]);
                bookingList.add(booking);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        requestInformation.setItems(bookingList);
    }


    @FXML
    private Button load;

    @FXML
    private Button accept;

    @FXML
    void funcLoadData(ActionEvent event) {
        bookingList.clear();
        loadBookingDataFromCSV();
    }


    @FXML
    void funcAccept(ActionEvent event) {
        updateStatusData("Active");
    }


    @FXML
    void rejectBtn(){
        updateStatusData("Rejected");
    }

    @FXML
    void removeBtn() {
        RoomBook_Model selectedBooking = requestInformation.getSelectionModel().getSelectedItem();

        if (selectedBooking != null) {
            String selectedEmail = selectedBooking.getEmail();

            List<RoomBook_Model> bookings = new ArrayList<>();
            String csvFile = "customer_room_book_data.csv";
            String line;
            String cvsSplitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(cvsSplitBy);
                    RoomBook_Model booking = new RoomBook_Model(data[0], data[1], data[2], data[3], data[4],
                            data[5], data[6], data[7], data[8], data[9]);
                    bookings.add(booking);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            bookings.removeIf(booking -> booking.getEmail().equals(selectedEmail));

            try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
                for (RoomBook_Model booking : bookings) {
                    writer.println(booking.getId() + "," + booking.getNumber() + "," + booking.getName() + "," +
                            booking.getEmail() + "," + booking.getCountry() + "," + booking.getRoomNum() + "," +
                            booking.getCheckIn() + "," + booking.getDeposit() + "," + booking.getGender() + "," +
                            booking.getStatus());
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            requestInformation.getItems().setAll(bookings);
        }
    }


    @FXML
    void backAction(ActionEvent event) throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("deshboard.fxml"));
        Stage RegStage=(Stage) backBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,595,365));
    }

    private void updateStatusData(String Data){
        RoomBook_Model selectedBooking = requestInformation.getSelectionModel().getSelectedItem();

        if (selectedBooking != null) {
            String selectedEmail = selectedBooking.getEmail();

            List<RoomBook_Model> bookings = new ArrayList<>();
            String csvFile = "customer_room_book_data.csv";
            String line;
            String cvsSplitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(cvsSplitBy);
                    RoomBook_Model booking = new RoomBook_Model(data[0], data[1], data[2], data[3], data[4],
                            data[5], data[6], data[7], data[8], data[9]);
                    bookings.add(booking);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }


            for (RoomBook_Model booking : bookings) {
                if (booking.getEmail().equals(selectedEmail)) {
                    booking.setStatus(Data);
                    break;
                }
            }


            try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
                for (RoomBook_Model booking : bookings) {
                    writer.println(booking.getId() + "," + booking.getNumber() + "," + booking.getName() + "," +
                            booking.getEmail() + "," + booking.getCountry() + "," + booking.getRoomNum() + "," +
                            booking.getCheckIn() + "," + booking.getDeposit() + "," + booking.getGender() + "," +
                            booking.getStatus());
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            requestInformation.getItems().setAll(bookings);
        }


    }
}

