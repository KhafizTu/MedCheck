package dao.impl;

import classes.Department;
import classes.Doctor;
import classes.Hospital;
import dao.DoctorDao;
import dao.exception.MyException;
import database.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DoctorDaoImpl implements DoctorDao {

    DataBase dataBase = new DataBase(new ArrayList<>());

    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        boolean is=true;
        for (Hospital h : dataBase.getHospitals()) {
            if (h.getId() == id) {
                is=true;
                dataBase.getDoctors().add(doctor);
                return "Добавлен!";
            }else {
                is=false;
            }
        }
        try{
            if(!is){
                throw new MyException("Не нашел");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public Doctor findDoctorById(Long id) {
        boolean is = true;
        for (Doctor d : dataBase.getDoctors()) {
            if (d.getId() == id) {
                is = true;
                return d;
            } else {
                is = false;
            }
            try {
                if (!is) {
                    throw new MyException("не нашел");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }


    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        boolean is = true;
        for (Doctor d : dataBase.getDoctors()) {
            if (d.getId() == id) {
                is = true;
                d.setFirstname(doctor.getFirstname());
                d.setLastname(doctor.getLastname());
                d.setExperienceYear(doctor.getExperienceYear());
                d.setGender(doctor.getGender());
                return "successfully update";
            } else {
                is = false;
            }
            try {
                if (!is) {
                    throw new MyException("Not found");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void deleteDoctorById(Long id) {
        boolean is = true;
        for (Doctor d : dataBase.getDoctors()) {
            if (d.getId() == id) {
                is = true;
                dataBase.getDoctors().remove(d);
                System.out.println("Удален");
            } else {
                is = false;
            }
            try {
                if (!is) {
                    throw new MyException("Не нашел");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
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
        return "Все норм!";    }

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

