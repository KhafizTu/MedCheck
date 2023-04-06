package dao.impl;

import classes.Department;
import classes.Hospital;
import dao.DepartmentDao;
import dao.exception.MyException;
import dao.exception.NotFoundException;
import database.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentDaoImpl implements DepartmentDao {
    DataBase dataBase = new DataBase();

    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        try {
            for (Hospital hospital : dataBase.getHospitals()) {
                if (Objects.equals(hospital.getId(), id)) {
                    hospital.getDepartments().add(department);
                } else {
                    throw new NotFoundException("This department NOT FOUND!");
                }
            }
        }catch (NotFoundException e){
            System.out.println(e.getMessage());

        }
        return null;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        try {
            for (Hospital hospital : dataBase.getHospitals()) {
                if (Objects.equals(hospital.getId(), id)) {
                    return hospital.getDepartments();
                } else {
                    throw new NotFoundException("This department NOT FOUND!");
                }
            }
        }catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        Department department = new Department();
        for (Hospital hospital : dataBase.getHospitals()){
            for (Department department1 : hospital.getDepartments()){
                if (department.getDepartmentName().equals(name.toLowerCase())){
                    department = department1;
                    return department;
                }else {
                    throw new NotFoundException("This department NOT FOUND!");
                }
            }
        }
        return null;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        for (Hospital hospital : dataBase.getHospitals()) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(id)) {
                    hospital.getDepartments().remove(department);
                    System.out.println("\nDepartment successfully deleted!\n");
                } else {
                    throw new NotFoundException("This department NOT FOUND!");
                }
            }
        }
    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        try {
            for (Hospital hospital : dataBase.getHospitals()) {
                for (Department department1 : hospital.getDepartments()) {
                    if (department.getId().equals(id)) {
                        department1.setDepartmentName(department.getDepartmentName());
                        department1.setDoctors(department.getDoctors());
                    } else {
                        throw new NotFoundException("This department NOT FOUND!");
                    }
                }
            }
        }catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
        return "Department successfully updated!";
    }
}
