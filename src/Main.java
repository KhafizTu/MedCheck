
import classes.Department;
import classes.Doctor;
import classes.Hospital;
import classes.Patient;
import enums.Gender;


import service.impl.DepartmentServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.HospitalServiceImpl;
import service.impl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        PatientServiceImpl patientService = new PatientServiceImpl();
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();

        Doctor doctor1 = new Doctor(5L, "Max", "Maximov", Gender.MALE, 5);
        Doctor doctor2 = new Doctor(6L, "Igor", "Nekrasov", Gender.FEMALE, 7);
        Doctor doctor3 = new Doctor(7L, "Masha", "Vasilevna", Gender.FEMALE, 3);
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);

        Doctor doctor4 = new Doctor(1L, "Asan", "Akylov", Gender.MALE, 4);
        Doctor doctor5 = new Doctor(2L, "Kubanych", "Avazov", Gender.MALE, 5);
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

        Department department1 = new Department(1L, "Neurology", doctors);
        Department department2 = new Department(2L, "Cardeology", doctors2);
        List<Department> departments = new ArrayList<>();
        departments.add(department1);
        departments.add(department2);


        Hospital hospital1 = new Hospital(10L, "Vedanta", "Bishkek", departments, doctors2, patients1);
        Hospital hospital2 = new Hospital(20L, "EndoMed+", "Kara_Kol", departments, doctors2, patients2);
        Hospital hospital3 = new Hospital(30L, "Ал-Хаким", "Osh", departments, doctors2, patients3);

        Scanner scanner = new Scanner(System.in);
        while (true) {
        System.out.println("~~~~~Выберите команду~~~~~");
        System.out.println("""
                 1 - Hospital commands
                 2 - Patient commands
                 3 - Department commands
                 4 - Doctor commands""\");
                """);

            int scan = scanner.nextInt();
            switch (scan) {

                case 1:
                    while (true) {
                        hospitalCommands();
                        switch (scanner.nextInt()) {

                            case 1:
                                hospitalService.addHospital(hospital1);
                                hospitalService.addHospital(hospital2);
                                hospitalService.addHospital(hospital3);
                                break;
                            case 2:
                                hospitalService.getAllHospital();
                                break;
                            case 3:
                                System.out.print("Введите Hospital ID: ");
                                hospitalService.findHospitalById(scanner.nextLong());
                                break;
                            case 4:
                                hospitalService.deleteHospitalById(scanner.nextLong());
                                break;
                            case 5:
                                System.out.println("Введите Hospital Id: ");
                                hospitalService.getAllPatientFromHospital(scanner.nextLong());
                                break;
                            case 6:
                                System.out.println("Введите HospitalAddress: ");
                                hospitalService.getAllHospitalByAddress(scanner.next());
                        }
                    }
                case 2:
                    while (true) {
                        patientCommands();
                        switch (scanner.nextInt()) {

                            case 1:
                                System.out.println("Введите HospitalId ");
                                patientService.addPatientToHospital(scanner.nextLong(), patient1);
                                break;
                            case 2:
                                System.out.println("Введите HospitalId : ");
                                patientService.addPatientsToHospital(scanner.nextLong(), patients1);
                                break;
                            case 3:
                                System.out.println("Введите PatientId: ");
                                patientService.updatePatientById(scanner.nextLong(), patient2);
                                break;
                            case 4:
                                System.out.println("Введите PatientId которого хотите удалить: ");
                                patientService.removePatientById(scanner.nextLong());
                                break;
                            case 5:
                                System.out.println("Введите PatientId: ");
                                patientService.getPatientById(scanner.nextLong());
                                break;
                            case 6:
                                System.out.println("Введите PatientAge: ");
                                patientService.getPatientByAge(scanner.nextInt());
                                break;
                            case 7:
                                System.out.println("Введите по кокой части хотте сортировать - asc , desk");
                                patientService.sortPatientsByAge(scanner.next());
                        }
                    }
                case 3:
                    while (true) {
                        departmentsCommands();
                        switch (scanner.nextInt()) {
                            case 1:
                                departmentService.addDepartmentToHospital(30L, department1);
                                break;
                            case 2:
                                departmentService.getAllDepartmentByHospital(10L);
                                break;
                            case 3:
                                departmentService.findDepartmentByName(department2.getDepartmentName());
                                break;
                            case 4:
                                departmentService.deleteDepartmentById(2L);
                                break;
                            case 5:
                                departmentService.updateDepartmentById(1L, department2);

                        }
                    }
                case 4:
                    List<Long> longs = List.of(doctor1.getId(), doctor2.getId(), doctor3.getId(), doctor4.getId(), doctor5.getId());
                    while (true) {
                        doctorCommands();
                        switch (scanner.nextInt()) {
                            case 1:
                                doctorService.addDoctorToHospital(10L, doctor1);
                                break;
                            case 2:
                                doctorService.findDoctorById(20L);
                                break;
                            case 3:
                                doctorService.updateDoctor(10L, doctor5);
                                break;
                            case 4:
                                doctorService.deleteDoctorById(1L);
                                break;
                            case 5:
                                doctorService.assignDoctorToDepartment(department1.getId(), longs);
                                break;
                            case 6:
                                doctorService.getAllDoctorsByHospitalId(10L);
                                break;
                            case 7:
                                doctorService.getAllDoctorsByDepartmentId(1L);
                                break;
                        }
                    }
            }

        }


    }

    public static void departmentsCommands() {
        System.out.println("""
                ~~~~~~~~~~~~~~~ C O M M A N D S ~~~~~~~~~~~~~~~~~~
                    |----------------------------------------|
                    | Press 1 to add department              |
                    | Press 2 to get all department          |
                    | Press 3 to find by name department     |
                    | Press 4 to delete department by id     |
                    | Press 5 to update department by id     |
                    |----------------------------------------|
                ``````````````````````````````````````````````````
                """);
    }

    public static void hospitalCommands() {
        System.out.println("""
                 ~~~~~~~~~~~~~~~ C O M M A N D S ~~~~~~~~~~~~~~~~~~
                    |-------------------------------------------|
                    | Press 1 to add hospital                   |
                    | Press 2 to get all hospital               |
                    | Press 3 to find hospital by id            |
                    | Press 4 to delete hospital by id          |
                    | Press 5 to get all patient from hospital  |
                    | Press 6 to get all hospital by address    |
                    |-------------------------------------------|
                ``````````````````````````````````````````````````
                """);
    }

    public static void doctorCommands() {
        System.out.println("""
                  ~~~~~~~~~~~~~~~ C O M M A N D S ~~~~~~~~~~~~~~~~~~
                    |---------------------------------------------|
                    | Press 1 to add doctor                       |
                    | Press 2 to find doctor by id                |
                    | Press 3 to update doctor                    |
                    | Press 4 to delete doctor by id              |
                    | Press 5 to get assign doctor to department  |
                    | Press 6 to get all doctor by hospital-id    |
                    | Press 7 to get all doctor by department     |
                    |---------------------------------------------|
                `````````````````````````````````````````````````````
                """);
    }

    public static void patientCommands() {
        System.out.println("""
                  ~~~~~~~~~~~~~~~ C O M M A N D S ~~~~~~~~~~~~~~~~~~
                    |-------------------------------------------|
                    | Press 1 to add patient                    |
                    | Press 2 to add patients to hospital       |
                    | Press 3 to update patient by id           |
                    | Press 4 to delete patient by id           |
                    | Press 5 to find patient by id             |
                    | Press 6 to find patient by age            |
                    | Press 7 to sort patient by age            |
                    |-------------------------------------------|
                ``````````````````````````````````````````````````""");

    }
}