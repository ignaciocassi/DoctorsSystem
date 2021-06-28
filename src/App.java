import static ui.UIMenu.*;

public class App {
    public static void main(String[] args) throws Exception {
        Doctor doc = new Doctor("Ignacio Cassi","Otorrinolargingólogo");
        Patient pat = new Patient("Daniel Cassi", "nacho.cassi97@gmail.com");
        //showMenu();
        pat.setPhonenumber("23424354");
        pat.setWeight(54.0);
        pat.getWeightKg();
        

    }
}
