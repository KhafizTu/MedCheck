package service.impl;

import classes.Hospital;
import classes.Patient;
import dao.PatientDao;
import dao.impl.PatientDaoImpl;
import service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {
    PatientDao dao = new PatientDaoImpl();


    @Override
    public String addPatientToHospital(Long id, Patient patient) {
            return dao.addPatientToHospital(id,patient);
        }


    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return dao.addPatientsToHospital(id,patients);
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        return dao.updatePatientById(id,patientsNewInfo);
    }

    @Override
    public void removePatientById(Long id) {
        dao.removePatientById(id);
    }

    @Override
    public Patient getPatientById(Long id) {
        return dao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        return dao.getPatientByAge(age);
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return dao.sortPatientsByAge(ascOrDesc);
    }
}
