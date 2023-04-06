
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
    public static void main(String[] args) throws Exception{
        DoctorServiceImpl doctorService=new DoctorServiceImpl();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        PatientServiceImpl patientService = new PatientServiceImpl();
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();

        Doctor doctor1 = new Doctor(5L, "Max", "Maximov",  Gender.MALE,5);
        Doctor doctor2 = new Doctor(6L, "Igor", "Nekrasov",   Gender.FEMALE,7);
        Doctor doctor3 = new Doctor(7L, "Masha", "Vasilevna",  Gender.FEMALE,3);
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



        while (true) {
            System.out.println("""
            Welcome !
            1 - Hospital commands
            2 - Patient commands
            3 - Department commands
            4 - Doctor commands""");
            int i = new Scanner(System.in).nextInt();
            switch (i) {
                case 1 -> {
                    hospitalCommands();
                    int h = new Scanner(System.in).nextInt();
                    switch (h) {
                        case 1 -> {
                            System.out.println(hospitalService.addHospital(hospital1));
                            System.out.println(hospitalService.addHospital(hospital2));
                            System.out.println(hospitalService.addHospital(hospital3));
                        }
                        case 2 -> System.out.println(hospitalService.getAllHospital());
                        case 3 -> {
                            System.out.println("Enter hospital id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(hospitalService.findHospitalById(id));
                        }
                        case 4 -> {
                            System.out.println("Enter hospital id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(hospitalService.deleteHospitalById(id));
                        }
                        case 5 -> {
                            System.out.println("Enter hospital id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(hospitalService.getAllPatientFromHospital(id));;
                        }
                        case 6 -> {
                            System.out.println("Enter hospital address: ");
                            String address = new Scanner(System.in).nextLine();
                            System.out.println(hospitalService.getAllHospitalByAddress(address));
                        }
                        default -> System.out.println("Такой команды нет!");
                    }
                }
                case 2 -> {
                    patientCommands();
                    int p = new Scanner(System.in).nextInt();
                    switch (p) {
                        case 1 -> {
                            System.out.println("Enter Hospital id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(patientService.addPatientToHospital(id, patient1));
                        }
                        case 2 -> {
                            System.out.println("Enter hospital id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(patientService.addPatientsToHospital(id, patients1));
                            System.out.println(patientService.addPatientsToHospital(id, patients2));
                            System.out.println(patientService.addPatientsToHospital(id, patients3));
                        }
                        case 3 -> {
                            System.out.println("Enter hospital id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(patientService.updatePatientById(id, patient1));
                        }
                        case 4 -> {
                            System.out.println("Enter patient id: ");
                            Long id = new Scanner(System.in).nextLong();
                            patientService.removePatientById(id);
                        }
                        case 5 -> {
                            System.out.println("Enter patient id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(patientService.getPatientById(id));
                        }
                        case 6 -> {
                            System.out.println("Enter patient age: ");
                            int age = new Scanner(System.in).nextInt();
                            System.out.println(patientService.getPatientByAge(age));
                        }
                        case 7 -> {
                            System.out.println("Enter patient sort (asc or desc): ");
                            String ascOrDesc = new Scanner(System.in).nextLine();
                            System.out.println(patientService.sortPatientsByAge(ascOrDesc));
                        }
                        default -> System.out.println("Такой команды нет!");
                    }
                }
                case 3 -> {
                    departmentsCommands();
                    int d = new Scanner(System.in).nextInt();
                    switch (d) {
                        case 1 -> {
                            System.out.println("Enter hospital id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(departmentService.addDepartmentToHospital(id, department1));
                        }
                        case 2 -> {
                            System.out.println("Enter hospital id: ");
                            Long id = new Scanner(System.in).nextLong();
                            departmentService.getAllDepartmentByHospital(id).forEach(System.out::println);
                        }
                        case 3 -> {
                            System.out.println("Enter department name: ");
                            String name = new Scanner(System.in).nextLine();
                            System.out.println(departmentService.findDepartmentByName(name));
                        }
                        case 4 -> {
                            System.out.println("Enter department id: ");
                            Long id = new Scanner(System.in).nextLong();
                            departmentService.deleteDepartmentById(id);
                        }
                        case 5 -> {
                            System.out.println("Enter department id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(departmentService.updateDepartmentById(id, department1));
                        }
                        default -> System.out.println("Такой команды нет!");
                    }
                }
                case 4 -> {
                    doctorCommands();
                    int doc = new Scanner(System.in).nextInt();
                    switch (doc) {
                        case 1 -> {
                            System.out.println("Enter hospital id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(doctorService.addDoctorToHospital(id, doctor1));
                            System.out.println(doctorService.addDoctorToHospital(id, doctor2));
                            System.out.println(doctorService.addDoctorToHospital(id, doctor3));
                            System.out.println(doctorService.addDoctorToHospital(id, doctor4));
                            System.out.println(doctorService.addDoctorToHospital(id, doctor5));
                        }
                        case 2 -> {
                            System.out.println("Enter doctor id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(doctorService.findDoctorById(id));
                        }
                        case 3 -> {
                            System.out.println("Enter doctor id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(doctorService.updateDoctor(id, doctor1));
                        }
                        case 4 -> {
                            System.out.println("Enter doctor id: ");
                            Long id = new Scanner(System.in).nextLong();
                            doctorService.deleteDoctorById(id);
                        }
                        case 5 -> {
                            System.out.println("Enter department id: ");
                            Long departmentId = new Scanner(System.in).nextLong();
                            System.out.println("Enter List<Long> doctorsId: ");
                            List<Long> doctorsId = Collections.singletonList(new Scanner(System.in).nextLong());
                            System.out.println(doctorService.assignDoctorToDepartment(departmentId, doctorsId));
                        }
                        case 6 -> {
                            System.out.println("Enter hospital id: ");
                            Long id = new Scanner(System.in).nextLong();
                            System.out.println(doctorService.getAllDoctorsByHospitalId(id));
                        }
                        case 7 -> {
                            System.out.println("Enter hospital id: ");
                            Long departmentId = new Scanner(System.in).nextLong();
                            System.out.println(doctorService.getAllDoctorsByDepartmentId(departmentId));
                        }
                        default -> System.out.println("Такой команды нет!");
                    }
                }
                default -> System.out.println("Такой команды нет!");
            }
        }

    }
    public static void departmentsCommands(){
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

    public static void hospitalCommands(){
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

    public static void doctorCommands(){
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

    public static void patientCommands(){
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