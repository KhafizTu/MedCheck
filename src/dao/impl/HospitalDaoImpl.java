package dao.impl;

import classes.Hospital;
import classes.Patient;
import dao.HospitalDao;
import database.DataBase;

import java.util.*;

public class HospitalDaoImpl implements HospitalDao {

    DataBase dataBase = new DataBase();

    @Override
    public String addHospital(Hospital hospital) {
        List<Hospital>hospitals = dataBase.getHospitals();
        if (hospitals == null){
            hospitals = new ArrayList<>();
            dataBase.getHospitals().add(hospital);
        }
        hospitals.add(hospital);
        return "Successfully added";
//        try {
//            dataBase.getHospitals().add(hospital);
//            System.out.println("Hospital added successfully !");
//            return "Hospital added successfully !";
//        } catch (ArithmeticException e) {
//            System.out.println("an error has occurred !");
//        }
//        return null;
    }

    @Override
    public Hospital findHospitalById(Long id) {
        try {
            for (Hospital h : dataBase.getHospitals()) {
                if (h.getId().equals(id)) {
                    System.out.println(h);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Can't write a letter");
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        System.out.println(dataBase.getHospitals());
        return dataBase.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        try {
            for (Hospital hos : dataBase.getHospitals()) {
                if (id.equals(hos.getId())) {
                    System.out.println("Patient in Hospital " + hos.getHospitalName() + ": " + hos.getPatients());
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Can't write a letter !");
        }
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        for (Hospital hos : dataBase.getHospitals()) {
            if (hos.getId().equals(id)) {
                dataBase.getHospitals().remove(hos);
                System.out.println("Hospital removed successfully ! ");
                return "Hospital removed successfully ! ";
            }
        }
        return null;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        try {
            Map<String, Hospital> map = new HashMap<>();
            for (Hospital h : dataBase.getHospitals()) {
                if (h.getAddress().equalsIgnoreCase(address)) {
                    map.put(h.getAddress(), h);

                    System.out.println("Address: " + h.getAddress() + "\n" + h);
                    return map;
                }
            }
        } catch (ArithmeticException e) {
            System.out.println("Unforeseen error !");
        }
        return null;
    }
}
