package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Doctor;

public class UIDoctorMenu {

    public static List<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu() {
        Integer response = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Hello Doctor! "+UIMenu.doctorLogged.getName()+".\n1. Add available appointment.\n2. View my scheduled appointments.\n0. Logout");
            response = sc.nextInt();
            switch (response) {
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Number not recognized, retry...\n");
            }
        } while (response != 0);
        sc.close();
    }

    private static void showAddAvailableAppointmentsMenu() {
        int response = 0;
        do {
            System.out.println("Add available appointment: \nSelect a Month:\n");
            for (int i = 0; i < 3; i++) {
                System.out.println(i+1+". "+UIMenu.MONTHS[i]+".");
            }
            System.out.println("0. Return.");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response >=1 && response <=3) {
                Integer monthSelected = response;
                System.out.println(monthSelected+"."+UIMenu.MONTHS[monthSelected]);

                System.out.println("Enter the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("The date you entered: "+date+"\n1.Confirm. \n2. Change date.\n0. Return.");
                Integer responseDate = Integer.valueOf(sc.nextLine());

                if (responseDate == 2) continue;
                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Enter the time available for this date: "+date+" [16:00]");
                    time = sc.nextLine();
                    System.out.println("The time you entered is: "+time+"\n1.Confirm. \n2. Change date.\n0. Return.");
                    responseTime = Integer.valueOf(sc.nextLine());
                } while (responseTime == 2);
                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);
            } else if (response == 0) {
                showDoctorMenu();
            }
        } while (response != 0);
        sc.close();
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor) {
        if (doctor.getAvailableAppointments().size()>0 && !doctorsAvailableAppointments.contains(doctor)) {
            doctorsAvailableAppointments.add(doctor);
        }
    }
    
}
