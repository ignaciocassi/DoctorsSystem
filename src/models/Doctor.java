package models;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    private String speciality;

    public Doctor(String name, String email) {
        super(name,email);
    }

    public void showSpeciality() {
        if (speciality != null) {
            System.out.println("The doctor's speciality is: "+speciality+".");
        } else {
            System.out.println("This doctor has no speciality yet.");
        }
    }

    @Override
    public String toString() {
        return super.toString()+" Speciality: "+speciality+".\nAvailable"+AvailableAppointments.toString()+".";
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    ArrayList<AvailableAppointment> AvailableAppointments = new ArrayList<>();

    public void addAvailableAppointment(Date date, String time) {
        AvailableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }

    public void showAvailableAppointments() {
        for (AvailableAppointment availableAppointment : AvailableAppointments) {
            System.out.println("Appointment: Date: "+availableAppointment.getDate()+" Time: "+availableAppointment.getTime()+".");
        }
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return AvailableAppointments;
    }

    public static class AvailableAppointment {
        int id;
        Date date;
        String time;
        
        AvailableAppointment(Date date, String time) {
            this.date=date;
            this.time=time;
        }

        public Date getDate() {
            return this.date;
        }

        public void setDate(Date date) {
            this.date=date;
        }

        public String getTime() {
            return this.time;
        }

        public void setTime(String time) {
            this.time=time;
        }

        @Override
        public String toString() {
            return "Available appointments: "+date+" Time: "+time;
        }
    }

}
