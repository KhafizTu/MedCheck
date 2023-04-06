package service.impl;

import classes.Doctor;
import dao.impl.DoctorDaoImpl;
import service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    DoctorDaoImpl doctorDao = new DoctorDaoImpl();
    @Override
    public String addDoctorToHospital(Long id, Doctor Doctor) {
        return doctorDao.addDoctorToHospital(id, Doctor);
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorDao.findDoctorById(id);
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        return doctorDao.updateDoctor(id, doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorDao.deleteDoctorById(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return doctorDao.assignDoctorToDepartment(departmentId, doctorsId );
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return doctorDao.getAllDoctorsByDepartmentId(id);
    }
}
