package dao.impl;

import classes.Department;
import classes.Doctor;
import classes.Hospital;
import dao.DoctorDao;
import database.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DoctorDaoImpl implements DoctorDao {

    DataBase dataBase = new DataBase(new  ArrayList<>());

    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        Hospital hospital = dataBase.getHospitals().stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (hospital == null) {
            return "Не найден такой госпиталь";
        }
        hospital.getDoctors().add(doctor);
        return "Добавлен";
    }


    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital d : dataBase.getHospitals()) {
            for (Doctor doctor : d.getDoctors()) {
                if (doctor.getId().equals(id)) {

                }
            }
        }
        return null;
    }


    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        for (Hospital f : dataBase.getHospitals()) {
            for (Doctor doctors : f.getDoctors()) {
                if (doctors.getId().equals(id)) {
                    doctors.setFirstname(doctor.getFirstname());
                    doctors.setLastname(doctor.getLastname());
                    doctors.setGender(doctor.getGender());
                    doctors.setExperienceYear(doctor.getExperienceYear());
                }


            }
        }
        return  "Обновлено";
    }

    @Override
    public void deleteDoctorById(Long id) {
        for (Hospital d:dataBase.getHospitals()){
            for (Doctor s:d.getDoctors()){
                if (s.getId().equals(id)){
                    d.getDoctors().remove(s);
                }
            }
        }
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        List<Doctor>doctors = new ArrayList<>();
        for (Hospital h:dataBase.getHospitals()) {
            for (Doctor d:h.getDoctors()) {
                for (Long l:doctorsId) {
                    if (d.getId().equals(l)){
                        doctors.add(d);
                    }
                }
            }
        }
        for (Hospital h:dataBase.getHospitals()) {
            for (Department d:h.getDepartments()) {
                if (d.getId().equals(departmentId)){
                    d.getDoctors().addAll(doctors);
                }
            }
        }
        return "Assigned!";    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        Hospital hospital1 =
                dataBase.getHospitals().stream().filter(hospital ->
                                hospital.getId().equals(id)).findAny()
                        .orElseThrow(()->new NoSuchElementException("Hету такого id"));
        return hospital1.getDoctors();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        List<Doctor> result = new ArrayList<>();
        for (Hospital hospital : dataBase.getHospitals()) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(id)) {
                    result.addAll(department.getDoctors());
                }
            }
        }
        return result;
    }
    }

