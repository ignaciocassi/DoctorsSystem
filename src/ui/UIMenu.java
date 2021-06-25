package ui;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    public static void showMenu() {
        Integer choice;
        System.out.println("Welcome to DoctorsSystem!");
        System.out.println("Input an option to continue:");
        System.out.println("");
        System.out.println("Input '1' if you are a doctor:");
        System.out.println("Input '2' if you are a patient:");
        System.out.println("Input '0' to quit:");
        Scanner sc = new Scanner(System.in);
        choice = 0;
        do {
            while (true) {
                try {
                    choice=Integer.valueOf(sc.nextLine());
                    break;
                } catch (NumberFormatException a) {
                    System.out.println("NumberFormatException");
                } catch (NoSuchElementException b) {
                    System.out.println("NoSuchElementException");
                } catch (IllegalStateException c) {
                    System.out.println("IllegalStateException");
                }
            }
            switch (choice) {
                case 1:
                    System.out.println("Doctor");
                    choice = 0;
                    break;
                case 2:
                    System.out.println("Patient");
                    showPatientMenu();
                    choice = 0;
                    break;
                case 0:
                    System.out.println("Quit");
                    break;
                default:
                    System.out.println("Input not recognized.");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }

    public static void showPatientMenu(){
        Integer response;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            
            response=Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < MONTHS.length; i++) {
                        
                        System.out.println(i+1+". "+MONTHS[i]+".");
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
        sc.close();
    }
}

