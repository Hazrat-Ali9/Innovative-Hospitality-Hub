package sample.fS;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
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
                        String a = reader.readLine();
                        String b = reader.readLine();

                        double d1 = Double.parseDouble(a);
                        double d2 = Double.parseDouble(b);

                        String res = (d1 + d2) + "\n";

                        history.append(a).append(" + ").append(b).append(" = ").append(res);

                        writer.write(res);
                        writer.flush();
                    } else if (data.equals("sub")) {
                        String a = reader.readLine();
                        String b = reader.readLine();

                        double d1 = Double.parseDouble(a);
                        double d2 = Double.parseDouble(b);

                        String res = (d1 - d2) + "\n";

                        history.append(a).append(" - ").append(b).append(" = ").append(res);

                        writer.write(res);
                        writer.flush();
                    } else if (data.equals("mult")) {
                        String a = reader.readLine();
                        String b = reader.readLine();

                        double d1 = Double.parseDouble(a);
                        double d2 = Double.parseDouble(b);

                        String res = (d1 * d2) + "\n";

                        history.append(a).append(" * ").append(b).append(" = ").append(res);

                        writer.write(res);
                        writer.flush();
                    } else if (data.equals("div")) {
                        String a = reader.readLine();
                        String b = reader.readLine();

                        double d1 = Double.parseDouble(a);
                        double d2 = Double.parseDouble(b);

                        String res = (d1 / d2) + "\n";

                        history.append(a).append(" / ").append(b).append(" = ").append(res);

                        writer.write(res);
                        writer.flush();
                    } else if (data.equals("history")) {
                        String curHistory = history.toString();
                        writer.write(curHistory + "<eof>\n");
                        writer.flush();
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
