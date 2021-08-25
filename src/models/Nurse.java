package models;

public class Nurse extends User {

    private String speciality;

    public Nurse(String name, String email) {
        super(name, email);
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

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}