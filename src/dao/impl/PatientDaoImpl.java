package dao.impl;

import classes.Hospital;
import classes.Patient;
import dao.PatientDao;
import database.DataBase;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class PatientDaoImpl implements PatientDao {
    DataBase dataBase = new DataBase(new ArrayList<>());

    @Override
    public String addPatientToHospital(Long id, Patient patient) {

        for (Hospital hospital : dataBase.getHospitals()) {
            if (hospital.getId() == id) {
                hospital.getPatients().add(patient);
                System.out.println("Successfully added patient");
            }
        }
        System.out.println("Successfully added patient");
        return "Successfully added patient";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital hospital : dataBase.getHospitals()) {
            if (hospital.getId() == id) {
                hospital.setPatients(patients);
                System.out.println("Successfully added patients");
            }
        }
        System.out.println("Successfully added patient");
        return "Successfully added patients";
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        for (Hospital hospital : dataBase.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == id) {
                    patient.setFirstName(patientsNewInfo.getFirstName());
                    patient.setLastName(patientsNewInfo.getLastName());
                    patient.setAge(patientsNewInfo.getAge());
                    patient.setGender(patientsNewInfo.getGender());
                    System.out.println("Successfully update patient");
                }
            }
        }
        System.out.println("Successfully update patient");
        return "Successfully update patient";
    }

    @Override
    public void removePatientById(Long id) {
        for (Hospital hospital : dataBase.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == id) {
                    hospital.getPatients().remove(patient);
                    System.out.println("Deleted successfully !");
                }else {
                    System.out.println("No command !");
                }
            }
        }
    }

    @Override
    public Patient getPatientById(Long id) {
        Patient patient1 = new Patient();
        for (Hospital hospital : dataBase.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == id) {
                    patient1 = patient;
                    System.out.println(patient1);
                }
            }
        }
        System.out.println(patient1);
        return patient1;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        Map<Integer, Patient> byGetAge = new HashMap<>();
        for (Hospital hospital : dataBase.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getAge() == age) {
                    byGetAge.put(age, patient);
                    System.out.println(byGetAge);
                } else {
                    System.out.println(age + "NO!! wrong");
                }
            }
        }
        System.out.println(byGetAge);
        return byGetAge;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = new ArrayList<>();
        Comparator<Patient> ageComparator = new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                if (ascOrDesc.equalsIgnoreCase("asc")) {
                    System.out.println(o1.getAge() - o2.getAge());
                    return o1.getAge() - o2.getAge();
                } else {
                    System.out.println(o2.getAge() - o1.getAge());
                    return o2.getAge() - o1.getAge();
                }
            }
        };

        Collections.sort(patients, ageComparator);
        System.out.println(patients);
        return patients;
    }

}