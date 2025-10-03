package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class socketCls implements Runnable {
    @Override
    public void run() {

        try{
            ServerSocket serverSocket = new ServerSocket(5678);
            Socket socket = serverSocket.accept();
            System.out.println("Connected.");

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            String data;
            StringBuilder history = new StringBuilder();
            while ((data = reader.readLine()) != null){
                try {
                    if (data.equals("add")) {
                        String name = reader.readLine();
                        String email = reader.readLine();

                        String id = reader.readLine();
                        String deposit = reader.readLine();

                        String days=reader.readLine();

                        String res ="Wait for admin response.."+"\n";
                        writer.write(res);
                        writer.flush();

                        DatabaseConnection connectNow= new DatabaseConnection();
                        Connection connectDB=connectNow.getConnection();
                        String p="accept";
                        String insertFields = "INSERT INTO booking(name ,email,room,deposit,days,status) VALUES('";
                        String insertValues = name + "','" + email + "','" + id + "','" + deposit + "','" +days+ "','" +"pending"+"')";
                        String insertToRegister = insertFields + insertValues;

                        // String query= "SELECT status FROM booking where email='"email"'";
                        String verifyLogin= "Select count(1) From booking WHERE status= '" + p+ "'AND email ='"+email + "'";
                        try {
                            Statement statement = connectDB.createStatement();
                            statement.executeUpdate(insertToRegister);
                            ResultSet rs=statement.executeQuery(verifyLogin);


                           /* if (rs.next()==true && rs.getInt(1)==1){

                                writer.write("accepted your request"+"\n");
                                writer.flush();
                            }*/

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            writer.close();
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}



















//  try {
//            ServerSocket server = new ServerSocket(5000);
//            ArrayList<Client> clients = new ArrayList<>();
//
//            while (true) {
//                try {
//                    Socket socket = server.accept();
//                    Client client = new Client(socket, clients);
//                    clients.add(client);
//                    Thread clientThread = new Thread(client);
//                    clientThread.start();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
