/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.maryanto.dimas.resto.restoapi.controller;

import com.gmail.maryanto.dimas.resto.restoapi.dao.DepartmentDao;
import com.gmail.maryanto.dimas.resto.restoapi.entity.Department;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author dimmaryanto93
 */
@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
    
    @Autowired
    private DepartmentDao repo;
    
    @GetMapping("/list")
    public List<Department> listDepartments(){
        try {
            return repo.fetchDataDepartments();
        } catch (SQLException ex) {
            Logger.getLogger(
                    DepartmentController.class.getName()).log(Level.SEVERE, 
                            null, ex);
            return null;
        }
    }
    
    @GetMapping("/{kodeDepartment}")
    public Department listDepartments(@PathVariable Integer kodeDepartment){
        try {
            return repo.fetchDataDepartment(kodeDepartment);
        } catch (SQLException ex) {
            Logger.getLogger(
                    DepartmentController.class.getName()).log(Level.SEVERE, 
                            null, ex);
            return null;
        }
    }
    
    @PostMapping(
            path = "/simpan", 
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDepartment(@RequestBody Department d){
        try {
            repo.saveDepartment(d);
            return "simpan data berhasil";
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
            return "gagal simpan ke database!";
        }
    }
    
    @PostMapping(
            path = "/ubah", 
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDepartmentUpdated(@RequestBody Department d){
        try {
            repo.updateDepartment(d);
            return "update data berhasil";
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
            return "gagal update ke database!";
        }
    }
    
    @PostMapping(
            path = "/{departmentId}/removed", 
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDepartment(@PathVariable Integer departmentId){
        try {
            repo.removeDepartment(departmentId);
            return "data berhasil dihapus";
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
            return "gagal hapus data!";
        }
    }
    
}
