package dao.impl;

import classes.Patient;
import dao.PatientDao;

import java.util.List;
import java.util.Map;

public class PatientDaoImpl implements PatientDao {
    @Override
    public String addPatientToHospital(Long id, Patient patient) {

        return null;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return null;
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        return null;
    }

    @Override
    public void removePatientById(Long id) {

    }

    @Override
    public Patient getPatientById(Long id) {
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return null;
    }
}