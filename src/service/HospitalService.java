package service;

import classes.Hospital;
import dao.HospitalDao;

import java.util.List;
import java.util.Map;

public class HospitalService implements HospitalDao {

    @Override
    public String addHospital(Hospital hospital) {
        return null;
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return null;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        return null;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return null;
    }
}
