import classes.Doctor;
import dao.impl.DoctorDaoImpl;
import database.DataBase;
import enums.Gender;
import service.DoctorService;
import service.impl.DoctorServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBase database = new DataBase();
        DoctorServiceImpl doctorService=new DoctorServiceImpl();

        Doctor doctor1 = new Doctor(5l, "Max", "Maximov",  Gender.MALE,5);
        Doctor doctor2 = new Doctor(6l, "Igor", "Nekrasov",   Gender.FEMALE,7);
        Doctor doctor3 = new Doctor(7l, "Masha", "Vasilevna",  Gender.FEMALE,3);
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);



    }
}