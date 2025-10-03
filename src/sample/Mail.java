package sample;

import java.io.Serializable;
import java.util.Date;

public class Mail implements Serializable {
    private int id;
    private String Phn_num;
    private String subject;
    private String message;
    private Date date;

    public Mail(int id, String Phn_num, String subject, String message, Date date) {
        this.id = id;
        this.Phn_num = Phn_num;
        this.subject = subject;
        this.message = message;
        this.date = date;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getPhn_num() {
        return Phn_num;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setPhn_num(String Phn_num) {
        this.Phn_num = Phn_num;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Mail_Model{" +
                "id=" + id +
                ", Phn_num='" + Phn_num + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
