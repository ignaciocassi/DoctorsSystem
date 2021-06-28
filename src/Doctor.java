public class Doctor {

    private static Integer id = 0; //Autoincrement
    private String name;
    private String speciality;

    public Doctor(String name, String speciality) {
        id++;
        this.name=name;
        this.speciality=speciality;
    }

    public void showSpeciality() {
        if (speciality != null) {
            System.out.println("The doctor's speciality is: "+speciality+".");
        } else {
            System.out.println("This doctor has no speciality yet.");
        }
    }

    public void showName() {
        if (name != null) {
            System.out.println("The doctor's name is: "+name+".");
        } else {
            System.out.println("This doctor has no name yet.");
        }
    }

    public void showId() {
        if (id != null) {
            System.out.println("The doctor's id is: "+id+".");
        } else {
            System.out.println("This doctor has no id. (Hasn't been initializaded.)");
        }
    }
}
