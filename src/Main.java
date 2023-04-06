import classes.Department;
import classes.Doctor;
import classes.Hospital;
import classes.Patient;
import enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Patient patient1 = new Patient(1L, "Khafiz", "Turusbek uulu", 19, Gender.MALE);
        Patient patient2 = new Patient(2L, "Bekjan", "Jakanov", 18, Gender.MALE);
        Patient patient3 = new Patient(3L, "Argen", "Toktomatov", 17, Gender.MALE);
        List<Patient> patients1 = List.of(patient1, patient2, patient3);

        Patient patient4 = new Patient(4L, "Dastan", "Kalygulov", 17, Gender.MALE);
        Patient patient5 = new Patient(5L, "Aziza", "Abdykerimova", 17, Gender.FEMALE);
        Patient patient6 = new Patient(6L, "Yntymak", "Kasymbekov", 17, Gender.MALE);
        List<Patient> patients2 = List.of(patient4, patient5, patient6);

        Patient patient7 = new Patient(7L, "Ulukbek", "Bubetaev", 19, Gender.MALE);
        Patient patient8 = new Patient(8L, "Bekzat", "Jakanov", 16, Gender.MALE);
        Patient patient9 = new Patient(9L, "Baiaman", "Imanalyev", 16, Gender.MALE);
        List<Patient> patients3 = List.of(patient7, patient8, patient9);


    }
}