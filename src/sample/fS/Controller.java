package sample.fS;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class Controller {
    @FXML
    TextField inputA;

    @FXML
    TextField inputB;

    @FXML
    TextArea resultTA;

    BufferedReader reader;
    BufferedWriter writer;

    public Controller(){
        try {
            Socket socket = new Socket("127.0.0.1", 5678);

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void addFunction(){
        String a = inputA.getText();
        String b = inputB.getText();

        try{
            Double.parseDouble(a);
            Double.parseDouble(b);

            writer.write("add\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.flush();

            String res = reader.readLine();
            resultTA.setText(res);

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void subFunction(){
        String a = inputA.getText();
        String b = inputB.getText();

        try{
            Double.parseDouble(a);
            Double.parseDouble(b);

            writer.write("sub\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.flush();

            String res = reader.readLine();
            resultTA.setText(res);

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void multFunction(){
        String a = inputA.getText();
        String b = inputB.getText();

        try{
            Double.parseDouble(a);
            Double.parseDouble(b);

            writer.write("mult\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.flush();

            String res = reader.readLine();
            resultTA.setText(res);

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void divFunction(){
        String a = inputA.getText();
        String b = inputB.getText();

        try{
            Double.parseDouble(a);
            Double.parseDouble(b);

            writer.write("div\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.flush();

            String res = reader.readLine();
            resultTA.setText(res);

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void historyFunction(){
        try{
            writer.write("history\n");
            writer.flush();

            String line;
            resultTA.setText("");
            while((line = reader.readLine()) != null) {
                if(line.equals("<eof>")) break;
                resultTA.appendText(line + "\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}




























// public class Controller {
//    @FXML
//    TextField msgTextField;
//
//    @FXML
//    Button sendButton;
//
//    @FXML
//    TextArea allTextArea;
//
//    private BufferedWriter writer;
//    private BufferedReader reader;
//
//    public Controller(){
//        String myName = "Sakib";
//
//        try {
//            Socket socket = new Socket("127.0.0.1", 5000);
//
//            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
//            writer = new BufferedWriter(o);
//
//            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
//            reader = new BufferedReader(isr);
//
//            writer.write(myName + "\n");
//            writer.flush();
//
//            Thread t = new Thread(){
//                public void run(){
//                    try{
//                        String line = reader.readLine() + "\n";
//                        while (line != null){
//                            allTextArea.appendText(line);
//                            line = reader.readLine() + "\n";
//                        }
//                    }
//                    catch (IOException e){
//                        e.printStackTrace();
//                    }
//                }
//            };
//            t.start();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    void msgSend(){
//        try {
//            String msg = msgTextField.getText() + "\n";
//            msgTextField.setText("");
//            writer.write(msg);
//            writer.flush();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//}
