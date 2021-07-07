import static ui.UIMenu.*;
import java.util.Date;

import models.Doctor;
import models.Patient;
public class App {
    public static void main(String[] args) throws Exception {

        Doctor doc = new Doctor("Ignacio Cassi","Otorrinolargingólogo");
        doc.addAvailableAppointment(new Date(), "9:30");
        doc.addAvailableAppointment(new Date(), "10:30");
        doc.addAvailableAppointment(new Date(), "11:30");
        //doc.showId();
        //doc.showAvailableAppointments();
        Doctor doc2 = new Doctor("Ignacio Cassi","Otorrinolargingólogo");
        //doc2.showId();
        Patient pat = new Patient("Daniel Cassi", "nacho.cassi97@gmail.com");
        System.out.println(doc);
        
        

    }
}
