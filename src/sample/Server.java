package sample;

import java.io.*;
import java.net.*;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

    private static final int PORT = 11115;


    public static void Start(){
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started, waiting for connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());

                try {
                    Mail receivedMail = (Mail) ois.readObject();
                    System.out.println("Received mail: " + receivedMail.toString());


                    String phn_no = receivedMail.getPhn_num();
                    String subject = receivedMail.getSubject();
                    String text = receivedMail.getMessage();

                    storeMessageInDatabase(phn_no, subject,text);



                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                ois.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String [] args) {
        Start();
    }


    private static void storeMessageInDatabase(String phn_no, String subject, String text) {

        String filePath = "messages.csv";

        String id = Integer.toString(generate8DigitRandomNumber());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = dateFormat.format(new Date());

        try (FileWriter writer = new FileWriter(filePath, true)) {
            String entry = id + "," + phn_no + "," + subject + "," + text + "," + currentDate + "\n";

            writer.append(entry);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int generate8DigitRandomNumber() {
        Random random = new Random();
        int min = 10000000; // Smallest 8-digit number (10^7)
        int max = 99999999; // Largest 8-digit number (10^8 - 1)
        return random.nextInt(max - min + 1) + min;
    }

}
