package ui;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import models.Doctor;
import models.Patient;

public class UIMenu {

    public static final String[] MONTHS = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    static Doctor doctorLogged;
    static Patient patientLogged;

    //Solicita al usuario que especifique si está registrado en el sistema.
    //Devuelve la selección del usuario como un entero.
    //1. Logearse.
    //2. Registrarse.
    //0. Salir.
    public static void enterSystem() {
        System.out.println("¡Bienvenido a DoctorsSystem!\n\nSeleccione una opción:\n1. Logearse.\n2. Registrarse.\n0. Salir.\n");
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            choice = Integer.valueOf(sc.nextLine());
            switch (choice) {
                case 1:
                    //Usuario desea loguearse
                    selectUserType();
                    if (doctorLogged != null) {
                        UIDoctorMenu.showDoctorMenu();
                    }
                    break;
                case 2:
                    //TODO registrar nuevo usuario.
                    //TODO showPatientMenu si loggedPatient no es null.
                    break;
                case 0:
                    break;
                default:
                    System.out.println("El número ingresado no es válido, reintente...\n\n");
                    break;
            }
            sc.close();
            break;
        } 
    }

    //Solicita al usuario identificarse como doctor o paciente.
    //Devuelve la elección del usuario.
    //1. Doctor.
    //2. Paciente.
    //0. Salir.
    private static void selectUserType() {
        Integer choice = 0;
        boolean cont = true;
        Scanner sc = new Scanner(System.in); 
        do {
            try {
                System.out.println("Identifícate:\n\n1. Soy un doctor.\n2. Soy un paciente.\n0. Salir.\n");
                choice = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException a) {
                System.out.println("La opción ingresada no es válida, reintente...");
            } catch (NoSuchElementException b) {
                System.out.println("Debe ingresar una opción, reintente...");
            } catch (IllegalStateException c) {
                System.out.println("La opción ingresada no es válida, reintente...");
            }
            switch (choice) {
                case 1:
                    //El usuario se identificó como doctor.
                    authUser(1);
                    cont = false;
                    break;
                case 2:
                    //El usuario se identificó como paciente.
                    authUser(2);
                    cont = false;
                    break;
                case 0:
                    //El usuario desea salir.
                    cont = false;
                    break;
                default:
                    System.out.println("La opción ingresada no es válida, reintente...");
                    break;
            }
        } while (cont);
        sc.close();
    }

    private static void showPatientMenu(){
        Integer choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("\n\n");
                System.out.println("Patient");
                System.out.println("1. Book an appointment");
                System.out.println("2. My appointments");
                System.out.println("0. Return");
                choice = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException a) {
                System.out.println("La opción ingresada no es válida, reintente...");
            } catch (NoSuchElementException b) {
                System.out.println("Debe ingresar una opción, reintente...");
            } catch (IllegalStateException c) {
                System.out.println("La opción ingresada no es válida, reintente...");
            }
            switch (choice){
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
                    break;
                default:
                    System.out.println("La opción ingresada no es válida, reintente...");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }

    //Si el email ingresado es válido, busca un doctor o paciente en la base de datos que tenga asignado el correo electrónico.
    //UserType 1 = Doctor
    //UserType 2 = Patient
    //Si hay una coincidencia, se solicita la contraseña.
    //Si no hay una coincidencia, muestra un mensaje "El correo electrónico ingresado no tiene una cuenta registrada. Reintente, o regístrese."
    private static void authUser(int userType) {
        String emailEntered = getValidEmail(); //Devuelve 0 si desea salir o un correo electrónico válido.
        if (!emailEntered.equals("0")) {
            switch(userType) {
                //Busca una cuenta de Doctor o Patient que contenga el correo electrónico especificado.
                //Si la encuentra, asigna la referencia a loggedDoctor o loggedPatient respectivamente. Si no la encuentra, el valor continúa en null.
                case 1:
                    List<Doctor> doctors = getDoctors();
                    for (Doctor doctor : doctors) {
                        if (emailEntered.equals(doctor.getEmail())) {
                            doctor.showWelcomeMessage();
                            doctorLogged = doctor;
                        }
                    }
                    if (doctorLogged == null) {
                        System.out.println("El correo electrónico ingresado no corresponde a una cuenta registrada, reintente.\n1. Crear una cuenta. \n0. Salir.");
                    }
                case 2:
                    List<Patient> patients = getPatients();
                    for (Patient pat : patients) {
                        if (emailEntered.equals(pat.getEmail())) {
                            pat.showWelcomeMessage();
                            patientLogged = pat;
                        }
                    }
                    if (patientLogged == null) {
                        System.out.println("El correo electrónico ingresado no corresponde a una cuenta registrada, reintente.\n1. Crear una cuenta. \n0. Salir.");
                    }
                }
            }
        }

    //Solicita una dirección de correo electrónico y la devuelve si es correcta. Si no lo es, solicita volver a intentar o salir.
    //Si la dirección de correo electrónico es válida, la devuelve.
    //Si la dirección de correo electrónico no es válida, vuelve a solicitarla.
    //Si el usuario selecciona salir, devuelve "0".
    private static String getValidEmail() {
        Scanner sc = new Scanner(System.in);
        String email = "";
        boolean stop = false;
        do {
            try {
                System.out.println("Ingrese su dirección de correo electrónico: \n0. Salir\n");
                email = sc.nextLine();
                if (email.contains("@") && email.endsWith(".com")) {
                    stop = true;
                    break;
                } else if (email.equals("0")) {
                    stop = true;
                    break;
                } else {
                    System.out.println("¡Error! Su email debe contener \"@\" y terminar con \".com\" reintente...");
                }
            } catch (Exception e) {
                System.out.println("Error.");
            }
        } while (!stop);
        sc.close();
        return email;
    }

    //Simula una petición a la base de datos para obtener los Doctores registrados.
    //Devuelve un List<User> de los objetos Doctor en la base de datos.
    private static List<Doctor> getDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Nacho","nacho.ElDocthorr@gmail.com"));
        doctors.add(new Doctor("Jean","jean.ElDocthorr@gmail.com"));
        doctors.add(new Doctor("Vale","vale.ElDocthorr@gmail.com"));
        return doctors;
    }

    //Simula una petición a la base de datos para obtener los Pacientes registrados.
    //Devuelve un List<User> de los objetos Patient en la base de datos.
    private static List<Patient> getPatients() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Daniel", "daniElPaciente@gmail.com"));
        patients.add(new Patient("Alejo", "alejoElPaciente@gmail.com"));
        patients.add(new Patient("Checho", "JuancitoElPaciente@gmail.com"));
        return patients;
    }

}