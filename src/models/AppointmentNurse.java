package models;
import java.util.Date;

public class AppointmentNurse implements Ischedulable {

    private int id;
    private Nurse nurse;
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

    public Nurse getNurse() {
        return this.nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
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
