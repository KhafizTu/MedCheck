package dao.impl;

import classes.Hospital;
import classes.Patient;
import dao.PatientDao;
import database.DataBase;

import java.util.*;

public class PatientDaoImpl implements PatientDao {
    DataBase dataBase = new DataBase();

    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        for (Hospital hospital : dataBase.getHospitals()) {
            if (hospital.getId() == id) {
                hospital.getPatients().add(patient);
            }
        }
        return "Successfully added patient";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital hospital : dataBase.getHospitals()) {
            if (hospital.getId() == id) {
                hospital.setPatients(patients);
            }
        }
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
                }
            }
        }
        return "Successfully update patient";
    }

    @Override
    public void removePatientById(Long id) {
        for (Hospital hospital : dataBase.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == id) {
                    hospital.getPatients().remove(patient);
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
                }
            }
        }
        return patient1;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        Map<Integer, Patient> byGetAge = new HashMap<>();
        for (Hospital hospital : dataBase.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getAge() == age) {
                    byGetAge.put(age, patient);
                } else {
                    System.out.println(age + "NO!! wrong");
                }
            }
        }
        return byGetAge;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = new ArrayList<>();
        Comparator<Patient> ageComparator = new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                if (ascOrDesc.equalsIgnoreCase("asc")) {
                    return o1.getAge() - o2.getAge();
                } else {
                    return o2.getAge() - o1.getAge();
                }
            }
        };

        Collections.sort(patients, ageComparator);
        return patients;
    }

}