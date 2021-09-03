package models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Doctor extends User {

    private String speciality;

    public Doctor(String name, String email) {
        super(name,email);
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado Hospital Municipal.");
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

    List<AvailableAppointment> AvailableAppointments = new ArrayList<>();
    public void addAvailableAppointment(String date, String time) {

        AvailableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }

    public void showAvailableAppointments() {
        for (AvailableAppointment availableAppointment : AvailableAppointments) {
            System.out.println("Appointment: Date: "+availableAppointment.getDate()+" Time: "+availableAppointment.getTime()+".");
        }
    }

    public List<AvailableAppointment> getAvailableAppointments() {
        return AvailableAppointments;
    }

    public static class AvailableAppointment {

        int id;
        Date date;
        String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        AvailableAppointment(String date, String time) {
            try {
                this.date=format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time=time;
        }

        public Date getDate() {
            return this.date;
        }

        public String getDate(String DATE) {
            return format.format(date);
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
