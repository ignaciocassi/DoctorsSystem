package models;
import java.util.Date;

public class AppointmentDoctor implements Ischedulable {

    private int id;
    private Doctor doctor;
    private Patient patient;
    private Date date;
    private String time;

    @Override
    public void schedule(Date date, String time) {
        // TODO Auto-generated method stub
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
