
import classes.Department;
import classes.Doctor;
import classes.Hospital;
import classes.Patient;
import enums.Gender;


import dao.impl.DoctorDaoImpl;
import database.DataBase;
import service.DoctorService;
import service.impl.DepartmentServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.HospitalServiceImpl;
import service.impl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBase database = new DataBase();
        DoctorServiceImpl doctorService=new DoctorServiceImpl();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        PatientServiceImpl patientService = new PatientServiceImpl();
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();

        Doctor doctor1 = new Doctor(5l, "Max", "Maximov",  Gender.MALE,5);
        Doctor doctor2 = new Doctor(6l, "Igor", "Nekrasov",   Gender.FEMALE,7);
        Doctor doctor3 = new Doctor(7l, "Masha", "Vasilevna",  Gender.FEMALE,3);
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);

        Doctor doctor4 = new Doctor(1L, "Asan","Akylov",Gender.MALE, 4);
        Doctor doctor5 = new Doctor(2L, "Kubanych", "Avazov",Gender.MALE,5);
        List<Doctor> doctors2 = new ArrayList<>();
        doctors2.add(doctor4);
        doctors2.add(doctor5);

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

        Department department1 = new Department(1L, "Neurology",doctors);
        Department department2 = new Department(2L, "Cardeology",doctors2);
        List<Department>departments = new ArrayList<>();
        departments.add(department1);
        departments.add(department2);


        Hospital hospital1 = new Hospital(10L,"Vedanta","Bishkek",departments,doctors2,patients1);
        Hospital hospital2 = new Hospital(20L,"EndoMed+","Kara_Kol",departments,doctors2,patients2);
        Hospital hospital3 = new Hospital(30L,"Ал-Хаким","Osh",departments,doctors2,patients3);





    }
}