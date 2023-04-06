package dao.impl;

import classes.Department;
import classes.Hospital;
import dao.DepartmentDao;
import database.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentDaoImpl implements DepartmentDao {
    DataBase dataBase = new DataBase(new ArrayList<>());

    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        for (Hospital hospital : dataBase.getHospitals()){
            if (Objects.equals(hospital.getId(), id)){
                hospital.getDepartments().add(department);
            }else {
                System.out.println("Hospital id: "+id+" not found!");
            }
        }
        return null;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital hospital : dataBase.getHospitals()) {
            if (Objects.equals(hospital.getId(),id)) {
                return hospital.getDepartments();
            }else {
                System.out.println("Hospital id: "+id+" not found!");
            }
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
                    System.out.println("Department's name: "+name+" not found!");
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
                }else {
                    System.out.printf("This department id: "+id+" not found!");
                }
            }
        }
    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        for (Hospital hospital : dataBase.getHospitals()){
            for (Department department1: hospital.getDepartments()){
                if (department.getId().equals(id)){
                    department1.setDepartmentName(department.getDepartmentName());
                    department1.setDoctors(department.getDoctors());
                }else {
                    System.out.println("This department id: "+id+" not found!");
                }
            }
        }
        return "Department successfully updated!";
    }
}
