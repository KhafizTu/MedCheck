package service.impl;

import classes.Department;
import dao.DepartmentDao;
import dao.impl.DepartmentDaoImpl;
import service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    DepartmentDao dep = new DepartmentDaoImpl();

    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        return dep.addDepartmentToHospital(id,department);
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return dep.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return dep.findDepartmentByName(name);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        dep.deleteDepartmentById(id);
    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        return dep.updateDepartmentById(id, department);
    }
}
